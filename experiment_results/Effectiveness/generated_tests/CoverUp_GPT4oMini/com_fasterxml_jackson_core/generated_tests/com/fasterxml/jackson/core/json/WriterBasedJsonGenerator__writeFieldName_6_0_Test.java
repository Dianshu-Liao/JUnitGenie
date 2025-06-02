package com.fasterxml.jackson.core.json;

import com.fasterxml.jackson.core.io.IOContext;
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

public class WriterBasedJsonGenerator__writeFieldName_6_0_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    private IOContext ioContext;

    @BeforeEach
    public void setUp() {
        stringWriter = new StringWriter();
        ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, Mockito.mock(ObjectCodec.class), stringWriter, '"');
    }

    @Test
    public void testWriteFieldNameWithCommaBefore() throws Exception {
        // Arrange
        setPrivateField(generator, "_outputBuffer", new char[64]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 64);
        setPrivateField(generator, "_cfgPrettyPrinter", null);
        setPrivateField(generator, "_cfgUnqNames", false);
        // Act
        invokePrivateMethod(generator, "_writeFieldName", "fieldName", true);
        // Assert
        assertEquals(",\"fieldName\"", stringWriter.toString());
    }

    @Test
    public void testWriteFieldNameWithoutCommaBefore() throws Exception {
        // Arrange
        setPrivateField(generator, "_outputBuffer", new char[64]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 64);
        setPrivateField(generator, "_cfgPrettyPrinter", null);
        setPrivateField(generator, "_cfgUnqNames", false);
        // Act
        invokePrivateMethod(generator, "_writeFieldName", "fieldName", false);
        // Assert
        assertEquals("\"fieldName\"", stringWriter.toString());
    }

    @Test
    public void testWriteFieldNameWithUnquotedNames() throws Exception {
        // Arrange
        setPrivateField(generator, "_outputBuffer", new char[64]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 64);
        setPrivateField(generator, "_cfgPrettyPrinter", null);
        // Unquoted names
        setPrivateField(generator, "_cfgUnqNames", true);
        // Act
        invokePrivateMethod(generator, "_writeFieldName", "fieldName", false);
        // Assert
        assertEquals("fieldName", stringWriter.toString());
    }

    @Test
    public void testWriteFieldNameBufferFlush() throws Exception {
        // Arrange
        // Small buffer to force flush
        setPrivateField(generator, "_outputBuffer", new char[10]);
        setPrivateField(generator, "_outputTail", 0);
        setPrivateField(generator, "_outputEnd", 10);
        setPrivateField(generator, "_cfgPrettyPrinter", null);
        setPrivateField(generator, "_cfgUnqNames", false);
        // Act
        invokePrivateMethod(generator, "_writeFieldName", "longFieldNameExceedingBuffer", true);
        // Assert
        assertTrue(stringWriter.toString().contains(",\"longFieldNameExceedingBuffer\""));
    }

    private void invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName, String.class, boolean.class);
        method.setAccessible(true);
        method.invoke(obj, args);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
