package net.roganjosh.externaltest.rest.control;

import net.roganjosh.externaltest.model.Quote;
import net.roganjosh.externaltest.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 */
@RestController
public class QuoteController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote/random")
    public Quote getRandomQuote() {
        return quoteService.getRandomQuote();
    }

}
