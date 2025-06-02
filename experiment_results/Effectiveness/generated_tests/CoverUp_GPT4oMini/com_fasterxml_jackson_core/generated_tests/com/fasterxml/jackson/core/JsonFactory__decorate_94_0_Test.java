package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamWriteConstraints;
import com.fasterxml.jackson.core.ErrorReportConfiguration;
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.lang.ref.SoftReference;
import java.net.URL;
import java.util.Objects;
import com.fasterxml.jackson.core.format.InputAccessor;
import com.fasterxml.jackson.core.format.MatchStrength;
import com.fasterxml.jackson.core.io.*;
import com.fasterxml.jackson.core.json.*;
import com.fasterxml.jackson.core.json.async.NonBlockingByteBufferJsonParser;
import com.fasterxml.jackson.core.json.async.NonBlockingJsonParser;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__decorate_94_0_Test {

    private JsonFactory jsonFactory;

    private JsonGenerator mockGenerator;

    @BeforeEach
    public void setUp() {
        jsonFactory = new JsonFactory();
        mockGenerator = mock(JsonGenerator.class);
    }

    @Test
    public void testDecorateWithNoDecorators() throws Exception {
        // Arrange
        Method decorateMethod = JsonFactory.class.getDeclaredMethod("_decorate", JsonGenerator.class);
        decorateMethod.setAccessible(true);
        // Act
        JsonGenerator result = (JsonGenerator) decorateMethod.invoke(jsonFactory, mockGenerator);
        // Assert
        assertNotNull(result);
        verify(mockGenerator, never()).writeStartObject();
    }

    @Test
    public void testDecorateWithDecorators() throws Exception {
        // Arrange
        JsonGeneratorDecorator mockDecorator = mock(JsonGeneratorDecorator.class);
        List<JsonGeneratorDecorator> decorators = new ArrayList<>();
        decorators.add(mockDecorator);
        // Use reflection to set the private final field _generatorDecorators
        Field decoratorsField = JsonFactory.class.getDeclaredField("_generatorDecorators");
        decoratorsField.setAccessible(true);
        decoratorsField.set(jsonFactory, decorators);
        when(mockDecorator.decorate(any(JsonFactory.class), any(JsonGenerator.class))).thenReturn(mockGenerator);
        Method decorateMethod = JsonFactory.class.getDeclaredMethod("_decorate", JsonGenerator.class);
        decorateMethod.setAccessible(true);
        // Act
        JsonGenerator result = (JsonGenerator) decorateMethod.invoke(jsonFactory, mockGenerator);
        // Assert
        assertNotNull(result);
        verify(mockDecorator, times(1)).decorate(jsonFactory, mockGenerator);
    }
}
