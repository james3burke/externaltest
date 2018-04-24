package net.roganjosh.externaltest.test.configuration;

import net.roganjosh.externaltest.service.QuoteService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

/**
 *
 */
@Profile("test")
@Configuration
public class QuoteControllerTestConfiguration {

    @Bean
    @Primary
    public QuoteService quoteService() {
        return Mockito.mock(QuoteService.class);
    }

}
