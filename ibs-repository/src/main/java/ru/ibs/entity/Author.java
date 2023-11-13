package ru.ibs.entity;

import lombok.Getter;
import lombok.Setter;
import ru.ibs.entity.book.Book;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@Table(name = "author")
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;

    private LocalDate deathDate;

//    @ManyToMany()
//    @JoinTable(
//            name = "book_author"
//    )
//    private Set<Book> books;
}
