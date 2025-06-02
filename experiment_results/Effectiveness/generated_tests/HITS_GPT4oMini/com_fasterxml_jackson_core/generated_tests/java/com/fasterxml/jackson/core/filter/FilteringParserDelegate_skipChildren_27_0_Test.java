package com.fasterxml.jackson.core.filter;

import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.filter.TokenFilter.Inclusion;
import com.fasterxml.jackson.core.util.JsonParserDelegate;
import static com.fasterxml.jackson.core.JsonTokenId.*;

public class FilteringParserDelegate_skipChildren_27_0_Test {

    private JsonParser jsonParser;

    private TokenFilter tokenFilter;

    private FilteringParserDelegate filteringParserDelegate;

    @BeforeEach
    public void setUp() throws IOException {
        // Setting up a simple JsonParser with a test JSON string
        JsonFactory jsonFactory = new JsonFactory();
        jsonParser = jsonFactory.createParser("{\"key1\": \"value1\", \"key2\": [1, 2, 3]}");
        // Using the include all filter for simplicity
        tokenFilter = TokenFilter.INCLUDE_ALL;
        filteringParserDelegate = new FilteringParserDelegate(jsonParser, tokenFilter, true, true);
    }

    @Test
    public void testSkipChildrenWithStartObject() throws IOException {
        // Move to START_OBJECT
        filteringParserDelegate.nextToken();
        JsonParser result = filteringParserDelegate.skipChildren();
        assertEquals(filteringParserDelegate, result);
    }

    @Test
    public void testSkipChildrenWithStartArray() throws IOException {
        // Move to START_OBJECT
        filteringParserDelegate.nextToken();
        // Move to key1
        filteringParserDelegate.nextToken();
        // Move to value1
        filteringParserDelegate.nextToken();
        // Move to key2
        filteringParserDelegate.nextToken();
        // Move to START_ARRAY
        filteringParserDelegate.nextToken();
        JsonParser result = filteringParserDelegate.skipChildren();
        assertEquals(filteringParserDelegate, result);
    }

    @Test
    public void testSkipChildrenWithEndObject() throws IOException {
        // Move to START_OBJECT
        filteringParserDelegate.nextToken();
        // Move to key1
        filteringParserDelegate.nextToken();
        // Move to value1
        filteringParserDelegate.nextToken();
        // Move to key2
        filteringParserDelegate.nextToken();
        // Move to START_ARRAY
        filteringParserDelegate.nextToken();
        // Move to value 1
        filteringParserDelegate.nextToken();
        // Move to value 2
        filteringParserDelegate.nextToken();
        // Move to value 3
        filteringParserDelegate.nextToken();
        // Move to END_ARRAY
        filteringParserDelegate.nextToken();
        // Move to END_OBJECT
        filteringParserDelegate.nextToken();
        JsonParser result = filteringParserDelegate.skipChildren();
        assertEquals(filteringParserDelegate, result);
    }

    @Test
    public void testSkipChildrenWithNoChild() throws IOException {
        // Move to START_OBJECT
        filteringParserDelegate.nextToken();
        // Move to key1
        filteringParserDelegate.nextToken();
        // Move to value1
        filteringParserDelegate.nextToken();
        // Move to key2
        filteringParserDelegate.nextToken();
        // Move to START_ARRAY
        filteringParserDelegate.nextToken();
        // Move to END_ARRAY
        filteringParserDelegate.nextToken();
        JsonParser result = filteringParserDelegate.skipChildren();
        assertEquals(filteringParserDelegate, result);
    }

    @Test
    public void testSkipChildrenWithNullToken() throws IOException {
        // Move to START_OBJECT
        filteringParserDelegate.nextToken();
        // Move to key1
        filteringParserDelegate.nextToken();
        // Move to value1
        filteringParserDelegate.nextToken();
        // Move to key2
        filteringParserDelegate.nextToken();
        // Move to START_ARRAY
        filteringParserDelegate.nextToken();
        // Move to END_ARRAY
        filteringParserDelegate.nextToken();
        // Move to END_OBJECT
        filteringParserDelegate.nextToken();
        // Move to null (end of input)
        filteringParserDelegate.nextToken();
        JsonParser result = filteringParserDelegate.skipChildren();
        assertEquals(filteringParserDelegate, result);
    }
}
