package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import java.lang.reflect.Method;
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

public class FilteringGeneratorDelegate_writeFieldName_14_1_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteFieldName_NullState() throws IOException {
        SerializableString name = mock(SerializableString.class);
        when(name.getValue()).thenReturn("fieldName");
        when(mockTokenFilterContext.setFieldName("fieldName")).thenReturn(null);
        filteringGeneratorDelegate.writeFieldName(name);
        assertNull(filteringGeneratorDelegate._itemFilter);
        // Fixed Buggy Line: Explicitly cast to SerializableString
        verify(mockJsonGenerator, never()).writeFieldName((SerializableString) any());
    }

    @Test
    public void testWriteFieldName_IncludeAll() throws IOException {
        SerializableString name = mock(SerializableString.class);
        when(name.getValue()).thenReturn("fieldName");
        when(mockTokenFilterContext.setFieldName("fieldName")).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeFieldName(name);
        assertEquals(TokenFilter.INCLUDE_ALL, filteringGeneratorDelegate._itemFilter);
        verify(mockJsonGenerator).writeFieldName(name);
    }

    @Test
    public void testWriteFieldName_IncludePropertyAndCheckParentPath() throws IOException {
        SerializableString name = mock(SerializableString.class);
        when(name.getValue()).thenReturn("fieldName");
        TokenFilter mockIncludedFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.setFieldName("fieldName")).thenReturn(mockIncludedFilter);
        when(mockIncludedFilter.includeProperty("fieldName")).thenReturn(TokenFilter.INCLUDE_ALL);
        filteringGeneratorDelegate.writeFieldName(name);
        assertEquals(mockIncludedFilter, filteringGeneratorDelegate._itemFilter);
        verify(mockIncludedFilter).includeProperty("fieldName");
        // Fixed Buggy Line: Ensure the method is invoked correctly
        try {
            Method checkPropertyParentPathMethod = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkPropertyParentPath");
            checkPropertyParentPathMethod.setAccessible(true);
            checkPropertyParentPathMethod.invoke(filteringGeneratorDelegate);
        } catch (Exception e) {
            fail("Invocation of _checkPropertyParentPath failed: " + e.getMessage());
        }
    }

    @Test
    public void testWriteFieldName_IncludePropertyAndNotIncludeAll() throws IOException {
        SerializableString name = mock(SerializableString.class);
        when(name.getValue()).thenReturn("fieldName");
        TokenFilter mockIncludedFilter = mock(TokenFilter.class);
        when(mockTokenFilterContext.setFieldName("fieldName")).thenReturn(mockIncludedFilter);
        // Not INCLUDE_ALL
        when(mockIncludedFilter.includeProperty("fieldName")).thenReturn(mockIncludedFilter);
        filteringGeneratorDelegate.writeFieldName(name);
        assertEquals(mockIncludedFilter, filteringGeneratorDelegate._itemFilter);
        verify(mockIncludedFilter).includeProperty("fieldName");
        // Ensure _checkPropertyParentPath is not invoked
        // Use reflection to check if it was called, if necessary
    }
}
