package ru.ibs.api.impl.buisness;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.ibs.api.generated.model.BookCopy;
import ru.ibs.api.generated.model.Dictionary;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.AuthorService;
import ru.ibs.db.service.beans.GenreService;
import ru.ibs.db.service.beans.StatusService;
import ru.ibs.db.service.beans.book.BookCopyService;
import ru.ibs.db.service.beans.book.BookService;
import ru.ibs.entity.Author;
import ru.ibs.entity.Genre;
import ru.ibs.entity.Status;
import ru.ibs.entity.book.Book;
import ru.ibs.entity.book.BookAuthor;
import ru.ibs.entity.book.BookCopies;
import ru.ibs.entity.book.BookGenre;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class BookSaveService {

    private final BookService bookService;

    private final AuthorService authorService;

    private final GenreService genreService;

    private final BookCopyService bookCopyService;

    private final StatusService statusService;

    private final Mapper mapper;

    @Transactional
    public Book saveBook(ru.ibs.api.generated.model.Book book) {
        ru.ibs.entity.book.Book bookEntity = null;
        if (book.getId() != null) {
            bookEntity = bookService.findById(book.getId()).orElseThrow();
            mapper.map(book, bookEntity);
//            prev.getBookCopies().clear();
            bookEntity.getGenreList().clear();
        } else {
            bookEntity = mapper.map(book, ru.ibs.entity.book.Book.class);
        }

        fillAuthors(bookEntity, book.getAuthors());
        fillGenres(bookEntity, book.getGenreList());
        fillCopies(bookEntity, book.getCopies());
        bookEntity = bookService.save(bookEntity);

        return bookEntity;
    }

    private void fillAuthors(Book bookEntity, List<ru.ibs.api.generated.model.Author> authorList) {
        if (bookEntity.getAuthors() == null) {
            bookEntity.setAuthors(new ArrayList<>());
        } else {
            bookEntity.getAuthors().clear();
        }
        authorList.forEach(authorId -> {
            Author author = authorService.findById(authorId.getId()).orElseThrow();
            bookEntity.getAuthors().add(BookAuthor.builder().author(author).book(bookEntity).build());
        });
    }

    private void fillGenres(Book bookEntity, List<Dictionary> genreList) {
        if (bookEntity.getGenreList() == null) {
            bookEntity.setGenreList(new ArrayList<>());
        } else {
            bookEntity.getGenreList().clear();
        }
        genreList.forEach(genre -> {
            Genre genreEntity = genreService.findById(genre.getId()).orElseThrow();
            bookEntity.getGenreList().add(BookGenre.builder().genre(genreEntity).book(bookEntity).build());
        });
    }

    private void fillCopies(Book bookEntity, List<BookCopy> copyList) {
        if (bookEntity.getBookCopies() == null) {
            bookEntity.setGenreList(new ArrayList<>());
        } else {
            bookEntity.getBookCopies().clear();
        }
        copyList.forEach(bookCopy -> {
            BookCopies bookCopyEntity = bookCopyService.findById(bookCopy.getId()).orElseThrow();
            Status status = statusService.findById(bookCopy.getStatus().getId()).orElseThrow();
            bookEntity.getBookCopies().add(
                    BookCopies.builder()
                            .id(bookCopy.getId())
                            .status(status)
                            .book(bookEntity)
                            .systemId(bookCopy.getSystemId())
                            .build()
            );
        });
    }
}
