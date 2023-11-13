package ru.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {
}
