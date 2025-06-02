package com.fasterxml.jackson.core.filter;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.filter.FilteringParserDelegate;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class filter_FilteringParserDelegate_skipChildren__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testSkipChildren_WhenCurrTokenIsNotStartObjectOrStartArray() throws IOException {
        // Setup
        JsonParser mockParser = mock(JsonParser.class); // Create a mock parser
        FilteringParserDelegate delegate = new FilteringParserDelegate(mockParser, null, false, false);
        delegate._currToken = JsonToken.VALUE_STRING; // Setting _currToken to a value that is not START_OBJECT or START_ARRAY
        
        // Act
        JsonParser result = delegate.skipChildren();
        
        // Assert
        assertEquals(delegate, result);
    }

    @Test(timeout = 4000)
    public void testSkipChildren_WhenCurrTokenIsStartObject() throws IOException {
        // Setup
        JsonParser mockParser = mock(JsonParser.class); // Create a mock parser
        FilteringParserDelegate delegate = new FilteringParserDelegate(mockParser, null, false, false);
        delegate._currToken = JsonToken.START_OBJECT; // Setting _currToken to START_OBJECT
        
        // Simulate nested structure by mocking the nextToken method to return a START_OBJECT
        // followed by an END_OBJECT, ensuring we reach the end of the structure.
        when(mockParser.nextToken()).thenReturn(JsonToken.START_OBJECT, JsonToken.END_OBJECT, null);
        
        // Act
        JsonParser result = delegate.skipChildren();
        
        // Assert
        assertEquals(delegate, result);
    }

    @Test(timeout = 4000)
    public void testSkipChildren_WhenCurrTokenIsStartArray() throws IOException {
        // Setup
        JsonParser mockParser = mock(JsonParser.class); // Create a mock parser
        FilteringParserDelegate delegate = new FilteringParserDelegate(mockParser, null, false, false);
        delegate._currToken = JsonToken.START_ARRAY; // Setting _currToken to START_ARRAY
        
        // Simulate nested structure similar to the previous test
        when(mockParser.nextToken()).thenReturn(JsonToken.START_ARRAY, JsonToken.END_ARRAY, null);
        
        // Act
        JsonParser result = delegate.skipChildren();

        // Assert
        assertEquals(delegate, result);
    }

    @Test(timeout = 4000)
    public void testSkipChildren_WhenNextTokenReturnsNull() throws IOException {
        // Setup
        JsonParser mockParser = mock(JsonParser.class); // Create a mock parser
        FilteringParserDelegate delegate = new FilteringParserDelegate(mockParser, null, false, false);
        delegate._currToken = JsonToken.START_OBJECT; // Starting token presumed
        
        // Act
        JsonParser result = delegate.skipChildren();

        // Assert
        assertEquals(delegate, result);
    }


}