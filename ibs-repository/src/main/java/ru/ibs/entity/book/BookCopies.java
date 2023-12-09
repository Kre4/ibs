package ru.ibs.entity.book;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.ibs.entity.Status;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "books_copies")
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookCopies {

    @Id
    private Long id;

    private String systemId;

    @JoinColumn(name = "book_id")
    @ManyToOne
    private Book book;

    @JoinColumn(name = "status_id")
    @ManyToOne
    private Status status;
}
