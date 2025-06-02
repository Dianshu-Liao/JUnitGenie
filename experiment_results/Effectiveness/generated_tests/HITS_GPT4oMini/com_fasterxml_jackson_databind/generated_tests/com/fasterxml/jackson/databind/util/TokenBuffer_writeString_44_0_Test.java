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

public class TokenBuffer_writeString_44_0_Test {

    private TokenBuffer tokenBuffer;

    @BeforeEach
    public void setUp() {
        tokenBuffer = new TokenBuffer(null, false);
    }

    @Test
    public void testWriteString_NullReader_ThrowsIOException() {
        assertThrows(IOException.class, () -> {
            tokenBuffer.writeString(null, 5);
        });
    }

    @Test
    public void testWriteString_ValidInput_ReadsCorrectly() throws IOException {
        String input = "Hello, World!";
        Reader reader = new StringReader(input);
        tokenBuffer.writeString(reader, input.length());
        // Assuming _appendValue method appends correctly, further assertions can be made
        // This might require additional methods to verify the state of the TokenBuffer
    }

    @Test
    public void testWriteString_ZeroLength_HandlesGracefully() throws IOException {
        String input = "Hello, World!";
        Reader reader = new StringReader(input);
        tokenBuffer.writeString(reader, 0);
        // No output expected, but we can check the internal state if needed
    }

    @Test
    public void testWriteString_LengthExceedsAvailableData_ThrowsIOException() {
        String input = "Short";
        Reader reader = new StringReader(input);
        assertThrows(IOException.class, () -> {
            tokenBuffer.writeString(reader, 10);
        });
    }

    @Test
    public void testWriteString_NegativeLength_ReadsUntilEOF() throws IOException {
        String input = "Read until EOF.";
        Reader reader = new StringReader(input);
        tokenBuffer.writeString(reader, -1);
        // Check if the data was read correctly
        // This might require additional methods to verify the state of the TokenBuffer
    }

    @Test
    public void testWriteString_EmptyReader_NoDataRead() throws IOException {
        String input = "";
        Reader reader = new StringReader(input);
        tokenBuffer.writeString(reader, 0);
        // Check if no data was appended
        // This might require additional methods to verify the state of the TokenBuffer
    }
}
