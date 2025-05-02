package model.entities;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"model.entities"})
@EnableJpaRepositories(basePackages = {"model.repository"})
@ComponentScan(basePackages = {"model"})
public class TestConfig {
    // This is a configuration class for testing
}