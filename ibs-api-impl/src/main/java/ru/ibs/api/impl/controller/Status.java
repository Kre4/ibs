package ru.ibs.api.impl.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ibs.api.generated.api.BookStatusApi;
import ru.ibs.api.generated.model.Dictionary;
import ru.ibs.api.impl.mapping.Mapper;
import ru.ibs.db.service.beans.StatusService;

import java.util.List;

@RequestMapping("/api/rest")
@RestController
@AllArgsConstructor
public class Status implements BookStatusApi {

    private final StatusService statusService;

    private final Mapper mapper;

    @Override
    public ResponseEntity<List<Dictionary>> findAll() {
        return ResponseEntity.ok(mapper.mapList(statusService.findAll(), Dictionary.class));
    }
}
