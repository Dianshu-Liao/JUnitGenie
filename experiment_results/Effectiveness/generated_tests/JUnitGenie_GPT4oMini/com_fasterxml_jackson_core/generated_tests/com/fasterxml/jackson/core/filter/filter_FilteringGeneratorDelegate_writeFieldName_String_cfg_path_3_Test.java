package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.filter.FilteringGeneratorDelegate;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class filter_FilteringGeneratorDelegate_writeFieldName_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteFieldName_withValidName() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockFilter = Mockito.mock(TokenFilter.class);
        TokenFilterContext mockContext = Mockito.mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, false);
        Mockito.when(mockContext.setFieldName(Mockito.anyString())).thenReturn(TokenFilter.INCLUDE_ALL);
        delegate._filterContext = mockContext;

        String name = "validFieldName";

        // Act
        delegate.writeFieldName(name);

        // Assert
        Mockito.verify(mockGenerator).writeFieldName(name);
    }

    @Test(timeout = 4000)
    public void testWriteFieldName_withNullName() throws IOException {
        // Arrange
        JsonGenerator mockGenerator = Mockito.mock(JsonGenerator.class);
        TokenFilter mockFilter = Mockito.mock(TokenFilter.class);
        TokenFilterContext mockContext = Mockito.mock(TokenFilterContext.class);
        FilteringGeneratorDelegate delegate = new FilteringGeneratorDelegate(mockGenerator, mockFilter, true, false);
        delegate._filterContext = mockContext;

        String name = null;

        // Act
        delegate.writeFieldName(name);

        // Assert
        // Verify that the delegate's writeFieldName method is not called
        Mockito.verify(mockGenerator, Mockito.never()).writeFieldName(Mockito.anyString());
    }


}