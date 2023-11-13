package ru.ibs.api.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.BookApi;
import ru.ibs.api.generated.model.Book;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.AuthorService;
import ru.ibs.db.service.beans.book.BookAuthorService;
import ru.ibs.db.service.beans.book.BookService;
import ru.ibs.entity.Author;
import ru.ibs.entity.book.BookAuthor;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequestMapping("/api/rest")
@RestController
@AllArgsConstructor
public class BookController implements BookApi {

    private final BookService bookService;

    private final Mapper mapper;

    private final AuthorService authorService;

    private final BookAuthorService bookAuthorService;

    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        bookService.findById(id).ifPresentOrElse(bookService::deleteEntity, () -> {
            throw new EntityNotFoundException("Книга не найдена");
        });
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok(mapper.mapList(bookService.findAll(), Book.class));
    }

    @Override
    public ResponseEntity<List<Book>> findBooksBySearch(String search) {
        return ResponseEntity.ok(mapper.mapList(bookService.findAllBySearch(search), Book.class));
    }

    @Override
    public ResponseEntity<Book> getBook(Long id) {
        return ResponseEntity.ok(mapper.map(bookService.findById(id).get(), Book.class));
    }

    @Override
    @Transactional
    public ResponseEntity<Book> saveBook(Book book) {
        ru.ibs.entity.book.Book bookEntity = mapper.map(book, ru.ibs.entity.book.Book.class);
        Author author = authorService.findById(book.getAuthors().get(0).getId()).orElseThrow();
        if (bookEntity.getId() != null) {
            ru.ibs.entity.book.Book prev = bookService.findById(bookEntity.getId()).get();
            bookEntity.setAuthors(prev.getAuthors());
            bookEntity.setBookCopies(prev.getBookCopies());
            bookEntity.setGenreList(prev.getGenreList());
        }
        bookEntity = bookService.save(bookEntity);
        if (CollectionUtils.isEmpty(bookEntity.getAuthors()))
            bookAuthorService.save(BookAuthor.builder().author(author).book(bookEntity).build());
        bookEntity = bookService.findById(bookEntity.getId()).get();
        return ResponseEntity.ok(mapper.map(
                bookEntity,
                Book.class));
    }
}
