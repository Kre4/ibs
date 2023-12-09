package ru.ibs.db.service.beans.book;

import org.springframework.stereotype.Service;
import ru.ibs.db.service.beans.JpaService;
import ru.ibs.entity.book.BookCopies;
import ru.ibs.repository.book.BookCopiesRepository;

@Service
public class BookCopyService extends JpaService<BookCopies, Long> {
    public BookCopyService(BookCopiesRepository repository) {
        super(repository);
    }
}
