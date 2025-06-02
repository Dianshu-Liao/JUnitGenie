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

public class FilteringParserDelegate_FilteringParserDelegate_59_0_Test {

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    private TokenFilter.Inclusion mockInclusion;

    private boolean allowMultipleMatches;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonParser = Mockito.mock(JsonParser.class);
        mockTokenFilter = Mockito.mock(TokenFilter.class);
        mockInclusion = Mockito.mock(TokenFilter.Inclusion.class);
        // Test with true and false in different tests
        allowMultipleMatches = true;
    }

    @Test
    public void testConstructor_WithValidParameters() {
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, mockInclusion, allowMultipleMatches);
        assertNotNull(filteringParserDelegate);
        assertEquals(mockTokenFilter, filteringParserDelegate.rootFilter);
        assertEquals(mockTokenFilter, filteringParserDelegate._itemFilter);
        assertEquals(mockInclusion, filteringParserDelegate._inclusion);
        assertEquals(allowMultipleMatches, filteringParserDelegate._allowMultipleMatches);
        // Assuming createRootContext returns a non-null value
        assertNotNull(filteringParserDelegate._headContext);
    }

    @Test
    public void testConstructor_WithDifferentAllowMultipleMatches() {
        allowMultipleMatches = false;
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, mockInclusion, allowMultipleMatches);
        assertNotNull(filteringParserDelegate);
        assertEquals(mockTokenFilter, filteringParserDelegate.rootFilter);
        assertEquals(mockTokenFilter, filteringParserDelegate._itemFilter);
        assertEquals(mockInclusion, filteringParserDelegate._inclusion);
        assertEquals(allowMultipleMatches, filteringParserDelegate._allowMultipleMatches);
        assertNotNull(filteringParserDelegate._headContext);
    }
}
