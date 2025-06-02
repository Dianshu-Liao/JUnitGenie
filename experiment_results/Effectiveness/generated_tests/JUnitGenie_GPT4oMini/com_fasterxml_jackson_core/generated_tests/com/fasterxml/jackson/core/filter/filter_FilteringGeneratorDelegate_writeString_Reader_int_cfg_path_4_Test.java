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

public class filter_FilteringGeneratorDelegate_writeString_Reader_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testWriteString_withValidParameters() {
        // Arrange
        TokenFilter tokenFilter = TokenFilter.INCLUDE_ALL;
        TokenFilterContext filterContext = Mockito.mock(TokenFilterContext.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, true);
        
        // Set the protected fields using reflection
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(delegate, tokenFilter);
            
            java.lang.reflect.Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            filterContextField.setAccessible(true);
            filterContextField.set(delegate, filterContext);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator).writeString(reader, len);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withNullItemFilter() {
        // Arrange
        TokenFilter tokenFilter = null;
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, true);
        
        // Set the protected field _itemFilter to null
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(delegate, tokenFilter);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Reader reader = new StringReader("test string");
        int len = 11;

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.never()).writeString(Mockito.any(Reader.class), Mockito.anyInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testWriteString_withNonIncludeAllFilter() {
        // Arrange
        TokenFilter tokenFilter = Mockito.mock(TokenFilter.class);
        TokenFilterContext filterContext = Mockito.mock(TokenFilterContext.class);
        JsonGenerator jsonGenerator = Mockito.mock(JsonGenerator.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(jsonGenerator, tokenFilter, true, true);
        
        // Set the protected fields using reflection
        try {
            java.lang.reflect.Field itemFilterField = FilteringGeneratorDelegate.class.getDeclaredField("_itemFilter");
            itemFilterField.setAccessible(true);
            itemFilterField.set(delegate, tokenFilter);
            
            java.lang.reflect.Field filterContextField = FilteringGeneratorDelegate.class.getDeclaredField("_filterContext");
            filterContextField.setAccessible(true);
            filterContextField.set(delegate, filterContext);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        Reader reader = new StringReader("test string");
        int len = 11;

        // Mock behavior of checkValue
        Mockito.when(filterContext.checkValue(tokenFilter)).thenReturn(tokenFilter);
        Mockito.when(tokenFilter.includeString(reader, len)).thenReturn(false);

        // Act
        try {
            delegate.writeString(reader, len);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        try {
            Mockito.verify(jsonGenerator, Mockito.never()).writeString(Mockito.any(Reader.class), Mockito.anyInt());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}