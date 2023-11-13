package ru.ibs.db.service.beans.book;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import ru.ibs.db.service.beans.JpaService;
import ru.ibs.entity.book.Book;
import ru.ibs.repository.book.BookRepository;
import ru.ibs.specification.BookSpecification;

import java.util.List;
import java.util.stream.IntStream;

@Service
public class BookService extends JpaService<Book, Long> {

    private BookRepository repository;

    public BookService(BookRepository repository) {
        super(repository);
        this.repository = repository;
    }

    public List<Book> findAllBySearch(String search) {
        if (search.length() > 256)
            throw new IllegalArgumentException("Слишком длинное название");
        return this.repository.findAll(buildSpecification(search));
    }

    private Specification<Book> buildSpecification(String search) {
        Specification<Book> specification = BookSpecification.bookName(search).or(BookSpecification.authorName(search));
        String firstSubstring;
        String secondSubstring;
        for (int i = 0; i < search.length(); ++i) {
            if (search.charAt(i) == ' ') {
                firstSubstring = search.substring(0, i);
                secondSubstring = search.substring(i + 1);
                specification = specification.or(
                        specification.or(BookSpecification.authorName(firstSubstring))
                                .or(BookSpecification.bookName(secondSubstring))
                ).or(
                        specification.or(BookSpecification.bookName(firstSubstring))
                                .or(BookSpecification.authorName(secondSubstring))
                );
            }
        }

        return specification;
    }
}
