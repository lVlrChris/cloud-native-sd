import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "")
public class SpringConfig {

    @Bean
    public StringController stringService() {
        return new StringController();
    }
}
