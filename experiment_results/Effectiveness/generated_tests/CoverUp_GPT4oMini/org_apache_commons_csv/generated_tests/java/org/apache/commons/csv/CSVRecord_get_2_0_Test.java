package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CSVRecord_get_2_0_Test {

    private CSVParser parser;

    private CSVRecord record;

    @BeforeEach
    void setUp() throws IOException {
        // Mocking CSVParser
        parser = new CSVParser(new StringReader("header1,header2\nvalue1,value2"), CSVFormat.DEFAULT);
        String[] values = { "value1", "value2" };
        record = new CSVRecord(parser, values, null, 1, 0, 0);
    }

    @Test
    void testGetValidHeader() {
        // Assuming the header map contains the following
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        headerMap.put("header2", 1);
        setHeaderMap(parser, headerMap);
        String result = record.get("header1");
        assertEquals("value1", result);
    }

    @Test
    void testGetNullHeaderMap() {
        // Set parser to return null for header map
        setHeaderMap(parser, null);
        IllegalStateException exception = assertThrows(IllegalStateException.class, () -> {
            record.get("header1");
        });
        assertEquals("No header mapping was specified, the record values can't be accessed by name", exception.getMessage());
    }

    @Test
    void testGetInvalidHeader() {
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        setHeaderMap(parser, headerMap);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            record.get("header3");
        });
        assertEquals("Mapping for header3 not found, expected one of [header1]", exception.getMessage());
    }

    @Test
    void testGetOutOfBoundsIndex() {
        Map<String, Integer> headerMap = new HashMap<>();
        // Intentionally wrong index
        headerMap.put("header1", 1);
        setHeaderMap(parser, headerMap);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            record.get("header1");
        });
        assertEquals("Index for header 'header1' is 1 but CSVRecord only has 2 values!", exception.getMessage());
    }

    private void setHeaderMap(CSVParser parser, Map<String, Integer> headerMap) {
        try {
            Method method = CSVParser.class.getDeclaredMethod("setHeaderMap", Map.class);
            method.setAccessible(true);
            method.invoke(parser, headerMap);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
