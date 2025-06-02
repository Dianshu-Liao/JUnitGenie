package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.*;

public class TokenFilterContext_closeObject_10_0_Test {

    private TokenFilterContext context;

    private TokenFilterContext parentContext;

    private JsonGenerator jsonGenerator;

    @BeforeEach
    public void setUp() {
        parentContext = mock(TokenFilterContext.class);
        jsonGenerator = mock(JsonGenerator.class);
        context = new TokenFilterContext(0, parentContext, TokenFilter.INCLUDE_ALL, false);
    }

    @Test
    public void testCloseObject_WithStartHandled() throws IOException {
        context._startHandled = true;
        TokenFilterContext result = context.closeObject(jsonGenerator);
        verify(jsonGenerator).writeEndObject();
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    public void testCloseObject_WithFilterNotNullAndIncludeEmptyObject() throws IOException {
        TokenFilter filter = mock(TokenFilter.class);
        when(filter.includeEmptyObject(anyBoolean())).thenReturn(true);
        context._filter = filter;
        context._currentName = "testName";
        TokenFilterContext result = context.closeObject(jsonGenerator);
        verify(parentContext).getCurrentName();
        verify(jsonGenerator).writeStartObject();
        verify(jsonGenerator).writeEndObject();
        verify(filter).filterFinishObject();
        assertSame(parentContext, result);
    }

    @Test
    public void testCloseObject_WithFilterNotNullAndNotIncludeEmptyObject() throws IOException {
        TokenFilter filter = mock(TokenFilter.class);
        when(filter.includeEmptyObject(anyBoolean())).thenReturn(false);
        context._filter = filter;
        TokenFilterContext result = context.closeObject(jsonGenerator);
        verify(filter).filterFinishObject();
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    public void testCloseObject_WithFilterNull() throws IOException {
        context._filter = null;
        TokenFilterContext result = context.closeObject(jsonGenerator);
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }

    @Test
    public void testCloseObject_WithFilterIncludeAll() throws IOException {
        context._filter = TokenFilter.INCLUDE_ALL;
        TokenFilterContext result = context.closeObject(jsonGenerator);
        verifyNoMoreInteractions(jsonGenerator);
        assertSame(parentContext, result);
    }
}
