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

public class FilteringParserDelegate_clearCurrentToken_18_0_Test {

    private JsonParser mockParser;

    private TokenFilter mockFilter;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() {
        mockParser = mock(JsonParser.class);
        mockFilter = mock(TokenFilter.class);
        filteringParserDelegate = new FilteringParserDelegate(mockParser, mockFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
    }

    @Test
    public void testClearCurrentToken_WhenCurrentTokenIsNull() throws Exception {
        // Act
        filteringParserDelegate.clearCurrentToken();
        // Assert
        JsonToken lastClearedToken = getPrivateField(filteringParserDelegate, "_lastClearedToken");
        assertNull(lastClearedToken);
    }

    @Test
    public void testClearCurrentToken_WhenCurrentTokenIsNotNull() throws Exception {
        // Arrange
        setPrivateField(filteringParserDelegate, "_currToken", JsonToken.VALUE_STRING);
        // Act
        filteringParserDelegate.clearCurrentToken();
        // Assert
        JsonToken lastClearedToken = getPrivateField(filteringParserDelegate, "_lastClearedToken");
        assertEquals(JsonToken.VALUE_STRING, lastClearedToken);
        assertNull(getPrivateField(filteringParserDelegate, "_currToken"));
    }

    @Test
    public void testClearCurrentToken_ChangesLastClearedToken() throws Exception {
        // Arrange
        setPrivateField(filteringParserDelegate, "_currToken", JsonToken.VALUE_NUMBER_INT);
        // Act
        filteringParserDelegate.clearCurrentToken();
        // Assert
        JsonToken lastClearedToken = getPrivateField(filteringParserDelegate, "_lastClearedToken");
        assertEquals(JsonToken.VALUE_NUMBER_INT, lastClearedToken);
        assertNull(getPrivateField(filteringParserDelegate, "_currToken"));
    }

    private <T> T getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
