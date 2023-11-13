package ru.ibs.api.impl.mapping.mapper;

import org.modelmapper.PropertyMap;
import ru.ibs.entity.Author;

public class AuthorEntityToAuthorMapper extends PropertyMap<Author, ru.ibs.api.generated.model.Author> {
    @Override
    protected void configure() {
        map(source.getId(), destination.getId());
        map(source.getName(), destination.getName());
        map(source.getBirthDate(), destination.getBirthDate());
        map(source.getDeathDate(), destination.getDeathDate());
    }
}
