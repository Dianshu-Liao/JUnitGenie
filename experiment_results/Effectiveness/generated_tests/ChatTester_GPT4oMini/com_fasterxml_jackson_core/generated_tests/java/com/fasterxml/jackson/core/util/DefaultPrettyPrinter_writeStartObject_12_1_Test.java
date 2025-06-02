package com.fasterxml.jackson.core.util;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.io.SerializedString;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

public class DefaultPrettyPrinter_writeStartObject_12_1_Test {

    private DefaultPrettyPrinter defaultPrettyPrinter;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        defaultPrettyPrinter = new DefaultPrettyPrinter();
        jsonGenerator = Mockito.mock(JsonGenerator.class);
    }

    @Test
    public void testWriteStartObjectInline() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        when(defaultPrettyPrinter._objectIndenter.isInline()).thenReturn(true);
        // Act
        defaultPrettyPrinter.writeStartObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeRaw('{');
        // No increment in nesting since it's inline
        java.lang.reflect.Field nestingField = DefaultPrettyPrinter.class.getDeclaredField("_nesting");
        nestingField.setAccessible(true);
        int nestingValue = (int) nestingField.get(defaultPrettyPrinter);
        assertEquals(0, nestingValue);
    }

    @Test
    public void testWriteStartObjectNotInline() throws IOException, NoSuchFieldException, IllegalAccessException {
        // Arrange
        when(defaultPrettyPrinter._objectIndenter.isInline()).thenReturn(false);
        // Act
        defaultPrettyPrinter.writeStartObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeRaw('{');
        java.lang.reflect.Field nestingField = DefaultPrettyPrinter.class.getDeclaredField("_nesting");
        nestingField.setAccessible(true);
        int nestingValue = (int) nestingField.get(defaultPrettyPrinter);
        assertEquals(1, nestingValue);
    }
}
