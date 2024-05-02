package mx.metaphorce.boosters.sr.InitialAssessment.configuration;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@ComponentScan(basePackages = "mx.metaphorce.boosters.sr.InitialAssessment")
@EnableJpaRepositories(basePackages = "mx.metaphorce.boosters.sr.InitialAssessment.dao")
@EntityScan(basePackages = "mx.metaphorce.boosters.sr.InitialAssessment.model")
public class TestConfiguration {

}
