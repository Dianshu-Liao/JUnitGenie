package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.Objects;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

class JsonFactory__decorate_91_0_Test {

    private JsonFactory jsonFactory;

    private DataInput mockDataInput;

    private IOContext mockIOContext;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockDataInput = mock(DataInput.class);
        mockIOContext = mock(IOContext.class);
    }

    @Test
    void testDecorateWithInputDecorator() throws Exception {
        // Arrange
        InputDecorator mockInputDecorator = mock(InputDecorator.class);
        when(mockInputDecorator.decorate(any(IOContext.class), any(DataInput.class))).thenReturn(mockDataInput);
        jsonFactory.setInputDecorator(mockInputDecorator);
        // Act
        DataInput result = invokePrivateDecorate(jsonFactory, mockDataInput, mockIOContext);
        // Assert
        assertNotNull(result);
        assertEquals(mockDataInput, result);
        verify(mockInputDecorator).decorate(mockIOContext, mockDataInput);
    }

    @Test
    void testDecorateWithoutInputDecorator() throws Exception {
        // Act
        DataInput result = invokePrivateDecorate(jsonFactory, mockDataInput, mockIOContext);
        // Assert
        assertNotNull(result);
        assertEquals(mockDataInput, result);
    }

    @Test
    void testDecorateWithNullInputDecorator() throws Exception {
        // Arrange
        jsonFactory.setInputDecorator(null);
        // Act
        DataInput result = invokePrivateDecorate(jsonFactory, mockDataInput, mockIOContext);
        // Assert
        assertNotNull(result);
        assertEquals(mockDataInput, result);
    }

    private DataInput invokePrivateDecorate(JsonFactory jsonFactory, DataInput in, IOContext ctxt) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("_decorate", DataInput.class, IOContext.class);
        method.setAccessible(true);
        return (DataInput) method.invoke(jsonFactory, in, ctxt);
    }
}
