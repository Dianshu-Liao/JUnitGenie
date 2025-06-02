package org.apache.commons.csv;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVRecord_hasComment_9_0_Test {

    private CSVParser mockParser;

    private CSVRecord recordWithComment;

    private CSVRecord recordWithoutComment;

    @BeforeEach
    public void setUp() {
        // Create a mock CSVParser using Mockito
        mockParser = mock(CSVParser.class);
        String[] values = { "value1", "value2" };
        // Initialize CSVRecord with a comment
        recordWithComment = new CSVRecord(mockParser, values, "This is a comment", 1, 0, 0);
        // Initialize CSVRecord without a comment
        recordWithoutComment = new CSVRecord(mockParser, values, null, 2, 0, 0);
    }

    @Test
    public void testHasComment_WithComment_ReturnsTrue() {
        assertTrue(recordWithComment.hasComment(), "Expected hasComment() to return true when a comment is present.");
    }

    @Test
    public void testHasComment_WithoutComment_ReturnsFalse() {
        assertFalse(recordWithoutComment.hasComment(), "Expected hasComment() to return false when no comment is present.");
    }
}
