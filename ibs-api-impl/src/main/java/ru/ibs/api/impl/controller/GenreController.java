package ru.ibs.api.impl.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.GenreApi;
import ru.ibs.api.generated.model.Dictionary;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.GenreService;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RequestMapping("/api/rest")
@RestController
@AllArgsConstructor
public class GenreController implements GenreApi {

    private final GenreService genreService;

    private final Mapper mapper;

    @Override
    public ResponseEntity<Void> deleteGenre(Long id) {
        genreService.findById(id).ifPresentOrElse(genreService::deleteEntity, () -> {
            throw new EntityNotFoundException("Жанр не найден");
        });
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @Override
    public ResponseEntity<List<Dictionary>> findAll() {
        return ResponseEntity.ok(mapper.mapList(genreService.findAll(), Dictionary.class));
    }

    @Override
    public ResponseEntity<Dictionary> getGenre(Long id) {
        return ResponseEntity.ok(mapper.map(
                genreService.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Жанр с id " + id + " не найден")),
                Dictionary.class));
    }

    @Override
    public ResponseEntity<Dictionary> saveGenre(Dictionary dictionary) {
        return ResponseEntity.ok(mapper.map(
                genreService.save(mapper.map(dictionary, ru.ibs.entity.Genre.class)),
                Dictionary.class));
    }
}
