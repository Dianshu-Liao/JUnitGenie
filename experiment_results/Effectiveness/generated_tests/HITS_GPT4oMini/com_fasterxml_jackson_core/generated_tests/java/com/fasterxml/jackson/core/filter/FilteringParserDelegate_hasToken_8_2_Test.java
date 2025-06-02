package com.fasterxml.jackson.core.filter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

@ExtendWith(MockitoExtension.class)
public class FilteringParserDelegate_hasToken_8_2_Test {

    private FilteringParserDelegate filteringParserDelegate;

    @Mock
    private JsonParser mockJsonParser;

    @BeforeEach
    public void setUp() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, TokenFilter.INCLUDE_ALL, true, true);
    }

    @Test
    public void testHasToken_WhenCurrentTokenIsNull_ShouldReturnFalse() {
        // Arrange
        filteringParserDelegate._currToken = null;
        // Act
        boolean result = filteringParserDelegate.hasToken(JsonToken.VALUE_STRING);
        // Assert
        assertFalse(result, "Expected hasToken to return false when current token is null.");
    }

    @Test
    public void testHasToken_WhenCurrentTokenMatches_ShouldReturnTrue() {
        // Arrange
        filteringParserDelegate._currToken = JsonToken.VALUE_STRING;
        // Act
        boolean result = filteringParserDelegate.hasToken(JsonToken.VALUE_STRING);
        // Assert
        assertTrue(result, "Expected hasToken to return true when current token matches.");
    }

    @Test
    public void testHasToken_WhenCurrentTokenDoesNotMatch_ShouldReturnFalse() {
        // Arrange
        filteringParserDelegate._currToken = JsonToken.VALUE_NUMBER_INT;
        // Act
        boolean result = filteringParserDelegate.hasToken(JsonToken.VALUE_STRING);
        // Assert
        assertFalse(result, "Expected hasToken to return false when current token does not match.");
    }
}
