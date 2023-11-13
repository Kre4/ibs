package ru.ibs.db.service.beans.book;

import org.springframework.stereotype.Service;
import ru.ibs.db.service.beans.JpaService;
import ru.ibs.entity.book.BookAuthor;
import ru.ibs.repository.book.BookAuthorRepository;

@Service
public class BookAuthorService extends JpaService<BookAuthor, Integer> {

    public BookAuthorService(BookAuthorRepository repository) {
        super(repository);
    }
}
