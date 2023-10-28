package ru.ibs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.ibs.entity.User;

/**
 * Example repository of user
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
