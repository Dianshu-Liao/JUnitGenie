package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.util.TokenBuffer;
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

public class TokenBuffer_writeString_43_1_Test {

    private TokenBuffer tokenBuffer;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        jsonGenerator = mock(JsonGenerator.class);
        tokenBuffer = new TokenBuffer(null, false);
    }

    @Test
    public void testWriteString_NullInput_CallsWriteNull() throws IOException {
        // Arrange
        SerializableString text = null;
        TokenBuffer spyTokenBuffer = spy(tokenBuffer);
        // Act
        spyTokenBuffer.writeString(text);
        // Assert
        verify(spyTokenBuffer, times(1)).writeNull();
    }
}
