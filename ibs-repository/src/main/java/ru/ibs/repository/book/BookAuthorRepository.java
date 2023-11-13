package ru.ibs.repository.book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.entity.book.BookAuthor;

@Repository
public interface BookAuthorRepository extends JpaRepository<BookAuthor, Integer> {
}
