package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;

import ru.ibs.api.generated.model.Author;
import ru.ibs.entity.book.BookAuthor;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookAuthorListToAuthorListConverter implements Converter<List<BookAuthor>, List<Author>> {
    @Override
    public List<Author> convert(MappingContext<List<BookAuthor>, List<Author>> mappingContext) {
        if (mappingContext.getSource() != null)
            return mappingContext.getSource().stream()
                    .map(bookAuthor -> {
                        Author author = new Author();
                        author.setId(bookAuthor.getAuthor().getId());
                        author.setName(bookAuthor.getAuthor().getName());
                        author.setBirthDate(bookAuthor.getAuthor().getBirthDate());
                        author.setDeathDate(bookAuthor.getAuthor().getDeathDate());
                        return author;
                    })
                    .collect(Collectors.toList());
        else return Collections.emptyList();
    }
}
