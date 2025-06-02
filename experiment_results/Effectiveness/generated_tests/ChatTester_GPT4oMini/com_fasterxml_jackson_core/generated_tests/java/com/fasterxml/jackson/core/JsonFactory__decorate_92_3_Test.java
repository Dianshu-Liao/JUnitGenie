// Test method
package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

class JsonFactory__decorate_92_3_Test {

    private JsonFactory jsonFactory;

    private OutputDecorator mockOutputDecorator;

    private IOContext mockIOContext;

    private OutputStream mockOutputStream;

    @BeforeEach
    void setUp() {
        jsonFactory = new JsonFactory();
        mockOutputDecorator = mock(OutputDecorator.class);
        mockIOContext = mock(IOContext.class);
        mockOutputStream = mock(OutputStream.class);
    }

    @Test
    void testDecorateWithOutputDecorator() throws Exception {
        // Arrange
        jsonFactory._outputDecorator = mockOutputDecorator;
        OutputStream decoratedOutputStream = mock(OutputStream.class);
        when(mockOutputDecorator.decorate(mockIOContext, mockOutputStream)).thenReturn(decoratedOutputStream);
        // Act
        OutputStream result = invokePrivateDecorate(jsonFactory, mockOutputStream, mockIOContext);
        // Assert
        assertEquals(decoratedOutputStream, result);
        verify(mockOutputDecorator).decorate(mockIOContext, mockOutputStream);
    }

    @Test
    void testDecorateWithoutOutputDecorator() throws Exception {
        // Arrange
        jsonFactory._outputDecorator = null;
        // Act
        OutputStream result = invokePrivateDecorate(jsonFactory, mockOutputStream, mockIOContext);
        // Assert
        assertEquals(mockOutputStream, result);
    }

    private OutputStream invokePrivateDecorate(JsonFactory jsonFactory, OutputStream out, IOContext ctxt) throws Exception {
        Method method = JsonFactory.class.getDeclaredMethod("_decorate", OutputStream.class, IOContext.class);
        method.setAccessible(true);
        return (OutputStream) method.invoke(jsonFactory, out, ctxt);
    }
}
