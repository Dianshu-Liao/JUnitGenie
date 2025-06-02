package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;

public class DataFormatMatcher_getMatchedFormatName_3_3_Test {

    private DataFormatMatcher dataFormatMatcher;

    private InputStream inputStream;

    private byte[] bufferedData;

    private int bufferedStart;

    private int bufferedLength;

    private JsonFactory jsonFactory;

    private MatchStrength matchStrength;

    @BeforeEach
    public void setUp() {
        inputStream = mock(InputStream.class);
        bufferedData = new byte[] {};
        bufferedStart = 0;
        bufferedLength = 0;
        jsonFactory = mock(JsonFactory.class);
        matchStrength = mock(MatchStrength.class);
    }

    @Test
    public void testGetMatchedFormatName_whenHasMatch() throws Exception {
        // Arrange
        dataFormatMatcher = new DataFormatMatcher(inputStream, bufferedData, bufferedStart, bufferedLength, jsonFactory, matchStrength);
        // Using reflection to set the private method
        setField(dataFormatMatcher, "matchStrength", matchStrength);
        when(dataFormatMatcher.hasMatch()).thenReturn(true);
        when(dataFormatMatcher.getMatch()).thenReturn(jsonFactory);
        when(jsonFactory.getFormatName()).thenReturn("JSON");
        // Act
        String result = dataFormatMatcher.getMatchedFormatName();
        // Assert
        assertEquals("JSON", result);
    }

    @Test
    public void testGetMatchedFormatName_whenNoMatch() throws Exception {
        // Arrange
        dataFormatMatcher = new DataFormatMatcher(inputStream, bufferedData, bufferedStart, bufferedLength, jsonFactory, matchStrength);
        when(dataFormatMatcher.hasMatch()).thenReturn(false);
        // Act
        String result = dataFormatMatcher.getMatchedFormatName();
        // Assert
        assertNull(result);
    }

    // Helper method to set private fields using reflection
    private void setField(DataFormatMatcher obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = DataFormatMatcher.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
