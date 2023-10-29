package ru.ibs.db.service;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@EnableCaching
@ComponentScan(basePackages = "ru.ibs")
public class DBServiceConfig {
}
