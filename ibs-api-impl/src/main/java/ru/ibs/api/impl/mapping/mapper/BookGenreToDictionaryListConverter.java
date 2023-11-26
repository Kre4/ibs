package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import ru.ibs.api.generated.model.Dictionary;
import ru.ibs.entity.book.BookGenre;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookGenreToDictionaryListConverter implements Converter<List<BookGenre>, List<Dictionary>> {
    @Override
    public List<Dictionary> convert(MappingContext<List<BookGenre>, List<Dictionary>> mappingContext) {
        if (mappingContext.getSource() != null)
            return mappingContext.getSource().stream()
                    .map(bookGenre -> {
                        Dictionary genre = new Dictionary();
                        genre.setId(bookGenre.getGenre().getId());
                        genre.setName(bookGenre.getGenre().getName());
                        genre.setSystemName(bookGenre.getGenre().getSystemName());
                        return genre;
                    })
                    .collect(Collectors.toList());
        else return Collections.emptyList();
    }
}
