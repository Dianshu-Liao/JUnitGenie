package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonGeneratorDelegate;

public class FilteringGeneratorDelegate_writeString_18_0_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private TokenFilterContext mockTokenFilterContext;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        mockTokenFilterContext = mock(TokenFilterContext.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.INCLUDE_ALL_AND_PATH, true);
    }

    @Test
    public void testWriteString_ItemFilterIsNull() throws IOException {
        filteringGeneratorDelegate._itemFilter = null;
        filteringGeneratorDelegate.writeString(Mockito.mock(SerializableString.class));
        verify(mockJsonGenerator, never()).writeString(any(SerializableString.class));
    }

    @Test
    public void testWriteString_ItemFilterIsIncludeAll() throws IOException {
        filteringGeneratorDelegate._itemFilter = TokenFilter.INCLUDE_ALL;
        SerializableString value = mock(SerializableString.class);
        when(value.getValue()).thenReturn("test");
        filteringGeneratorDelegate.writeString(value);
        verify(mockJsonGenerator).writeString(value);
    }

    @Test
    public void testWriteString_ItemFilterExcludesValue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(filteringGeneratorDelegate._itemFilter.includeString(anyString())).thenReturn(false);
        SerializableString value = mock(SerializableString.class);
        when(value.getValue()).thenReturn("test");
        filteringGeneratorDelegate.writeString(value);
        verify(mockJsonGenerator, never()).writeString(value);
    }

    @Test
    public void testWriteString_ItemFilterIncludesValue() throws IOException {
        filteringGeneratorDelegate._itemFilter = mock(TokenFilter.class);
        when(filteringGeneratorDelegate._itemFilter.includeString(anyString())).thenReturn(true);
        SerializableString value = mock(SerializableString.class);
        when(value.getValue()).thenReturn("test");
        filteringGeneratorDelegate.writeString(value);
        verify(mockJsonGenerator).writeString(value);
    }
}
