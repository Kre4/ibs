package ru.ibs.entity.book;

import lombok.Getter;
import lombok.Setter;
import ru.ibs.entity.Author;
import ru.ibs.entity.book.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Getter
@Setter
@Table(name = "book_author")
@Entity
public class BookAuthor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "author_id")
    @ManyToOne
    private Author author;
}
