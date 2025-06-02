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

class FilteringParserDelegate_FilteringParserDelegate_58_0_Test {

    private JsonParser jsonParser;

    private TokenFilter tokenFilter;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    void setUp() {
        jsonParser = mock(JsonParser.class);
        tokenFilter = mock(TokenFilter.class);
    }

    @Test
    void testFilteringParserDelegateWithIncludePathTrue() {
        filteringParserDelegate = new FilteringParserDelegate(jsonParser, tokenFilter, true, false);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    void testFilteringParserDelegateWithIncludePathFalse() {
        filteringParserDelegate = new FilteringParserDelegate(jsonParser, tokenFilter, false, true);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    void testFilteringParserDelegateWithIncludePathTrueAndAllowMultipleMatchesTrue() {
        filteringParserDelegate = new FilteringParserDelegate(jsonParser, tokenFilter, true, true);
        assertNotNull(filteringParserDelegate);
    }

    @Test
    void testFilteringParserDelegateWithIncludePathFalseAndAllowMultipleMatchesFalse() {
        filteringParserDelegate = new FilteringParserDelegate(jsonParser, tokenFilter, false, false);
        assertNotNull(filteringParserDelegate);
    }
}
