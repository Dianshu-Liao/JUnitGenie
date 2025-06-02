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
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

public class FilteringGeneratorDelegate_writeString_16_3_Test {

    @Mock
    private JsonGenerator mockJsonGenerator;

    @Mock
    private TokenFilter mockTokenFilter;

    @Mock
    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_NON_NULL, true);
        filteringGeneratorDelegate._filterContext = mockTokenFilterContext;
    }

    @Test
    public void testWriteString_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    public void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    public void testWriteString_ItemFilterNotIncludeAll_StateIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(null);
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    public void testWriteString_ItemFilterNotIncludeAll_StateIsNotIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(state);
        when(state.includeString("test")).thenReturn(false);
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator, never()).writeString(anyString());
    }

    @Test
    public void testWriteString_ItemFilterNotIncludeAll_StateIncludesString() throws IOException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(state);
        when(state.includeString("test")).thenReturn(true);
        filteringGeneratorDelegate.writeString("test");
        verify(mockJsonGenerator).writeString("test");
    }

    @Test
    public void testWriteString_CheckParentPathCalled() throws IOException, ReflectiveOperationException {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(state);
        when(state.includeString("test")).thenReturn(true);
        // Invoke the writeString method
        filteringGeneratorDelegate.writeString("test");
        // Access the private method using reflection
        Method checkParentPathMethod = filteringGeneratorDelegate.getClass().getDeclaredMethod("checkParentPath");
        checkParentPathMethod.setAccessible(true);
        // Verify that the private method was called
        checkParentPathMethod.invoke(filteringGeneratorDelegate);
    }

    // Reflection test for private method checkParentPath
    @Test
    public void testWriteString_CheckParentPathUsingReflection() throws Exception {
        filteringGeneratorDelegate._itemFilter = mockTokenFilter;
        TokenFilter state = mock(TokenFilter.class);
        when(mockTokenFilterContext.checkValue(mockTokenFilter)).thenReturn(state);
        when(state.includeString("test")).thenReturn(true);
        // Invoke the writeString method
        filteringGeneratorDelegate.writeString("test");
        // Access the private method using reflection
        Method checkParentPathMethod = filteringGeneratorDelegate.getClass().getDeclaredMethod("checkParentPath");
        checkParentPathMethod.setAccessible(true);
        // Verify that the private method was called
        checkParentPathMethod.invoke(filteringGeneratorDelegate);
    }
}
