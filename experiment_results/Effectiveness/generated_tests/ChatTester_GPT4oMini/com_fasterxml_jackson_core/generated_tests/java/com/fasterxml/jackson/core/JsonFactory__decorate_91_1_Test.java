package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory__decorate_91_1_Test {

    private JsonFactory jsonFactory;

    private IOContext ioContext;

    private DataInput dataInput;

    private InputDecorator inputDecorator;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        ioContext = mock(IOContext.class);
        dataInput = mock(DataInput.class);
        inputDecorator = mock(InputDecorator.class);
        // Set the inputDecorator to the JsonFactory instance using reflection
        try {
            java.lang.reflect.Field field = JsonFactory.class.getDeclaredField("_inputDecorator");
            field.setAccessible(true);
            field.set(jsonFactory, inputDecorator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    void testDecorateWithInputDecorator() throws IOException {
        DataInput decoratedInput = mock(DataInput.class);
        when(inputDecorator.decorate(ioContext, dataInput)).thenReturn(decoratedInput);
        DataInput result = invokeDecorate(dataInput, ioContext);
        assertNotNull(result);
        assertEquals(decoratedInput, result);
        verify(inputDecorator).decorate(ioContext, dataInput);
    }

    @Test
    void testDecorateWithoutInputDecorator() throws IOException {
        // Remove the inputDecorator using reflection to test the case where it's null
        try {
            java.lang.reflect.Field field = JsonFactory.class.getDeclaredField("_inputDecorator");
            field.setAccessible(true);
            field.set(jsonFactory, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        DataInput result = invokeDecorate(dataInput, ioContext);
        assertNotNull(result);
        assertEquals(dataInput, result);
    }

    private DataInput invokeDecorate(DataInput in, IOContext ctxt) throws IOException {
        try {
            java.lang.reflect.Method method = JsonFactory.class.getDeclaredMethod("_decorate", DataInput.class, IOContext.class);
            method.setAccessible(true);
            return (DataInput) method.invoke(jsonFactory, in, ctxt);
        } catch (Exception e) {
            throw new IOException("Failed to invoke _decorate method", e);
        }
    }
}
