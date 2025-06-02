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
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__decorate_91_0_Test {

    private JsonFactory jsonFactory;

    private DataInput mockDataInput;

    private IOContext mockIOContext;

    private InputDecorator mockInputDecorator;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockDataInput = Mockito.mock(DataInput.class);
        mockIOContext = Mockito.mock(IOContext.class);
        mockInputDecorator = Mockito.mock(InputDecorator.class);
        jsonFactory.setInputDecorator(mockInputDecorator);
    }

    @Test
    public void testDecorate_WithInputDecorator_ReturnsDecoratedInput() throws IOException {
        DataInput decoratedInput = Mockito.mock(DataInput.class);
        when(mockInputDecorator.decorate(mockIOContext, mockDataInput)).thenReturn(decoratedInput);
        DataInput result = jsonFactory._decorate(mockDataInput, mockIOContext);
        assertNotNull(result);
        assertEquals(decoratedInput, result);
    }

    @Test
    public void testDecorate_WithoutInputDecorator_ReturnsOriginalInput() throws IOException {
        jsonFactory.setInputDecorator(null);
        DataInput result = jsonFactory._decorate(mockDataInput, mockIOContext);
        assertNotNull(result);
        assertEquals(mockDataInput, result);
    }

    @Test
    public void testDecorate_WithNullInputDecorator_ReturnsOriginalInput() throws IOException {
        when(mockInputDecorator.decorate(mockIOContext, mockDataInput)).thenReturn(null);
        DataInput result = jsonFactory._decorate(mockDataInput, mockIOContext);
        assertNotNull(result);
        assertEquals(mockDataInput, result);
    }
}
