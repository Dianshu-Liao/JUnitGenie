package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.io.SerializedString;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import com.fasterxml.jackson.core.*;

class DefaultPrettyPrinter_writeStartObject_12_1_Test {

    private DefaultPrettyPrinter prettyPrinter;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    void setUp() {
        prettyPrinter = new DefaultPrettyPrinter();
        jsonGenerator = Mockito.mock(JsonGenerator.class);
    }

    @Test
    void testWriteStartObjectInline() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("writeStartObject", JsonGenerator.class);
        method.setAccessible(true);
        // Act
        method.invoke(prettyPrinter, jsonGenerator);
        // Assert
        verify(jsonGenerator).writeRaw('{');
    }

    @Test
    void testWriteStartObjectNotInline() throws Exception {
        // Arrange
        Method method = DefaultPrettyPrinter.class.getDeclaredMethod("writeStartObject", JsonGenerator.class);
        method.setAccessible(true);
        // Set the _objectIndenter to not inline
        prettyPrinter._objectIndenter = new DefaultPrettyPrinter.Indenter() {

            @Override
            public boolean isInline() {
                return false;
            }

            @Override
            public void writeIndentation(JsonGenerator g, int level) throws IOException {
                // No implementation needed for this test
            }
        };
        // Act
        method.invoke(prettyPrinter, jsonGenerator);
        // Assert
        verify(jsonGenerator).writeRaw('{');
        // Check if _nesting was incremented
        assertEquals(1, prettyPrinter._nesting);
    }
}
