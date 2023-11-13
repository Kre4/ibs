package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.PropertyMap;
import ru.ibs.entity.book.Book;

public class BookEntityToBookMapper extends PropertyMap<Book, ru.ibs.api.generated.model.Book> {
    @Override
    protected void configure() {
        map(source.getId(), destination.getId());
        map(source.getName(), destination.getName());
        map(source.getYear(), destination.getYear());
        map(source.getDescription(), destination.getDescription());
        map(source.getPublisher(), destination.getPublisher());
        using(new BookAuthorListToAuthorListConverter()).map(source.getAuthors(), destination.getAuthors());
        //TODO copies, genre

    }
}
