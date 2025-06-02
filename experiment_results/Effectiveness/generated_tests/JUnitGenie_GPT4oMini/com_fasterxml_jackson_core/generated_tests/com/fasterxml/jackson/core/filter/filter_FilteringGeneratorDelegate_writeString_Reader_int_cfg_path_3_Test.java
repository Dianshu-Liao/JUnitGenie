package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class filter_FilteringGeneratorDelegate_writeString_Reader_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteString_withValidParameters() {
        // Arrange
        TokenFilter tokenFilter = Mockito.mock(TokenFilter.class); // Mock TokenFilter
        TokenFilterContext filterContext = Mockito.mock(TokenFilterContext.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, false);
        
        delegate._itemFilter = tokenFilter; // Set the _itemFilter
        delegate._filterContext = filterContext; // Set the _filterContext

        Reader reader = new StringReader("test string");
        int len = 10;

        Mockito.when(filterContext.checkValue(tokenFilter)).thenReturn(TokenFilter.INCLUDE_ALL);
        Mockito.when(tokenFilter.includeString(Mockito.any(Reader.class), Mockito.anyInt())).thenReturn(true); // Use Mockito.any()

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator).writeString(reader, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withNullItemFilter() {
        // Arrange
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, null, true, false);
        
        Reader reader = new StringReader("test string");
        int len = 10;

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.never()).writeString(Mockito.any(Reader.class), Mockito.anyInt());
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withNonIncludeAllFilter() {
        // Arrange
        TokenFilter tokenFilter = Mockito.mock(TokenFilter.class); // Mock TokenFilter
        TokenFilterContext filterContext = Mockito.mock(TokenFilterContext.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, false);
        
        delegate._itemFilter = tokenFilter; // Set the _itemFilter
        delegate._filterContext = filterContext; // Set the _filterContext

        Reader reader = new StringReader("test string");
        int len = 10;

        Mockito.when(filterContext.checkValue(tokenFilter)).thenReturn(tokenFilter);
        Mockito.when(tokenFilter.includeString(Mockito.any(Reader.class), Mockito.anyInt())).thenReturn(false); // Use Mockito.any()

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.never()).writeString(reader, len);
        } catch (IOException e) {
            // Handle exception
            e.printStackTrace();
        }
    }

}