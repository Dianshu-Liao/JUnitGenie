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

public class FilteringGeneratorDelegate_writeRaw_23_1_Test {

    private JsonGenerator mockJsonGenerator;

    private TokenFilter mockTokenFilter;

    private FilteringGeneratorDelegate filteringGeneratorDelegate;

    @BeforeEach
    public void setUp() {
        mockJsonGenerator = mock(JsonGenerator.class);
        mockTokenFilter = mock(TokenFilter.class);
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, mockTokenFilter, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
    }

    @Test
    public void testWriteRaw_WithValidInput_ShouldCallDelegate() throws IOException {
        String text = "Sample text";
        int offset = 0;
        int len = text.length();
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator).writeRaw(text, offset, len);
    }

    @Test
    public void testWriteRaw_WithNullText_ShouldNotCallDelegate() throws IOException {
        String text = null;
        int offset = 0;
        int len = 0;
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    @Test
    public void testWriteRaw_WithTextAndOffset_ShouldCallDelegate() throws IOException {
        String text = "Another sample text";
        int offset = 0;
        int len = 18;
        when(mockTokenFilter.includeRawValue()).thenReturn(true);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator).writeRaw(text, offset, len);
    }

    @Test
    public void testWriteRaw_WithNoRawValueWrite_ShouldNotCallDelegate() throws IOException {
        String text = "Sample text";
        int offset = 0;
        int len = text.length();
        when(mockTokenFilter.includeRawValue()).thenReturn(false);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }

    @Test
    public void testWriteRaw_WithNullTokenFilter_ShouldNotCallDelegate() throws IOException {
        String text = "Sample text";
        int offset = 0;
        int len = text.length();
        filteringGeneratorDelegate = new FilteringGeneratorDelegate(mockJsonGenerator, null, TokenFilter.Inclusion.ONLY_INCLUDE_ALL, true);
        filteringGeneratorDelegate.writeRaw(text, offset, len);
        verify(mockJsonGenerator, never()).writeRaw(anyString(), anyInt(), anyInt());
    }
}
