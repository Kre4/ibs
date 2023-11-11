package ru.ibs.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.entity.book.BookCopies;

@Repository
public interface BookCopiesRepository extends JpaRepository<BookCopies, Long> {
}
