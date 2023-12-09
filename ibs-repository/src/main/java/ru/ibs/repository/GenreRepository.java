package ru.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.entity.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
