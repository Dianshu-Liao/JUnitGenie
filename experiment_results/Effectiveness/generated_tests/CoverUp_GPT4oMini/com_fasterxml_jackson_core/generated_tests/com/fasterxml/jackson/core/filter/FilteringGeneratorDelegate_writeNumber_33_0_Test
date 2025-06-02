package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeNumber_33_0_Test {

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, true, false);
        // Set up the mock behavior for the context
        when(mockTokenFilterContext.checkValue(any())).thenReturn(mockTokenFilter);
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
    }

    @Test
    public void testWriteNumber_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator, never()).writeNumber(anyInt());
    }

    @Test
    public void testWriteNumber_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator).writeNumber(5);
    }

    @Test
    public void testWriteNumber_StateIsNull() throws IOException {
        when(mockTokenFilterContext.checkValue(any())).thenReturn(null);
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator, never()).writeNumber(anyInt());
    }

    @Test
    public void testWriteNumber_StateIsNotIncludeAllAndDoesNotIncludeNumber() throws IOException {
        when(mockTokenFilter.includeNumber(anyInt())).thenReturn(false);
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator, never()).writeNumber(anyInt());
    }

    @Test
    public void testWriteNumber_StateIsNotIncludeAllAndIncludesNumber() throws IOException {
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator).writeNumber(5);
    }

    @Test
    public void testWriteNumber_ValidStateAndCheckParentPath() throws IOException {
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockTokenFilterContext).checkValue(mockTokenFilter);
        verify(mockJsonGenerator).writeNumber(5);
    }

    @Test
    public void testWriteNumber_WithCheckParentPath() throws IOException {
        filteringGeneratorDelegate.writeNumber(5);
        verify(mockJsonGenerator).writeNumber(5);
        // Assuming _checkParentPath is called in writeNumber
        // You may need to invoke it via reflection if it's private
        // Example (if _checkParentPath is private):
        // Method method = FilteringGeneratorDelegate.class.getDeclaredMethod("_checkParentPath");
        // method.setAccessible(true);
        // method.invoke(filteringGeneratorDelegate);
    }
}
