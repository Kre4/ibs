package ru.ibs.api.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.AuthorApi;
import ru.ibs.api.generated.model.Author;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.AuthorService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequestMapping("/api/rest")
@RestController
@AllArgsConstructor
public class AuthorController implements AuthorApi {

    private final AuthorService authorService;

    private final Mapper mapper;

    @Override
    public ResponseEntity<Void> deleteAuthor(Long id) {
        authorService.findById(id).ifPresentOrElse(authorService::deleteEntity, () -> {
            throw new EntityNotFoundException("Автор не найден");
        });
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Author>> findAll() {
        return ResponseEntity.ok(mapper.mapList(authorService.findAll(), Author.class));
    }

    @Override
    public ResponseEntity<Author> getAuthor(Long id) {
        return ResponseEntity.ok(mapper.map(
                authorService.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Автор с id " + id + " не найден")),
                Author.class));
    }

    @Override
    public ResponseEntity<Author> saveAuthor(Author author) {
        return ResponseEntity.ok(mapper.map(
                authorService.save(mapper.map(author, ru.ibs.entity.Author.class)),
                Author.class));
    }
}
