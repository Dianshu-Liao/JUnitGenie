package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.format.DataFormatMatcher;
import com.fasterxml.jackson.core.format.MatchStrength;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.*;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.MergedStream;

class DataFormatMatcher_getMatchedFormatName_3_0_Test {

    private DataFormatMatcher dataFormatMatcher;

    @BeforeEach
    void setUp() {
        // Setup with a valid JsonFactory and MatchStrength.
        JsonFactory jsonFactory = new JsonFactory();
        // Assuming SOLID_MATCH is a valid instance
        MatchStrength matchStrength = MatchStrength.SOLID_MATCH;
        // Example buffered data
        byte[] bufferedData = "{\"key\":\"value\"}".getBytes();
        int bufferedStart = 0;
        int bufferedLength = bufferedData.length;
        // Initialize the DataFormatMatcher
        dataFormatMatcher = new DataFormatMatcher(new ByteArrayInputStream(bufferedData), bufferedData, bufferedStart, bufferedLength, jsonFactory, matchStrength);
    }

    @Test
    void testGetMatchedFormatName_WithMatch() {
        // Test when there is a match
        String expectedFormatName = dataFormatMatcher.getMatch().getFormatName();
        String actualFormatName = dataFormatMatcher.getMatchedFormatName();
        assertEquals(expectedFormatName, actualFormatName);
    }

    @Test
    void testGetMatchedFormatName_WithoutMatch() {
        // Set the match to null to simulate no match
        try {
            java.lang.reflect.Field matchField = DataFormatMatcher.class.getDeclaredField("_match");
            matchField.setAccessible(true);
            matchField.set(dataFormatMatcher, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Test when there is no match
        String actualFormatName = dataFormatMatcher.getMatchedFormatName();
        assertNull(actualFormatName);
    }
}
