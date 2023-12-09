package ru.ibs.db.service.beans.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import ru.ibs.db.service.beans.JpaService;
import ru.ibs.entity.user.User;

@Service
public class UserService extends JpaService<User, Long> {

    public UserService(JpaRepository<User, Long> repository) {
        super(repository);
    }
}
