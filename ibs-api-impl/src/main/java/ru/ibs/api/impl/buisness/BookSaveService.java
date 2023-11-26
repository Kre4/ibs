package ru.ibs.api.impl.buisness;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.AuthorService;
import ru.ibs.db.service.beans.book.BookAuthorService;
import ru.ibs.db.service.beans.book.BookService;
import ru.ibs.entity.Author;
import ru.ibs.entity.book.Book;
import ru.ibs.entity.book.BookAuthor;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookSaveService {

    private final BookService bookService;

    private final AuthorService authorService;

    private final Mapper mapper;

    @Transactional
    public Book saveBook(ru.ibs.api.generated.model.Book book) {
        ru.ibs.entity.book.Book bookEntity = null;
        if (book.getId() != null) {
            bookEntity = bookService.findById(book.getId()).orElseThrow();
            mapper.map(book, bookEntity);
//            prev.getBookCopies().clear();
//            prev.getGenreList().clear();
        } else {
            bookEntity = mapper.map(book, ru.ibs.entity.book.Book.class);
        }

        fillAuthors(bookEntity, book.getAuthors());
        bookEntity = bookService.save(bookEntity);

        return bookEntity;
    }

    private void fillAuthors(Book bookEntity, List<ru.ibs.api.generated.model.Author> authorList) {
        if (bookEntity.getAuthors() == null) {
            bookEntity.setAuthors(new ArrayList<>());
        } else {
            bookEntity.getAuthors().clear();
        }
        authorList.forEach(authorId -> {
            Author author = authorService.findById(authorId.getId()).orElseThrow();
            bookEntity.getAuthors().add(BookAuthor.builder().author(author).book(bookEntity).build());
        });
    }
}
