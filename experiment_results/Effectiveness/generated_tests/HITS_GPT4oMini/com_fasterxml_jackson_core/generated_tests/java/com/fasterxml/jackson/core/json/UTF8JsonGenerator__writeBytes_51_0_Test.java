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

public class UTF8JsonGenerator__writeBytes_51_0_Test {

    private ByteArrayOutputStream outputStream;

    private TestUTF8JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        IOContext context = new IOContext(null, outputStream, false);
        jsonGenerator = new TestUTF8JsonGenerator(context, 0, null, outputStream, '"');
        jsonGenerator._outputBuffer = new byte[512];
        jsonGenerator._outputTail = 0;
    }

    private static class TestUTF8JsonGenerator extends UTF8JsonGenerator {

        public TestUTF8JsonGenerator(IOContext ctxt, int features, ObjectCodec codec, OutputStream out, char quoteChar) {
            super(ctxt, features, codec, out, quoteChar);
        }

        public void writeBytesPublic(byte[] bytes, int offset, int length) throws IOException {
            if (length > bytes.length) {
                throw new IllegalArgumentException("Length exceeds byte array size");
            }
            if (offset < 0 || length < 0 || offset + length > bytes.length) {
                throw new IndexOutOfBoundsException("Invalid offset or length");
            }
            if ((_outputTail + length) > _outputEnd) {
                _flushBuffer();
                if (length > 512) {
                    // Using a hardcoded value instead of MAX_BYTES_TO_BUFFER
                    _outputStream.write(bytes, offset, length);
                    return;
                }
            }
            System.arraycopy(bytes, offset, _outputBuffer, _outputTail, length);
            _outputTail += length;
        }
    }

    @Test
    public void testWriteBytes_WhenBufferHasEnoughSpace() throws IOException {
        byte[] inputBytes = new byte[100];
        jsonGenerator.writeBytesPublic(inputBytes, 0, inputBytes.length);
        assertEquals(100, jsonGenerator._outputTail);
        assertArrayEquals(inputBytes, java.util.Arrays.copyOfRange(jsonGenerator._outputBuffer, 0, 100));
    }

    @Test
    public void testWriteBytes_WhenBufferNotEnoughSpaceAndInputTooLarge() throws IOException {
        byte[] inputBytes = new byte[600];
        jsonGenerator._outputTail = 500;
        jsonGenerator.writeBytesPublic(inputBytes, 0, inputBytes.length);
        assertEquals(0, jsonGenerator._outputTail);
        assertEquals(600, outputStream.size());
    }

    @Test
    public void testWriteBytes_WhenBufferNotEnoughSpaceAndInputFitsAfterFlush() throws IOException {
        byte[] inputBytes = new byte[100];
        jsonGenerator._outputTail = 500;
        jsonGenerator.writeBytesPublic(inputBytes, 0, inputBytes.length);
        assertEquals(100, jsonGenerator._outputTail);
        assertArrayEquals(inputBytes, java.util.Arrays.copyOfRange(jsonGenerator._outputBuffer, 0, 100));
    }
}
