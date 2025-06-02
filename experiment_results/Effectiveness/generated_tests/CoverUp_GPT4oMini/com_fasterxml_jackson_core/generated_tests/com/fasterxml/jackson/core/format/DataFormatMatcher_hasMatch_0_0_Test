package com.fasterxml.jackson.core.format;

import com.fasterxml.jackson.core.JsonFactory;
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

public class DataFormatMatcher_hasMatch_0_0_Test {

    private DataFormatMatcher dataFormatMatcherWithMatch;

    private DataFormatMatcher dataFormatMatcherWithoutMatch;

    @BeforeEach
    public void setUp() {
        // Initialize with a match
        JsonFactory jsonFactory = new JsonFactory();
        MatchStrength matchStrength = MatchStrength.SOLID_MATCH;
        byte[] bufferedData = new byte[] { 1, 2, 3, 4, 5 };
        dataFormatMatcherWithMatch = new DataFormatMatcher(new ByteArrayInputStream(bufferedData), bufferedData, 0, bufferedData.length, jsonFactory, matchStrength);
        // Initialize without a match
        dataFormatMatcherWithoutMatch = new DataFormatMatcher(new ByteArrayInputStream(bufferedData), bufferedData, 0, bufferedData.length, null, null);
    }

    @Test
    public void testHasMatch_WithMatch_ReturnsTrue() {
        assertTrue(dataFormatMatcherWithMatch.hasMatch());
    }

    @Test
    public void testHasMatch_WithoutMatch_ReturnsFalse() {
        assertFalse(dataFormatMatcherWithoutMatch.hasMatch());
    }

    @Test
    public void testGetMatchStrength_WithMatch_ReturnsStrength() {
        assertEquals(MatchStrength.SOLID_MATCH, dataFormatMatcherWithMatch.getMatchStrength());
    }

    @Test
    public void testGetMatchStrength_WithoutMatch_ReturnsInconclusive() {
        assertEquals(MatchStrength.INCONCLUSIVE, dataFormatMatcherWithoutMatch.getMatchStrength());
    }

    @Test
    public void testGetMatchedFormatName_WithMatch_ReturnsFormatName() {
        assertNotNull(dataFormatMatcherWithMatch.getMatchedFormatName());
    }

    @Test
    public void testGetMatchedFormatName_WithoutMatch_ReturnsNull() {
        assertNull(dataFormatMatcherWithoutMatch.getMatchedFormatName());
    }

    @Test
    public void testCreateParserWithMatch_WithMatch_ReturnsParser() throws Exception {
        assertNotNull(dataFormatMatcherWithMatch.createParserWithMatch());
    }

    @Test
    public void testCreateParserWithMatch_WithoutMatch_ReturnsNull() throws Exception {
        assertNull(dataFormatMatcherWithoutMatch.createParserWithMatch());
    }

    @Test
    public void testGetDataStream_WithOriginalStream_ReturnsMergedStream() {
        InputStream stream = dataFormatMatcherWithMatch.getDataStream();
        assertNotNull(stream);
    }

    @Test
    public void testGetDataStream_WithoutOriginalStream_ReturnsByteArrayInputStream() {
        InputStream stream = dataFormatMatcherWithoutMatch.getDataStream();
        assertNotNull(stream);
    }
}
