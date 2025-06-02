package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class FilteringParserDelegate__verifyAllowedMatches_25_4_Test {

    private FilteringParserDelegate filteringParserDelegate;

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    @BeforeEach
    public void setUp() {
        // Mock dependencies
        mockJsonParser = Mockito.mock(JsonParser.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
    }

    private boolean invokeVerifyAllowedMatches() throws Exception {
        Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
        method.setAccessible(true);
        return (Boolean) method.invoke(filteringParserDelegate);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsZero() throws IOException, Exception {
        // Arrange
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, TokenFilter.Inclusion.valueOf("INCLUDE_ALL"), false);
        filteringParserDelegate._matchCount = 0;
        filteringParserDelegate._allowMultipleMatches = false;
        // Act
        boolean result = invokeVerifyAllowedMatches();
        // Assert
        assertTrue(result);
        assertEquals(1, filteringParserDelegate._matchCount);
    }

    @Test
    public void testVerifyAllowedMatches_WhenAllowMultipleMatchesIsTrue() throws IOException, Exception {
        // Arrange
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, TokenFilter.Inclusion.valueOf("INCLUDE_ALL"), true);
        filteringParserDelegate._matchCount = 5;
        filteringParserDelegate._allowMultipleMatches = true;
        // Act
        boolean result = invokeVerifyAllowedMatches();
        // Assert
        assertTrue(result);
        assertEquals(6, filteringParserDelegate._matchCount);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsNonZeroAndAllowMultipleMatchesIsFalse() throws IOException, Exception {
        // Arrange
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, TokenFilter.Inclusion.valueOf("INCLUDE_ALL"), false);
        filteringParserDelegate._matchCount = 1;
        filteringParserDelegate._allowMultipleMatches = false;
        // Act
        boolean result = invokeVerifyAllowedMatches();
        // Assert
        assertFalse(result);
        assertEquals(1, filteringParserDelegate._matchCount);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsGreaterThanZeroAndAllowMultipleMatchesIsTrue() throws IOException, Exception {
        // Arrange
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, TokenFilter.Inclusion.valueOf("INCLUDE_ALL"), true);
        filteringParserDelegate._matchCount = 3;
        filteringParserDelegate._allowMultipleMatches = true;
        // Act
        boolean result = invokeVerifyAllowedMatches();
        // Assert
        assertTrue(result);
        assertEquals(4, filteringParserDelegate._matchCount);
    }
}
