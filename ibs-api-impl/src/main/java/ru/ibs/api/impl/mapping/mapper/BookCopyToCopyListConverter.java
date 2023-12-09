package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.Converter;
import org.modelmapper.spi.MappingContext;
import ru.ibs.api.generated.model.BookCopy;
import ru.ibs.api.generated.model.Dictionary;
import ru.ibs.entity.book.BookCopies;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BookCopyToCopyListConverter implements Converter<List<BookCopies>, List<BookCopy>> {
    @Override
    public List<BookCopy> convert(MappingContext<List<BookCopies>, List<BookCopy>> mappingContext) {
        if (mappingContext.getSource() != null)
            return mappingContext.getSource().stream()
                    .map(bookCopy -> {
                        BookCopy copy = new BookCopy();

                        Dictionary book = new Dictionary();
                        book.setId(bookCopy.getBook().getId());

                        Dictionary status = new Dictionary();
                        status.setId(bookCopy.getStatus().getId());
                        status.setName(bookCopy.getStatus().getName());
                        status.setSystemName(bookCopy.getStatus().getSystemName());

                        copy.setBook(book);
                        copy.setStatus(status);
                        copy.setSystemId(bookCopy.getSystemId());
                        copy.setId(bookCopy.getId());
                        return copy;
                    })
                    .collect(Collectors.toList());
        else return Collections.emptyList();
    }
}
