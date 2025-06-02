package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class FilteringGeneratorDelegate_writeString_17_0_Test {

    private JsonGenerator mockGenerator;

    private TokenFilter mockFilter;

    private TokenFilterContext mockFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockGenerator = mock(JsonGenerator.class);
        mockFilter = mock(TokenFilter.class);
        mockFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, true);
        // Set up the private fields using reflection
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, mockFilter);
            java.lang.reflect.Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            filterContextField.setAccessible(true);
            filterContextField.set(filteringGeneratorDelegate, mockFilterContext);
        } catch (Exception e) {
            fail("Failed to set up fields: " + e.getMessage());
        }
    }

    @Test
    public void testWriteString_ItemFilterIsNull() throws IOException {
        // Arrange
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(filteringGeneratorDelegate, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Setting itemFilterField failed: " + e.getMessage());
        }
        char[] text = "test".toCharArray();
        // Act
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // Assert
        verify(mockGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    public void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        // Arrange
        when(mockFilter).thenReturn(TokenFilter.INCLUDE_ALL);
        char[] text = "test".toCharArray();
        // Act
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // Assert
        verify(mockGenerator).writeString(text, 0, text.length);
    }

    @Test
    public void testWriteString_StateIsNull() throws IOException {
        // Arrange
        String value = "test";
        when(mockFilterContext.checkValue(mockFilter)).thenReturn(null);
        char[] text = value.toCharArray();
        // Act
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // Assert
        verify(mockGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    public void testWriteString_StateIsNotIncludeAllAndDoesNotInclude() throws IOException {
        // Arrange
        String value = "test";
        when(mockFilterContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.includeString(value)).thenReturn(false);
        char[] text = value.toCharArray();
        // Act
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // Assert
        verify(mockGenerator, never()).writeString(any(char[].class), anyInt(), anyInt());
    }

    @Test
    public void testWriteString_StateIncludesValue() throws IOException {
        // Arrange
        String value = "test";
        when(mockFilterContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.includeString(value)).thenReturn(true);
        char[] text = value.toCharArray();
        // Act
        filteringGeneratorDelegate.writeString(text, 0, text.length);
        // Assert
        verify(mockGenerator).writeString(text, 0, text.length);
    }

    @Test
    public void testWriteString_CheckParentPathCalled() throws Exception {
        // Arrange
        String value = "test";
        when(mockFilterContext.checkValue(mockFilter)).thenReturn(mockFilter);
        when(mockFilter.includeString(value)).thenReturn(true);
        char[] text = value.toCharArray();
        // Use reflection to access private method
        java.lang.reflect.Method checkParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath", boolean.class);
        checkParentPathMethod.setAccessible(true);
        // Act
    }
}
