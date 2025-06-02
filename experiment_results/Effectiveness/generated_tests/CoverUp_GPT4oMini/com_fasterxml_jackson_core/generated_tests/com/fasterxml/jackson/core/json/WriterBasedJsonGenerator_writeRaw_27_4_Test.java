package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
import com.fasterxml.jackson.core.io.IOContext;
import java.lang.reflect.Method;
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

class WriterBasedJsonGenerator_writeRaw_27_4_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    void setUp() {
        writer = new StringWriter();
        IOContext context = new IOContext(null, null, null, null, null, false);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer);
        generator._outputBuffer = new char[64];
        generator._outputEnd = generator._outputBuffer.length;
        generator._outputTail = 0;
        generator._outputHead = 0;
    }

    @Test
    void testWriteRawWithSufficientBuffer() throws Exception {
        String text = "Hello, World!";
        generator.writeRaw(text, 0, text.length());
        assertEquals("Hello, World!", writer.toString());
    }

    @Test
    void testWriteRawWithBufferFlush() throws Exception {
        String text = "This is a long string that will exceed the buffer size.";
        // Simulate filled buffer
        generator._outputTail = 32;
        generator.writeRaw(text, 0, text.length());
        assertTrue(writer.toString().contains("This is a long string that will exceed the buffer size."));
    }

    @Test
    void testWriteRawWithEmptyString() throws Exception {
        generator.writeRaw("", 0, 0);
        assertEquals("", writer.toString());
    }

    @Test
    void testWriteRawWithNegativeOffset() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(text, -1, 3);
        });
    }

    @Test
    void testWriteRawWithInvalidLength() {
        String text = "Hello";
        assertThrows(IndexOutOfBoundsException.class, () -> {
            generator.writeRaw(text, 1, 10);
        });
    }

    @Test
    void testWriteRawLong() throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("writeRawLong", String.class);
        method.setAccessible(true);
        String longText = "This string is long enough to exceed the output buffer size and should be handled properly.";
        method.invoke(generator, longText);
        assertTrue(writer.toString().contains("This string is long enough to exceed the output buffer size and should be handled properly."));
    }
}
