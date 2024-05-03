package mx.metaphorce.boosters.sr.InitialAssessment.configuration;

import mx.metaphorce.boosters.sr.InitialAssessment.init.InitialAssessmentApplication;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ActiveProfiles("Test")
@ContextConfiguration(classes = TestConfiguration.class)
public abstract class TestBase {
}
