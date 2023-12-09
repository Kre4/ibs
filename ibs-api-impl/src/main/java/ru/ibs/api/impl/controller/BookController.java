package ru.ibs.api.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.BookApi;
import ru.ibs.api.generated.model.Book;
import ru.ibs.api.impl.buisness.BookCopiesCounter;
import ru.ibs.api.impl.buisness.BookSaveService;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.AuthorService;
import ru.ibs.db.service.beans.book.BookAuthorService;
import ru.ibs.db.service.beans.book.BookService;
import ru.ibs.entity.StatusEnum;

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

    private final BookSaveService bookSaveService;

    @Override
    public ResponseEntity<Void> deleteBook(Long id) {
        bookService.findById(id).ifPresentOrElse(bookService::deleteEntity, () -> {
            throw new EntityNotFoundException("Книга не найдена");
        });
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Book>> findAll() {
        List<Book> response = mapper.mapList(bookService.findAll(), Book.class);
        BookCopiesCounter.processAndCount(response);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<List<Book>> findBooksBySearch(String search) {
        List<Book> response = mapper.mapList(bookService.findAllBySearch(search), Book.class);
        BookCopiesCounter.processAndCount(response);
        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<Book> getBook(Long id) {
        return ResponseEntity.ok(mapper.map(bookService.findById(id).orElseThrow(), Book.class));
    }

    @Override
    @Transactional
    public ResponseEntity<Book> saveBook(Book book) {
        return ResponseEntity.ok(mapper.map(bookSaveService.saveBook(book), Book.class));
    }
}
