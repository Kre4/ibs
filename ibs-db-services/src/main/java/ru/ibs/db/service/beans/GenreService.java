package ru.ibs.db.service.beans;

import org.springframework.stereotype.Service;
import ru.ibs.entity.Genre;
import ru.ibs.repository.GenreRepository;

@Service
public class GenreService extends JpaService<Genre, Long> {

    private final GenreRepository repository;

    public GenreService(GenreRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
