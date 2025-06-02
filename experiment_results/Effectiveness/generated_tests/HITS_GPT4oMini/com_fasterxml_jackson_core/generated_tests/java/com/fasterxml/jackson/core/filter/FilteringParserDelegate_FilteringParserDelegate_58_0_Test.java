package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class FilteringParserDelegate_FilteringParserDelegate_58_0_Test {

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects
        mockJsonParser = mock(JsonParser.class);
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
    }

    @Test
    public void testFilteringParserDelegate_WithIncludePath() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, Inclusion.INCLUDE_ALL_AND_PATH, false);
        assertNotNull(filteringParserDelegate);
        assertEquals(Inclusion.INCLUDE_ALL_AND_PATH, filteringParserDelegate._inclusion);
    }

    @Test
    public void testFilteringParserDelegate_WithoutIncludePath() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, Inclusion.ONLY_INCLUDE_ALL, true);
        assertNotNull(filteringParserDelegate);
        assertEquals(Inclusion.ONLY_INCLUDE_ALL, filteringParserDelegate._inclusion);
    }

    @Test
    public void testFilteringParserDelegate_WithAllowMultipleMatches() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, Inclusion.INCLUDE_ALL_AND_PATH, true);
        assertNotNull(filteringParserDelegate);
        assertEquals(Inclusion.INCLUDE_ALL_AND_PATH, filteringParserDelegate._inclusion);
        assertTrue(filteringParserDelegate._allowMultipleMatches);
    }

    @Test
    public void testFilteringParserDelegate_WithoutAllowMultipleMatches() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, Inclusion.ONLY_INCLUDE_ALL, false);
        assertNotNull(filteringParserDelegate);
        assertEquals(Inclusion.ONLY_INCLUDE_ALL, filteringParserDelegate._inclusion);
        assertFalse(filteringParserDelegate._allowMultipleMatches);
    }
}
