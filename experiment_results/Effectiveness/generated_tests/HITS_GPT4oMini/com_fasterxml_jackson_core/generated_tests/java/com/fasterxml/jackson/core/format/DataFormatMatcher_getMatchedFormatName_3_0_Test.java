package com.fasterxml.jackson.core.format;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;

public class DataFormatMatcher_getMatchedFormatName_3_0_Test {

    private DataFormatMatcher matcherWithMatch;

    private DataFormatMatcher matcherWithoutMatch;

    @BeforeEach
    public void setUp() {
        // Set up a match with a JSON factory
        JsonFactory jsonFactory = new JsonFactory();
        InputStream inputStream = new ByteArrayInputStream(new byte[] {});
        byte[] bufferedData = new byte[] {};
        int bufferedStart = 0;
        int bufferedLength = 0;
        matcherWithMatch = new DataFormatMatcher(inputStream, bufferedData, bufferedStart, bufferedLength, jsonFactory, MatchStrength.SOLID_MATCH);
        // Set up without a match
        matcherWithoutMatch = new DataFormatMatcher(inputStream, bufferedData, bufferedStart, bufferedLength, null, null);
    }

    @Test
    public void testGetMatchedFormatName_WithMatch() {
        String formatName = matcherWithMatch.getMatchedFormatName();
        assertEquals("JSON", formatName, "Expected format name to be JSON when there is a match.");
    }

    @Test
    public void testGetMatchedFormatName_WithoutMatch() {
        String formatName = matcherWithoutMatch.getMatchedFormatName();
        assertNull(formatName, "Expected format name to be null when there is no match.");
    }
}
