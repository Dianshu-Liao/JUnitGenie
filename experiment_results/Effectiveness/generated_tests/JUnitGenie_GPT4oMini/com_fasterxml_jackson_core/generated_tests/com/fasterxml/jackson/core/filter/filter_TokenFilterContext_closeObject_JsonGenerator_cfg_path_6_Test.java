package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import org.junit.Test;
import org.mockito.Mockito;
import java.io.IOException;

public class filter_TokenFilterContext_closeObject_JsonGenerator_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCloseObject_withStartHandled() throws IOException {
        // Arrange
        TokenFilterContext context = Mockito.mock(TokenFilterContext.class);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        Mockito.when(context._startHandled).thenReturn(true);

        // Act
        context.closeObject(gen);

        // Assert
        Mockito.verify(gen).writeEndObject();
    }

    @Test(timeout = 4000)
    public void testCloseObject_withFilterNotIncludeAll_andIncludeEmptyObjectTrue() throws IOException {
        // Arrange
        TokenFilterContext parentContext = Mockito.mock(TokenFilterContext.class);
        TokenFilter filter = Mockito.mock(TokenFilter.class);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        
        TokenFilterContext context = Mockito.mock(TokenFilterContext.class);
        Mockito.when(context._startHandled).thenReturn(false);
        Mockito.when(context._filter).thenReturn(filter);
        Mockito.when(context._parent).thenReturn(parentContext);
        Mockito.when(filter.includeEmptyObject(Mockito.anyBoolean())).thenReturn(true);
        Mockito.when(context.hasCurrentName()).thenReturn(true);

        // Act
        context.closeObject(gen);

        // Assert
        Mockito.verify(parentContext).writePath(gen);
        Mockito.verify(gen).writeStartObject();
        Mockito.verify(gen).writeEndObject();
    }

    @Test(timeout = 4000)
    public void testCloseObject_withFilterNotIncludeAll_andFilterFinishObject() throws IOException {
        // Arrange
        TokenFilterContext parentContext = Mockito.mock(TokenFilterContext.class);
        TokenFilter filter = Mockito.mock(TokenFilter.class);
        JsonGenerator gen = Mockito.mock(JsonGenerator.class);
        
        TokenFilterContext context = Mockito.mock(TokenFilterContext.class);
        Mockito.when(context._startHandled).thenReturn(false);
        Mockito.when(context._filter).thenReturn(filter);
        Mockito.when(context._parent).thenReturn(parentContext);
        Mockito.when(filter.includeEmptyObject(Mockito.anyBoolean())).thenReturn(false);

        // Act
        context.closeObject(gen);

        // Assert
        Mockito.verify(filter).filterFinishObject();
    }


}