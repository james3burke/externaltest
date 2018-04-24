package net.roganjosh.externaltest.rest.controller;

import net.roganjosh.externaltest.app.Application;
import net.roganjosh.externaltest.model.Quote;
import net.roganjosh.externaltest.model.Value;
import net.roganjosh.externaltest.service.QuoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.apache.coyote.http11.Constants.a;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

/**
 *
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class QuoteControllerITest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Autowired
    private QuoteService quoteService;

    @Test
    public void testRandomQuoteWithMock() {
        Value testValue = new Value();
        testValue.setId(1L);
        testValue.setQuote("random quote");
        Quote testQuote = new Quote();
        testQuote.setType("Random");
        testQuote.setValue(testValue);
        when(quoteService.getRandomQuote()).thenReturn(testQuote);

        Quote result = testRestTemplate.getForObject(getHost() + "/quote/random", Quote.class);
        assertNotNull(result);
        assertEquals("Random", result.getType());
        assertEquals(new Long(1), result.getValue().getId());
        assertEquals("random quote", result.getValue().getQuote());
    }

    private String getHost() {
        return "http://localhost:" + port;
    }

}
