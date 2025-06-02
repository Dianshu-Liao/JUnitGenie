package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class FilteringParserDelegate__verifyAllowedMatches_25_0_Test {

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() {
        JsonParser mockParser = mock(JsonParser.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        filteringParserDelegate = new FilteringParserDelegate(mockParser, mockFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, false);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsZero_ShouldReturnTrue() throws Exception {
        // Invoke the private method using reflection
        Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filteringParserDelegate);
        assertTrue(result);
    }

    @Test
    public void testVerifyAllowedMatches_WhenAllowMultipleMatchesIsTrue_ShouldReturnTrue() throws Exception {
        // Set allowMultipleMatches to true
        filteringParserDelegate._allowMultipleMatches = true;
        // Invoke the private method using reflection
        Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filteringParserDelegate);
        assertTrue(result);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsGreaterThanZeroAndAllowMultipleMatchesIsFalse_ShouldReturnFalse() throws Exception {
        // Set matchCount to 1
        filteringParserDelegate._matchCount = 1;
        // Invoke the private method using reflection
        Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filteringParserDelegate);
        assertFalse(result);
    }

    @Test
    public void testVerifyAllowedMatches_WhenMatchCountIsOneAndAllowMultipleMatchesIsFalse_ShouldReturnTrue() throws Exception {
        // Set matchCount to 1 and allowMultipleMatches to false
        filteringParserDelegate._matchCount = 1;
        filteringParserDelegate._allowMultipleMatches = false;
        // Invoke the private method using reflection
        Method method = FilteringParserDelegate.class.getDeclaredMethod("_verifyAllowedMatches");
        method.setAccessible(true);
        boolean result = (Boolean) method.invoke(filteringParserDelegate);
        assertTrue(result);
    }
}
