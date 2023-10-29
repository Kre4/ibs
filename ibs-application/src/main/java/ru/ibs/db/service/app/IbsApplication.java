package ru.ibs.db.service.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;
import ru.ibs.db.service.DBServiceConfig;

@EnableAsync
@SpringBootApplication
@Import({DBServiceConfig.class,

})
@ComponentScan(basePackages = "ru.ibs")
public class IbsApplication {

    public static void main(String[] args) {
        SpringApplication.run(IbsApplication.class, args);
    }

}
