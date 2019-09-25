package application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"model", "service"})
public class RESTApplication {

    public static void main(String[] args) {
        SpringApplication.run(RESTApplication.class, args);
    }
}
