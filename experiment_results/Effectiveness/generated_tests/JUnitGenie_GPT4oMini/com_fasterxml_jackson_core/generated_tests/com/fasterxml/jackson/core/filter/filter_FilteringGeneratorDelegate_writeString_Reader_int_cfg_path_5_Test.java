package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;
import static org.mockito.Mockito.*;

public class filter_FilteringGeneratorDelegate_writeString_Reader_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testWriteString_withNullItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = null; // _itemFilter is null
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, true);
        delegate._filterContext = mockContext;

        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        delegate.writeString(reader, len);

        // Assert
        // Verify that writeString is not called on the delegate since _itemFilter is null
        verify(mockGenerator, never()).writeString(any(Reader.class), anyInt());
    }

    @Test(timeout = 4000)
    public void testWriteString_withIncludeAllItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, TokenFilter.INCLUDE_ALL, true, true);
        
        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        delegate.writeString(reader, len);

        // Assert
        // Verify that writeString is called on the delegate since _itemFilter is INCLUDE_ALL
        verify(mockGenerator).writeString(reader, len);
    }

    @Test(timeout = 4000)
    public void testWriteString_withNonIncludeAllItemFilter() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = mock(JsonGenerator.class);
        TokenFilter mockFilter = mock(TokenFilter.class);
        TokenFilterContext mockContext = mock(TokenFilterContext.class);
        when(mockContext.checkValue(mockFilter)).thenReturn(null); // Simulate checkValue returning null
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, true);
        delegate._filterContext = mockContext;

        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        delegate.writeString(reader, len);

        // Assert
        // Verify that writeString is not called on the delegate since checkValue returned null
        verify(mockGenerator, never()).writeString(any(Reader.class), anyInt());
    }


}