package com.fasterxml.jackson.core.filter;

import com.fasterxml.jackson.core.filter.TokenFilter;
import com.fasterxml.jackson.core.filter.TokenFilterContext;
import java.io.IOException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;

class TokenFilterContext_closeObject_10_0_Test {

    private TokenFilterContext context;

    private TokenFilterContext parentContext;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    void setUp() {
        parentContext = mock(TokenFilterContext.class);
        jsonGenerator = mock(JsonGenerator.class);
    }

    @Test
    void testCloseObject_WhenStartHandled() throws IOException {
        // Arrange
        context = new TokenFilterContext(0, parentContext, null, true);
        // Act
        TokenFilterContext result = context.closeObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeEndObject();
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_WhenFilterIsNotIncludeAllAndIncludeEmptyObjectTrue() throws IOException {
        // Arrange
        TokenFilter filter = mock(TokenFilter.class);
        when(filter.includeEmptyObject(anyBoolean())).thenReturn(true);
        context = new TokenFilterContext(0, parentContext, filter, false);
        // Act
        TokenFilterContext result = context.closeObject(jsonGenerator);
        // Assert
        verify(parentContext).getCurrentName();
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(filter).filterFinishObject();
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_WhenFilterIsNotIncludeAllAndIncludeEmptyObjectFalse() throws IOException {
        // Arrange
        TokenFilter filter = mock(TokenFilter.class);
        when(filter.includeEmptyObject(anyBoolean())).thenReturn(false);
        context = new TokenFilterContext(0, parentContext, filter, false);
        // Act
        TokenFilterContext result = context.closeObject(jsonGenerator);
        // Assert
        verify(filter).filterFinishObject();
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_WhenFilterIsIncludeAll() throws IOException {
        // Arrange
        context = new TokenFilterContext(0, parentContext, TokenFilter.INCLUDE_ALL, false);
        // Act
        TokenFilterContext result = context.closeObject(jsonGenerator);
        // Assert
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }
}
