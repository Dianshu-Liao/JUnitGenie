package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
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
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CSVRecord_isSet_13_0_Test {

    private CSVParser parser;

    private CSVRecord csvRecord;

    @BeforeEach
    void setUp() {
        // Create a mock CSVParser with a header map
        parser = createMockCSVParser();
        String[] values = { "value1", "value2", "value3" };
        csvRecord = new CSVRecord(parser, values, null, 1, 0, 0);
    }

    private CSVParser createMockCSVParser() {
        // Create a mock CSVParser with a predefined header map
        try {
            Map<String, Integer> headerMap = new HashMap<>();
            headerMap.put("header1", 0);
            headerMap.put("header2", 1);
            headerMap.put("header3", 2);
            // Use appropriate constructor
            CSVParser parser = (CSVParser) new CSVParser(null, null);
            // Use reflection to set the headerMap in parser
            Method setHeaderMapMethod = CSVParser.class.getDeclaredMethod("setHeaderMap", Map.class);
            setHeaderMapMethod.setAccessible(true);
            setHeaderMapMethod.invoke(parser, headerMap);
            return parser;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void testIsSet_WithMappedHeader_WithinBounds() {
        assertTrue(csvRecord.isSet("header1"));
    }

    @Test
    void testIsSet_WithMappedHeader_OutOfBounds() {
        // header3 is valid but out of bounds
        assertFalse(csvRecord.isSet("header3"));
    }

    @Test
    void testIsSet_WithUnmappedHeader() {
        // header4 does not exist
        assertFalse(csvRecord.isSet("header4"));
    }

    @Test
    void testIsSet_WithNullHeader() {
        // null header
        assertFalse(csvRecord.isSet(null));
    }

    @Test
    void testIsSet_WithEmptyHeader() {
        // empty string header
        assertFalse(csvRecord.isSet(""));
    }

    @Test
    void testIsSet_WithMappedHeader_AtBounds() {
        // header2 is valid but exactly at the last index
        assertFalse(csvRecord.isSet("header2"));
    }
}
