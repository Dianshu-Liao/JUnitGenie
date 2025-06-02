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

public class FilteringParserDelegate_clearCurrentToken_18_0_Test {

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() {
        // Initializing FilteringParserDelegate with null tokens for the test
        filteringParserDelegate = new FilteringParserDelegate(null, null, false, false);
    }

    @Test
    public void testClearCurrentToken_WhenCurrentTokenIsNull() {
        // Arrange
        filteringParserDelegate._currToken = null;
        // Act
        filteringParserDelegate.clearCurrentToken();
        // Assert
        assertNull(filteringParserDelegate._lastClearedToken, "Last cleared token should be null when current token is null.");
    }

    @Test
    public void testClearCurrentToken_WhenCurrentTokenIsNotNull() {
        // Arrange
        // Set current token to a non-null value
        filteringParserDelegate._currToken = JsonToken.START_OBJECT;
        // Act
        filteringParserDelegate.clearCurrentToken();
        // Assert
        assertEquals(JsonToken.START_OBJECT, filteringParserDelegate._lastClearedToken, "Last cleared token should be the same as the current token.");
        assertNull(filteringParserDelegate._currToken, "Current token should be reset to null after clearing.");
    }
}
