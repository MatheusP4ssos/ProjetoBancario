package MatheusP4ssos.com.github.ProjetoBancario.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BankingUtils {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

}