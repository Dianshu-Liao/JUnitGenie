package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

public class WriterBasedJsonGenerator__prependOrWriteCharacterEscape_71_2_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    public void testPrependOrWriteCharacterEscape_PrependingEscape() throws Exception {
        char[] buffer = new char[10];
        int ptr = 8;
        int end = buffer.length;
        // Newline character
        char ch = '\n';
        // Escape code for newline
        int escCode = 0x0A;
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_prependOrWriteCharacterEscape", char[].class, int.class, int.class, char.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(generator, buffer, ptr, end, ch, escCode);
        assertEquals(6, newPtr);
        assertEquals('\\', buffer[6]);
        assertEquals('n', buffer[7]);
    }

    @Test
    public void testPrependOrWriteCharacterEscape_WritingEscape() throws Exception {
        char[] buffer = new char[10];
        int ptr = 8;
        int end = buffer.length;
        // Bullet character
        char ch = '\u2022';
        // Custom escape
        int escCode = -1;
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_prependOrWriteCharacterEscape", char[].class, int.class, int.class, char.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(generator, buffer, ptr, end, ch, escCode);
        // Since writing is done to the writer, we need to check the writer's content
        assertEquals(8, newPtr);
        // No output yet since buffer is not full
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrependOrWriteCharacterEscape_BufferTooSmall() throws Exception {
        char[] buffer = new char[5];
        int ptr = 4;
        int end = buffer.length;
        // Bullet character
        char ch = '\u2022';
        // Custom escape
        int escCode = -1;
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_prependOrWriteCharacterEscape", char[].class, int.class, int.class, char.class, int.class);
        method.setAccessible(true);
        int newPtr = (int) method.invoke(generator, buffer, ptr, end, ch, escCode);
        // Since writing is done to the writer, we need to check the writer's content
        assertEquals(4, newPtr);
        // No output yet since buffer is not full
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrependOrWriteCharacterEscape_InvalidEscapeCode() throws Exception {
        char[] buffer = new char[10];
        int ptr = 8;
        int end = buffer.length;
        // Bullet character
        char ch = '\u2022';
        // Invalid escape code
        int escCode = CharacterEscapes.ESCAPE_CUSTOM;
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_prependOrWriteCharacterEscape", char[].class, int.class, int.class, char.class, int.class);
        method.setAccessible(true);
        assertThrows(JsonGenerationException.class, () -> {
            method.invoke(generator, buffer, ptr, end, ch, escCode);
        });
    }
}
