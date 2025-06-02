package com.fasterxml.jackson.core.json;

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
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.io.NumberOutput;

class UTF8JsonGenerator_writeStartArray_5_4_Test {

    private UTF8JsonGenerator jsonGenerator;

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        jsonGenerator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), outputStream, '"');
    }

    @Test
    void testWriteStartArray() throws IOException {
        // Test case when the buffer is not full
        jsonGenerator.writeStartArray();
        byte[] expected = { (byte) '[' };
        assertArrayEquals(expected, outputStream.toByteArray());
        // Clear the output stream for the next test
        outputStream.reset();
        // Test case when the buffer is full
        for (int i = 0; i < 512; i++) {
            // Fill the buffer
            outputStream.write(1);
        }
        jsonGenerator.writeStartArray();
        // Verify that the flush method is called and the array start is written
        byte[] expectedAfterFlush = { (byte) '[' };
        assertArrayEquals(expectedAfterFlush, outputStream.toByteArray());
    }

    @Test
    void testWriteStartArrayThrowsIOException() {
        // Simulate an IOException by using a faulty OutputStream
        OutputStream faultyStream = new OutputStream() {

            @Override
            public void write(int b) throws IOException {
                throw new IOException("Simulated IOException");
            }
        };
        jsonGenerator = new UTF8JsonGenerator(Mockito.mock(IOContext.class), 0, Mockito.mock(ObjectCodec.class), faultyStream, '"');
        assertThrows(IOException.class, () -> jsonGenerator.writeStartArray());
    }
}
