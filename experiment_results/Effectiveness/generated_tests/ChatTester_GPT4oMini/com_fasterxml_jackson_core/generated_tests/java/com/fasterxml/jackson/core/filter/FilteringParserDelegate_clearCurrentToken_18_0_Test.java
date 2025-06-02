package com.fasterxml.jackson.core.filter;

import java.lang.reflect.Method;
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

    private JsonParser mockJsonParser;

    private TokenFilter mockTokenFilter;

    private TokenFilter.Inclusion mockInclusion;

    @BeforeEach
    public void setUp() {
        // Initialize mock objects as needed
        // Replace with actual mock if necessary
        mockJsonParser = null;
        // Replace with actual mock if necessary
        mockTokenFilter = null;
        // Replace with actual mock if necessary
        mockInclusion = null;
        filteringParserDelegate = new FilteringParserDelegate(mockJsonParser, mockTokenFilter, mockInclusion, true);
    }

    @Test
    public void testClearCurrentToken_WhenCurrTokenIsNotNull() throws Exception {
        // Set up the state
        setCurrToken(JsonToken.VALUE_STRING);
        // Verify the current token is set
        assertNotNull(filteringParserDelegate._currToken);
        // Invoke the focal method
        filteringParserDelegate.clearCurrentToken();
        // Verify the behavior
        assertNull(filteringParserDelegate._currToken);
        assertNotNull(filteringParserDelegate._lastClearedToken);
    }

    @Test
    public void testClearCurrentToken_WhenCurrTokenIsNull() throws Exception {
        // Ensure current token is null
        filteringParserDelegate.clearCurrentToken();
        // Verify the behavior
        assertNull(filteringParserDelegate._currToken);
        assertNull(filteringParserDelegate._lastClearedToken);
    }

    // Reflection method to set _currToken for testing purposes
    private void setCurrToken(JsonToken token) throws Exception {
        java.lang.reflect.Field field = FilteringParserDelegate.class.getDeclaredField("_currToken");
        field.setAccessible(true);
        field.set(filteringParserDelegate, token);
    }
}
