package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

class TokenFilterContext_closeObject_10_0_Test {

    private TokenFilterContext parentContext;

    private TokenFilterContext childContext;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    void setUp() {
        parentContext = Mockito.mock(TokenFilterContext.class);
        jsonGenerator = Mockito.mock(JsonGenerator.class);
        childContext = new TokenFilterContext(0, parentContext, TokenFilter.INCLUDE_ALL, false);
    }

    @Test
    void testCloseObject_StartHandled() throws IOException {
        // Arrange
        childContext._startHandled = true;
        // Act
        TokenFilterContext result = childContext.closeObject(jsonGenerator);
        // Assert
        verify(jsonGenerator).writeEndObject();
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_FilterNotNullAndIncludeEmptyObject() throws IOException {
        // Arrange
        TokenFilter mockFilter = Mockito.mock(TokenFilter.class);
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(true);
        childContext._filter = mockFilter;
        childContext._startHandled = false;
        // Act
        TokenFilterContext result = childContext.closeObject(jsonGenerator);
        // Assert
        verify(mockFilter).includeEmptyObject(anyBoolean());
        verify(parentContext).closeObject(jsonGenerator);
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(mockFilter).filterFinishObject();
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_FilterNotNullAndNotIncludeEmptyObject() throws IOException {
        // Arrange
        TokenFilter mockFilter = Mockito.mock(TokenFilter.class);
        when(mockFilter.includeEmptyObject(anyBoolean())).thenReturn(false);
        childContext._filter = mockFilter;
        childContext._startHandled = false;
        // Act
        TokenFilterContext result = childContext.closeObject(jsonGenerator);
        // Assert
        verify(mockFilter).includeEmptyObject(anyBoolean());
        verifyNoInteractions(jsonGenerator);
        verify(mockFilter).filterFinishObject();
        assertSame(parentContext, result);
    }

    @Test
    void testCloseObject_FilterIsNull() throws IOException {
        // Arrange
        childContext._filter = null;
        childContext._startHandled = false;
        // Act
        TokenFilterContext result = childContext.closeObject(jsonGenerator);
        // Assert
        verifyNoInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }
}
