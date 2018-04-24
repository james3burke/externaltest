package net.roganjosh.externaltest.rest.controller;

import net.roganjosh.externaltest.model.Quote;
import net.roganjosh.externaltest.model.Value;
import net.roganjosh.externaltest.rest.control.QuoteController;
import net.roganjosh.externaltest.service.QuoteService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.web.client.RestClientException;

import static javafx.scene.input.KeyCode.Q;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.when;

/**
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class QuoteControllerTest {

    @Mock
    QuoteService quoteService;

    @InjectMocks
    QuoteController quoteController;

    @Test
    public void testRandomQuoteSuccess() {
        Value testValue = new Value();
        testValue.setId(1L);
        testValue.setQuote("random quote");
        Quote testQuote = new Quote();
        testQuote.setType("Random");
        testQuote.setValue(testValue);
        when(quoteService.getRandomQuote()).thenReturn(testQuote);

        Quote result = quoteController.getRandomQuote();
        assertNotNull(result);
        assertEquals(testQuote, result);
        assertEquals(testValue, result.getValue());
    }

    @Test(expected = RestClientException.class)
    public void testRandomQuoteFailure() {
        when(quoteService.getRandomQuote()).thenThrow(new RestClientException("mock error"));
        quoteService.getRandomQuote();
    }

}
