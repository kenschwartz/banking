package com.kennethmschwartz.app.banking;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@Slf4j
@EnableConfigurationProperties
@SpringBootApplication
public class OpenBankingAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpenBankingAppApplication.class, args);
        log.info(String.format("Starting application: %s", OpenBankingAppApplication.class.getName()));
    }

    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext ctx) {
        return args -> {

            log.debug("Let's inspect the beans provided by Spring Boot:");

            final String[] beanNames = ctx.getBeanDefinitionNames();
            //Arrays.sort(beanNames);
            for (final String beanName : beanNames) {
                log.debug(String.format("Configured bean: %s", beanName));
            }
        };
    }

}
