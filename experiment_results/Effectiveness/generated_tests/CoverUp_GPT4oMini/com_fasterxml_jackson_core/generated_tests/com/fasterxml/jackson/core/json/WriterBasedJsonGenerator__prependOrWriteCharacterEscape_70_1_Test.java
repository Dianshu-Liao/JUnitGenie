package com.fasterxml.jackson.core.json;

import java.lang.reflect.Method;
import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.json.WriterBasedJsonGenerator;
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

public class WriterBasedJsonGenerator__prependOrWriteCharacterEscape_70_1_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        IOContext context = mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(context, 0, null, writer);
        generator._outputBuffer = new char[32];
        generator._outputTail = 0;
        generator._outputHead = 0;
    }

    @Test
    public void testPrependOrWriteCharacterEscape_escCodeGreaterThanZero_fitsInBuffer() throws Exception {
        // Arrange
        char ch = 'A';
        // arbitrary escape code
        int escCode = 1;
        // Act
        invokePrivatePrependOrWriteCharacterEscape(ch, escCode);
        // Assert
        assertEquals("\\u0001", writer.toString());
    }

    @Test
    public void testPrependOrWriteCharacterEscape_escCodeGreaterThanZero_doesNotFitInBuffer() throws Exception {
        // Arrange
        char ch = 'A';
        // arbitrary escape code
        int escCode = 1;
        // set tail to 1 to simulate no space
        generator._outputTail = 1;
        // Act
        invokePrivatePrependOrWriteCharacterEscape(ch, escCode);
        // Assert
        assertEquals("\\u0001", writer.toString());
    }

    @Test
    public void testPrependOrWriteCharacterEscape_escCodeNotEqualToCharacterEscapes() throws Exception {
        // Arrange
        char ch = 'B';
        // standard escape code
        int escCode = 0;
        // Act
        invokePrivatePrependOrWriteCharacterEscape(ch, escCode);
        // Assert
        // Check for the expected escape sequence.
        assertEquals("\\u0002", writer.toString());
    }

    @Test
    public void testPrependOrWriteCharacterEscape_customEscape() throws Exception {
        // Arrange
        char ch = 'C';
        // custom escape code
        int escCode = CharacterEscapes.ESCAPE_CUSTOM;
        generator._currentEscape = mock(SerializableString.class);
        when(generator._currentEscape.getValue()).thenReturn("customEscape");
        // Act
        invokePrivatePrependOrWriteCharacterEscape(ch, escCode);
        // Assert
        assertEquals("customEscape", writer.toString());
    }

    private void invokePrivatePrependOrWriteCharacterEscape(char ch, int escCode) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod("_prependOrWriteCharacterEscape", char.class, int.class);
        method.setAccessible(true);
        method.invoke(generator, ch, escCode);
    }
}
