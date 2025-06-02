package com.fasterxml.jackson.core.filter;

import java.lang.reflect.Field;
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

class FilteringParserDelegate_hasToken_8_1_Test {

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    void setUp() {
        TokenFilter tokenFilter = TokenFilter.INCLUDE_ALL;
        TokenFilterContext context = TokenFilterContext.createRootContext(tokenFilter);
        filteringParserDelegate = new FilteringParserDelegate(null, tokenFilter, true, false);
        // Setting the _currToken field directly for testing purposes
        setPrivateField(filteringParserDelegate, "_currToken", JsonToken.VALUE_STRING);
    }

    @Test
    void testHasTokenReturnsTrueForMatchingToken() {
        assertTrue(filteringParserDelegate.hasToken(JsonToken.VALUE_STRING));
    }

    @Test
    void testHasTokenReturnsFalseForNonMatchingToken() {
        assertFalse(filteringParserDelegate.hasToken(JsonToken.VALUE_NUMBER_INT));
    }

    @Test
    void testHasTokenReturnsFalseWhenCurrentTokenIsNull() {
        setPrivateField(filteringParserDelegate, "_currToken", null);
        assertFalse(filteringParserDelegate.hasToken(JsonToken.VALUE_STRING));
    }

    private void setPrivateField(Object obj, String fieldName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception e) {
            throw new RuntimeException("Failed to set private field: " + e.getMessage(), e);
        }
    }
}
