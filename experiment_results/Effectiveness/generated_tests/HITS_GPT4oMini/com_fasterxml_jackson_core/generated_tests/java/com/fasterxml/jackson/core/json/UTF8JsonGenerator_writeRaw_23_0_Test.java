package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class UTF8JsonGenerator_writeRaw_23_0_Test {

    private UTF8JsonGenerator generator;

    private ByteArrayOutputStream outputStream;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        ioContext = mock(IOContext.class);
        when(ioContext.allocWriteEncodingBuffer()).thenReturn(new byte[512]);
        generator = new UTF8JsonGenerator(ioContext, 0, null, outputStream, '"');
    }

    @Test
    public void testWriteRaw_AppendsUnquotedUTF8Successfully() throws IOException {
        // Arrange
        SerializableString text = mock(SerializableString.class);
        byte[] utf8Bytes = "Hello".getBytes("UTF-8");
        when(text.appendUnquotedUTF8(any(byte[].class), anyInt())).thenAnswer(invocation -> {
            byte[] buffer = invocation.getArgument(0);
            int offset = invocation.getArgument(1);
            System.arraycopy(utf8Bytes, 0, buffer, offset, utf8Bytes.length);
            return utf8Bytes.length;
        });
        // Act
        generator.writeRaw(text);
        // Assert
        String output = outputStream.toString("UTF-8");
        assert output.equals("Hello") : "Output buffer did not contain expected bytes.";
    }

    @Test
    public void testWriteRaw_AppendsUnquotedUTF8NegativeLength() throws IOException {
        // Arrange
        SerializableString text = mock(SerializableString.class);
        when(text.appendUnquotedUTF8(any(byte[].class), anyInt())).thenReturn(-1);
        byte[] utf8Bytes = "World".getBytes("UTF-8");
        when(text.asUnquotedUTF8()).thenReturn(utf8Bytes);
        // Act
        generator.writeRaw(text);
        // Assert
        String output = outputStream.toString("UTF-8");
        assert output.equals("World") : "Output buffer did not contain expected bytes after negative length.";
    }

    @Test
    public void testWriteRaw_FlushesBufferWhenFull() throws IOException {
        // Arrange
        SerializableString text = mock(SerializableString.class);
        // More than the buffer size
        byte[] utf8Bytes = new byte[520];
        when(text.appendUnquotedUTF8(any(byte[].class), anyInt())).thenReturn(520);
        when(text.asUnquotedUTF8()).thenReturn(utf8Bytes);
        // Act
        generator.writeRaw(text);
        // Assert
        // Check that the output stream has received the bytes
        assert outputStream.size() == 520 : "Output buffer size did not match expected size after flush.";
    }
}
