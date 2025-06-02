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

public class FilteringParserDelegate_FilteringParserDelegate_58_2_Test {

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    private boolean includePath;

    private boolean allowMultipleMatches;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects and test parameters
        mockJsonParser = org.mockito.Mockito.mock(JsonParser.class);
        // Using the static INCLUDE_ALL filter
        mockTokenFilter = TokenFilter.INCLUDE_ALL;
        // Test with path included
        includePath = true;
        // Test without allowing multiple matches
        allowMultipleMatches = false;
    }

    @Test
    public void testFilteringParserDelegate_WithIncludePath_AllowMultipleMatches() {
        FilteringParserDelegate filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, true, true);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    public void testFilteringParserDelegate_WithIncludePath_NoAllowMultipleMatches() {
        FilteringParserDelegate filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, true, false);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    public void testFilteringParserDelegate_WithoutIncludePath_AllowMultipleMatches() {
        FilteringParserDelegate filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, false, true);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    public void testFilteringParserDelegate_WithoutIncludePath_NoAllowMultipleMatches() {
        FilteringParserDelegate filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, false, false);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    public void testFilteringParserDelegate_NullJsonParser() {
        assertThrows(NullPointerException.class, () -> {
            new FilteringParserDelegate(null, mockTokenFilter, true, true);
        });
    }

    @Test
    public void testFilteringParserDelegate_NullTokenFilter() {
        assertThrows(NullPointerException.class, () -> {
            new FilteringParserDelegate(mockJsonParser, null, true, true);
        });
    }
}
