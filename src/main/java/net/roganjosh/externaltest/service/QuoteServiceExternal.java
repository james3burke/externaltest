package net.roganjosh.externaltest.service;

import net.roganjosh.externaltest.model.Quote;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 */
@Service
public class QuoteServiceExternal implements QuoteService {

    @Override
    public Quote getRandomQuote() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
    }

}
