package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.PropertyMap;
import ru.ibs.entity.book.Book;
import ru.ibs.entity.book.BookAuthor;

import java.util.stream.Collectors;

public class BookEntityToBookMapper extends PropertyMap<Book, ru.ibs.api.generated.model.Book> {
    @Override
    protected void configure() {
        map(source.getId(), destination.getId());
        map(source.getName(), destination.getName());
        map(source.getYear(), destination.getYear());
        map(source.getDescription(), destination.getDescription());
        map(source.getPublisher(), destination.getPublisher());
        map(source.getAuthors().stream().map(BookAuthor::getAuthor).collect(Collectors.toList()),
                destination.getAuthors());
        //TODO copies, genre

    }
}
