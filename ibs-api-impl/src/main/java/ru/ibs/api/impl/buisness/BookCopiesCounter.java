package ru.ibs.api.impl.buisness;

import lombok.experimental.UtilityClass;
import ru.ibs.api.generated.model.Book;
import ru.ibs.entity.StatusEnum;

import java.util.List;

@UtilityClass
public class BookCopiesCounter {

    public static void processAndCount(List<Book> books) {
        books.forEach(book -> {
            book.setCopiesAvailable(book.getCopies()
                    .stream().filter(copy ->
                            copy.getStatus().getSystemName()
                                    .equals(StatusEnum.IN_STOCK.name()))
                    .count());

        });
    }
}
