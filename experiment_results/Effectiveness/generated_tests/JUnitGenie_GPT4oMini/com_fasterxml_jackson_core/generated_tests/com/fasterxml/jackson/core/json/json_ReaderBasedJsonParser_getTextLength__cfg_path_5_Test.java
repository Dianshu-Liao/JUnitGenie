package com.fasterxml.jackson.core.json;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.io.IOContext;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.io.Reader;

public class json_ReaderBasedJsonParser_getTextLength__cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testGetTextLengthWithValidToken() throws Exception {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        Reader reader = mock(Reader.class);
        JsonReadContext parsingContext = mock(JsonReadContext.class);
        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, 0, reader, null, null);
        
        // Mocking the _currToken to return a valid token ID
        JsonToken token = mock(JsonToken.class);
        when(token.id()).thenReturn(5); // Assuming 5 is a valid ID
        // Using reflection to set the protected field _currToken
        java.lang.reflect.Field currTokenField = ReaderBasedJsonParser.class.getDeclaredField("_currToken");
        currTokenField.setAccessible(true);
        currTokenField.set(parser, token);

        // Mocking the parsingContext to return a valid current name
        when(parsingContext.getCurrentName()).thenReturn("testName");
        // Using reflection to set the protected field _parsingContext
        java.lang.reflect.Field parsingContextField = ReaderBasedJsonParser.class.getDeclaredField("_parsingContext");
        parsingContextField.setAccessible(true);
        parsingContextField.set(parser, parsingContext);

        // Act
        int length = parser.getTextLength();

        // Assert
        assertEquals(9, length); // "testName".length() is 9
    }

    @Test(timeout = 4000)
    public void testGetTextLengthWithNullToken() throws Exception {
        // Arrange
        IOContext ioContext = mock(IOContext.class);
        Reader reader = mock(Reader.class);
        ReaderBasedJsonParser parser = new ReaderBasedJsonParser(ioContext, 0, reader, null, null);
        
        // Act
        int length = parser.getTextLength();

        // Assert
        assertEquals(0, length); // Expecting 0 when _currToken is null
    }

}