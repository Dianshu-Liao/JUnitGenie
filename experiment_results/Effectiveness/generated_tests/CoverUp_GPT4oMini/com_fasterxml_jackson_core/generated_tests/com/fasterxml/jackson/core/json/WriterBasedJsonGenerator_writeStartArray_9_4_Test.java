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

class WriterBasedJsonGenerator_writeStartArray_9_4_Test {

    private WriterBasedJsonGenerator generator;

    private StringWriter stringWriter;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        IOContext ioContext = Mockito.mock(IOContext.class);
        generator = new WriterBasedJsonGenerator(ioContext, 0, null, stringWriter);
    }

    @Test
    void testWriteStartArray() throws Exception {
        // Invoke the method
        invokePrivateMethod("writeStartArray");
        // Verify the output
        assertEquals("[", stringWriter.toString());
    }

    @Test
    void testWriteStartArrayWithNestingDepth() throws Exception {
        // Mock the _writeContext to simulate nesting depth
        Method createChildArrayContextMethod = JsonWriteContext.class.getDeclaredMethod("createChildArrayContext");
        createChildArrayContextMethod.setAccessible(true);
        JsonWriteContext mockContext = Mockito.mock(JsonWriteContext.class);
        Mockito.when(mockContext.createChildArrayContext()).thenReturn(mockContext);
        Mockito.when(mockContext.getNestingDepth()).thenReturn(1);
        // Set the mock context
        setPrivateField("_writeContext", mockContext);
        // Invoke the method
        invokePrivateMethod("writeStartArray");
        // Verify the output
        assertEquals("[", stringWriter.toString());
    }

    @Test
    void testWriteStartArrayWithFlush() throws Exception {
        // Fill the output buffer to force a flush
        for (int i = 0; i < 32; i++) {
            // Fill buffer
            generator._outputBuffer[i] = 'a';
            generator._outputTail++;
        }
        // Invoke the method
        invokePrivateMethod("writeStartArray");
        // Verify the output
        assertEquals("[", stringWriter.toString());
    }

    private void invokePrivateMethod(String methodName) throws Exception {
        Method method = WriterBasedJsonGenerator.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(generator);
    }

    private void setPrivateField(String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = WriterBasedJsonGenerator.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(generator, value);
    }
}
