package com.fasterxml.jackson.core;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonFactory;
import java.lang.reflect.Field;
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
import com.fasterxml.jackson.core.sym.CharsToNameCanonicalizer;
import com.fasterxml.jackson.core.util.*;

public class JsonFactory__decorate_94_0_Test {

    private JsonFactory jsonFactory;

    private JsonGenerator mockGenerator;

    private JsonGeneratorDecorator mockDecorator;

    @BeforeEach
    public void setUp() throws Exception {
        jsonFactory = new JsonFactory();
        mockGenerator = mock(JsonGenerator.class);
        mockDecorator = mock(JsonGeneratorDecorator.class);
        // Use reflection to set _generatorDecorators
        Field decoratorsField = JsonFactory.class.getDeclaredField("_generatorDecorators");
        decoratorsField.setAccessible(true);
        decoratorsField.set(jsonFactory, new ArrayList<JsonGeneratorDecorator>());
    }

    @Test
    public void testDecorate_WithNoDecorators() {
        // Act
        JsonGenerator result = jsonFactory._decorate(mockGenerator);
        // Assert
        assertEquals(mockGenerator, result);
        verify(mockDecorator, never()).decorate(any(JsonFactory.class), any(JsonGenerator.class));
    }

    @Test
    public void testDecorate_WithOneDecorator() {
        // Arrange
        jsonFactory._generatorDecorators.add(mockDecorator);
        when(mockDecorator.decorate(jsonFactory, mockGenerator)).thenReturn(mockGenerator);
        // Act
        JsonGenerator result = jsonFactory._decorate(mockGenerator);
        // Assert
        assertEquals(mockGenerator, result);
        verify(mockDecorator, times(1)).decorate(jsonFactory, mockGenerator);
    }

    @Test
    public void testDecorate_WithMultipleDecorators() {
        // Arrange
        JsonGeneratorDecorator secondDecorator = mock(JsonGeneratorDecorator.class);
        jsonFactory._generatorDecorators.add(mockDecorator);
        jsonFactory._generatorDecorators.add(secondDecorator);
        when(mockDecorator.decorate(jsonFactory, mockGenerator)).thenReturn(mockGenerator);
        when(secondDecorator.decorate(jsonFactory, mockGenerator)).thenReturn(mockGenerator);
        // Act
        JsonGenerator result = jsonFactory._decorate(mockGenerator);
        // Assert
        assertEquals(mockGenerator, result);
        verify(mockDecorator, times(1)).decorate(jsonFactory, mockGenerator);
        verify(secondDecorator, times(1)).decorate(jsonFactory, mockGenerator);
    }
}
