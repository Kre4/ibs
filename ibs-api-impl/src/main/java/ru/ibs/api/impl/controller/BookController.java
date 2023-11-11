package ru.ibs.api.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.BookApi;
import ru.ibs.api.generated.model.Book;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.book.BookService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequestMapping("/api/rest")
@RestController
@AllArgsConstructor
public class BookController implements BookApi {

    private final BookService bookService;

    private final Mapper mapper;

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
    public ResponseEntity<Book> getBook(Long id) {
        return ResponseEntity.ok(mapper.map(bookService.findById(id), Book.class));
    }

    @Override
    public ResponseEntity<Book> saveBook(Book book) {
        return ResponseEntity.ok(mapper.map(
                bookService.save(mapper.map(book, ru.ibs.entity.book.Book.class)),
                Book.class));
    }
}