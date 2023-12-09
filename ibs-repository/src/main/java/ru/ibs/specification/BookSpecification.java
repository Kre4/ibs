package ru.ibs.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.ibs.entity.Author;
import ru.ibs.entity.book.Book;
import ru.ibs.entity.book.BookAuthor;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

@UtilityClass
public class BookSpecification {

    public static Specification<Book> authorName(String name) {
        return (root, query, cb) -> {
            Join<Book, BookAuthor> joinBookAuthor = root.join("authors", JoinType.INNER);
            Join<BookAuthor, Author> joinAuthor = joinBookAuthor.join("author", JoinType.INNER);
            query.distinct(true);
            return cb.like(cb.lower(joinAuthor.get("name")), "%" + name.toLowerCase() + "%");
        };
    }

    public static Specification<Book> bookName(String name) {
        return (root, query, cb) ->
            cb.like(cb.lower(root.get("name")), "%" + name.toLowerCase() + "%");
    }
}
