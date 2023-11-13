package ru.ibs.entity.book;

import lombok.Getter;
import lombok.Setter;
import ru.ibs.entity.Status;
import ru.ibs.entity.book.Book;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "books_copies")
@Entity
public class BookCopies {

    @Id
    private Long id;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status status;
}
