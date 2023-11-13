package ru.ibs.entity.book;

import lombok.Getter;
import lombok.Setter;
import ru.ibs.entity.Genre;
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
@Table(name = "book_genre")
@Entity
public class BookGenre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "genre_id")
    @ManyToOne
    private Genre genre;
}
