package ru.ibs.db.service.beans;

import org.springframework.stereotype.Service;
import ru.ibs.entity.Status;
import ru.ibs.repository.StatusRepository;

@Service
public class StatusService extends JpaService<Status, Long> {

    private final StatusRepository repository;

    public StatusService(StatusRepository repository) {
        super(repository);
        this.repository = repository;
    }

}
