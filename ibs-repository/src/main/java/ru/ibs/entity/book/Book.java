package ru.ibs.entity.book;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import ru.ibs.entity.Author;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Getter
@Setter
@Table(name = "book")
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer year;

    private String description;

    private String publisher;

    @OneToMany(mappedBy = "book")
    @Fetch(FetchMode.SUBSELECT)
    private List<BookAuthor> authors;

    @OneToMany(mappedBy = "book")
    @Fetch(FetchMode.SUBSELECT)
    private List<BookGenre> genreList;

    @OneToMany(mappedBy = "book")
    @Fetch(FetchMode.SUBSELECT)
    private List<BookCopies> bookCopies;
}
