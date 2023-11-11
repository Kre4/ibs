package ru.ibs.db.service.beans.book;

import org.springframework.stereotype.Service;
import ru.ibs.db.service.beans.JpaService;
import ru.ibs.entity.book.Book;
import ru.ibs.repository.book.BookRepository;

@Service
public class BookService extends JpaService<Book, Long> {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
