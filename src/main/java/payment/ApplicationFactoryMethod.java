package payment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"payment.model.entities"})
@EnableJpaRepositories(basePackages = {"payment.model.repository"})
public class ApplicationFactoryMethod {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationFactoryMethod.class, args);
    }

}
