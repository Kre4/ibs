package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.PropertyMap;
import ru.ibs.api.generated.model.Book;

public class BookToBookEntityMapper extends PropertyMap<Book, ru.ibs.entity.book.Book> {
    @Override
    protected void configure() {
        map(source.getId(), destination.getId());
        map(source.getName(), destination.getName());
        map(source.getYear(), destination.getYear());
        map(source.getDescription(), destination.getDescription());
        map(source.getPublisher(), destination.getPublisher());
        skip(destination.getAuthors());
        skip(destination.getBookCopies());
        skip(destination.getGenreList());
    }
}
