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

public class TokenBuffer_writeString_43_0_Test {

    private TokenBuffer tokenBuffer;

    private ObjectCodec objectCodec;

    @BeforeEach
    public void setUp() {
        objectCodec = mock(ObjectCodec.class);
        tokenBuffer = new TokenBuffer(objectCodec, false);
    }

    @Test
    public void testWriteString_NullInput() throws IOException {
        // Arrange
        SerializableString input = null;
        // Act
        tokenBuffer.writeString(input);
        // Assert
        // Verify that writeNull() is called
        verify(tokenBuffer).writeNull();
    }

    @Test
    public void testWriteString_ValidInput() throws IOException {
        // Arrange
        SerializableString input = mock(SerializableString.class);
        when(input.getValue()).thenReturn("test string");
        // Act
        tokenBuffer.writeString(input);
        // Assert
        // Verify that _appendValue() is called with the correct parameters
        verify(tokenBuffer, times(1))._appendValue(JsonToken.VALUE_STRING, input);
    }

    @Test
    public void testWriteString_EmptyString() throws IOException {
        // Arrange
        SerializableString input = mock(SerializableString.class);
        when(input.getValue()).thenReturn("");
        // Act
        tokenBuffer.writeString(input);
        // Assert
        // Verify that _appendValue() is called with the correct parameters
        verify(tokenBuffer, times(1))._appendValue(JsonToken.VALUE_STRING, input);
    }

    @Test
    public void testWriteString_SpecialCharacters() throws IOException {
        // Arrange
        SerializableString input = mock(SerializableString.class);
        when(input.getValue()).thenReturn("!@#$%^&*()");
        // Act
        tokenBuffer.writeString(input);
        // Assert
        // Verify that _appendValue() is called with the correct parameters
        verify(tokenBuffer, times(1))._appendValue(JsonToken.VALUE_STRING, input);
    }
}
