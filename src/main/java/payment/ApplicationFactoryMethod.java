package payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"controller", "config", "service", "request", "response", "payment", "model", "model.entities"})
@EntityScan(basePackages = {"model.entities"})
@EnableJpaRepositories(basePackages = {"model.repository"})
public class ApplicationFactoryMethod {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFactoryMethod.class, args);
    }

}
