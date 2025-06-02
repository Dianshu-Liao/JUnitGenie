package com.fasterxml.jackson.core.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.*;
import com.fasterxml.jackson.core.*;

public class JsonParserSequence_switchToNext_7_2_Test {

    private JsonParserSequence jsonParserSequence;

    private JsonParser parser1;

    private JsonParser parser2;

    private JsonParser parser3;

    @BeforeEach
    public void setUp() throws Exception {
        JsonFactory jsonFactory = new JsonFactory();
        parser1 = jsonFactory.createParser("{\"key1\":\"value1\"}");
        parser2 = jsonFactory.createParser("{\"key2\":\"value2\"}");
        parser3 = jsonFactory.createParser("{\"key3\":\"value3\"}");
        JsonParser[] parsers = new JsonParser[] { parser1, parser2, parser3 };
        jsonParserSequence = new JsonParserSequence(true, parsers);
    }

    @Test
    public void testSwitchToNext_FirstParser() {
        assertTrue(jsonParserSequence.switchToNext(), "Should switch to the first parser successfully.");
    }

    @Test
    public void testSwitchToNext_SecondParser() {
        // Move to first parser
        jsonParserSequence.switchToNext();
        assertTrue(jsonParserSequence.switchToNext(), "Should switch to the second parser successfully.");
    }

    @Test
    public void testSwitchToNext_ThirdParser() {
        // Move to first parser
        jsonParserSequence.switchToNext();
        // Move to second parser
        jsonParserSequence.switchToNext();
        assertTrue(jsonParserSequence.switchToNext(), "Should switch to the third parser successfully.");
    }

    @Test
    public void testSwitchToNext_NoMoreParsers() {
        // Move to first parser
        jsonParserSequence.switchToNext();
        // Move to second parser
        jsonParserSequence.switchToNext();
        // Move to third parser
        jsonParserSequence.switchToNext();
        assertFalse(jsonParserSequence.switchToNext(), "Should not switch to next parser, all parsers are used.");
    }
}
