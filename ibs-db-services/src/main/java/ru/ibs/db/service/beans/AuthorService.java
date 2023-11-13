package ru.ibs.db.service.beans;

import org.springframework.stereotype.Service;
import ru.ibs.entity.Author;
import ru.ibs.repository.AuthorRepository;

@Service
public class AuthorService extends JpaService<Author, Integer> {

    private final AuthorRepository repository;

    public AuthorService(AuthorRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
