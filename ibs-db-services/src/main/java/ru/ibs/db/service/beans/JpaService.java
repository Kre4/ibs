package ru.ibs.db.service.beans;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class JpaService<T, ID> {

    protected final JpaRepository<T, ID> jpaRepository;

    public JpaService(JpaRepository<T, ID> repository) {
        this.jpaRepository = repository;
    }

    public Optional<T> findById(ID id) {
        return this.jpaRepository.findById(id);
    }

    public List<T> findAll() {
        return jpaRepository.findAll();
    }

    public T save(T entity) {
        return this.jpaRepository.save(entity);
    }

    public List<T> saveAll(Iterable<T> iterable) {
        return this.jpaRepository.saveAll(iterable);
    }

    public void deleteEntity(T entity) {
        this.jpaRepository.delete(entity);
    }

    public void deleteById(ID id) {
        this.jpaRepository.deleteById(id);
    }

    public void deleteAll(Iterable<T> items) {
        this.jpaRepository.deleteAll(items);
    }
}
