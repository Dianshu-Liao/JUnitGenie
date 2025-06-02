package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.io.CharTypes;
import com.fasterxml.jackson.core.io.CharacterEscapes;
import com.fasterxml.jackson.core.io.NumberOutput;

public class WriterBasedJsonGenerator__writeFieldName_7_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter writer;

    private IOContext ioContext;

    private SerializableString serializableString;

    @BeforeEach
    public void setUp() {
        writer = new StringWriter();
        ioContext = new IOContext(new BufferRecycler(), writer, true);
        generator = new WriterBasedJsonGenerator(ioContext, 0, mock(ObjectCodec.class), writer);
        serializableString = mock(SerializableString.class);
    }

    private void setPrettyPrinter(Object prettyPrinter) throws Exception {
        Field field = WriterBasedJsonGenerator.class.getDeclaredField("_cfgPrettyPrinter");
        field.setAccessible(true);
        field.set(generator, prettyPrinter);
    }

    @Test
    public void testWriteFieldName_WithPrettyPrinter() throws Exception {
        // Arrange
        setPrettyPrinter(mock(PrettyPrinter.class));
        when(serializableString.asQuotedChars()).thenReturn(new char[] { 'f', 'i', 'e', 'l', 'd', '1' });
        // Act
        generator._writeFieldName(serializableString, false);
        // Assert
        assertEquals("\"field1\"", writer.toString().trim());
    }

    @Test
    public void testWriteFieldName_NoPrettyPrinter() throws Exception {
        // Arrange
        setPrettyPrinter(null);
        when(serializableString.asQuotedChars()).thenReturn(new char[] { 'f', 'i', 'e', 'l', 'd', '2' });
        // Act
        generator._writeFieldName(serializableString, false);
        // Assert
        assertEquals("\"field2\"", writer.toString().trim());
    }

    @Test
    public void testWriteFieldName_WithComma() throws Exception {
        // Arrange
        setPrettyPrinter(null);
        when(serializableString.asQuotedChars()).thenReturn(new char[] { 'f', 'i', 'e', 'l', 'd', '3' });
        // Act
        generator._writeFieldName(serializableString, true);
        // Assert
        assertEquals(",\"field3\"", writer.toString().trim());
    }

    @Test
    public void testWriteFieldName_QuotedChars() throws Exception {
        // Arrange
        setPrettyPrinter(null);
        when(serializableString.asQuotedChars()).thenReturn(new char[] { 'f', 'i', 'e', 'l', 'd', '4' });
        // Act
        generator._writeFieldName(serializableString, false);
        // Assert
        assertEquals("\"field4\"", writer.toString().trim());
    }
}
