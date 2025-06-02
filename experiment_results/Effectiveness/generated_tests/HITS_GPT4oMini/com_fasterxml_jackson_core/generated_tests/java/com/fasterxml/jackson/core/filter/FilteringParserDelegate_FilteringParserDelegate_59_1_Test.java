package com.fasterxml.jackson.core.filter;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import static com.fasterxml.jackson.core.JsonTokenId.*;

class FilteringParserDelegate_FilteringParserDelegate_59_1_Test {

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    private Inclusion mockInclusion;

    private boolean allowMultipleMatches;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    void setUp() {
        mockJsonParser = mock(JsonParser.class);
        mockTokenFilter = mock(TokenFilter.class);
        // Use a mock for Inclusion since we don't have its implementation details
        mockInclusion = mock(Inclusion.class);
        allowMultipleMatches = true;
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, mockInclusion, allowMultipleMatches);
    }

    @Test
    void testConstructor_initializesFieldsCorrectly() {
        assertNotNull(filteringParserDelegate.rootFilter);
        assertEquals(mockTokenFilter, filteringParserDelegate.rootFilter);
        assertTrue(filteringParserDelegate._allowMultipleMatches);
        assertEquals(mockInclusion, filteringParserDelegate._inclusion);
        assertNotNull(filteringParserDelegate._headContext);
        assertNotNull(filteringParserDelegate._itemFilter);
    }

    @Test
    void testConstructor_withDifferentParameters() {
        // Use the predefined constant
        TokenFilter differentTokenFilter = TokenFilter.INCLUDE_ALL;
        // Mocking Inclusion since we cannot use EXCLUDE_ALL
        Inclusion differentInclusion = mock(Inclusion.class);
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, differentTokenFilter, differentInclusion, false);
        assertEquals(differentTokenFilter, filteringParserDelegate.rootFilter);
        assertFalse(filteringParserDelegate._allowMultipleMatches);
        assertEquals(differentInclusion, filteringParserDelegate._inclusion);
    }
}
