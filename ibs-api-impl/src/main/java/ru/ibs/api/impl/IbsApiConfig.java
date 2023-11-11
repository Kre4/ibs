package ru.ibs.api.impl;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@EnableAutoConfiguration
@ComponentScan(basePackages = "ru.ibs")
public class IbsApiConfig {
}
