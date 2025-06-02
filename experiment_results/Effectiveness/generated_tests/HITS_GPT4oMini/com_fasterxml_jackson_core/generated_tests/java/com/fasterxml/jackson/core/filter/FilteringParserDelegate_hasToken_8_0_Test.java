package com.fasterxml.jackson.core.filter;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class FilteringParserDelegate_hasToken_8_0_Test {

    private FilteringParserDelegate filteringParserDelegate;

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    @BeforeEach
    public void setUp() {
        mockJsonParser = mock(JsonParser.class);
        // Using the static INCLUDE_ALL filter
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, true, false);
    }

    @Test
    public void testHasTokenReturnsTrueWhenCurrentTokenMatches() {
        // Simulate setting the current token
        filteringParserDelegate._currToken = JsonToken.VALUE_STRING;
        assertTrue(filteringParserDelegate.hasToken(JsonToken.VALUE_STRING));
    }

    @Test
    public void testHasTokenReturnsFalseWhenCurrentTokenDoesNotMatch() {
        // Simulate setting a different current token
        filteringParserDelegate._currToken = JsonToken.VALUE_NUMBER_INT;
        assertFalse(filteringParserDelegate.hasToken(JsonToken.VALUE_STRING));
    }

    @Test
    public void testHasTokenReturnsFalseWhenCurrentTokenIsNull() {
        // Simulate no current token
        filteringParserDelegate._currToken = null;
        assertFalse(filteringParserDelegate.hasToken(JsonToken.VALUE_STRING));
    }
}
