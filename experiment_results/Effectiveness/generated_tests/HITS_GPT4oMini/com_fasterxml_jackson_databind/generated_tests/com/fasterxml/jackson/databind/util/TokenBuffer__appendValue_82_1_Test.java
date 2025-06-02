package com.fasterxml.jackson.databind.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.TreeMap;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.base.ParserMinimalBase;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.io.NumberInput;
import com.fasterxml.jackson.core.json.JsonWriteContext;
import com.fasterxml.jackson.core.util.ByteArrayBuilder;
import com.fasterxml.jackson.core.util.JacksonFeatureSet;
import com.fasterxml.jackson.databind.*;

class TokenBuffer__appendValue_82_1_Test {

    private TokenBuffer tokenBuffer;

    @BeforeEach
    void setUp() {
        // Using the constructor with ObjectCodec and boolean parameters
        tokenBuffer = new TokenBuffer(null, false);
    }

    @Test
    void testAppendValue_NativeId() {
        // Arrange
        tokenBuffer._hasNativeId = true;
        tokenBuffer._objectId = new Object();
        tokenBuffer._typeId = new Object();
        tokenBuffer._last = new TokenBuffer.Segment();
        tokenBuffer._appendAt = 0;
        // Act
        tokenBuffer._appendValue(JsonToken.VALUE_STRING);
        // Assert
        assertNotNull(tokenBuffer._last);
    }

    @Test
    void testAppendValue_NoNativeId() {
        // Arrange
        tokenBuffer._hasNativeId = false;
        tokenBuffer._last = new TokenBuffer.Segment();
        tokenBuffer._appendAt = 0;
        // Act
        tokenBuffer._appendValue(JsonToken.VALUE_NUMBER_INT);
        // Assert
        assertNotNull(tokenBuffer._last);
    }

    @Test
    void testAppendValue_EmptySegment() {
        // Arrange
        tokenBuffer._hasNativeId = false;
        tokenBuffer._last = new TokenBuffer.Segment();
        tokenBuffer._appendAt = 0;
        // Act
        tokenBuffer._appendValue(JsonToken.VALUE_FALSE);
        // Assert
        assertNotNull(tokenBuffer._last);
    }

    @Test
    void testAppendValue_AppendAtIncrement() {
        // Arrange
        tokenBuffer._hasNativeId = false;
        tokenBuffer._last = new TokenBuffer.Segment();
        tokenBuffer._appendAt = 0;
        // Act
        tokenBuffer._appendValue(JsonToken.VALUE_NULL);
        // Assert
        assertEquals(1, tokenBuffer._appendAt);
    }
}
