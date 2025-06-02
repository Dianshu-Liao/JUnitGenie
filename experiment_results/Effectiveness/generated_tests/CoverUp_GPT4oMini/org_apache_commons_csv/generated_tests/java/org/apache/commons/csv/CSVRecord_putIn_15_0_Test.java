package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
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

class CSVRecord_putIn_15_0_Test {

    private CSVParser mockParser;

    private CSVRecord csvRecord;

    @BeforeEach
    void setUp() {
        mockParser = mock(CSVParser.class);
        String[] values = { "value1", "value2", "value3" };
        csvRecord = new CSVRecord(mockParser, values, "comment", 1, 0, 0);
    }

    @Test
    void testPutIn_WithNullHeaderMap() {
        when(mockParser.getHeaderMapRaw()).thenReturn(null);
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertSame(map, result);
        assertTrue(map.isEmpty());
    }

    @Test
    void testPutIn_WithEmptyHeaderMap() {
        when(mockParser.getHeaderMapRaw()).thenReturn(new HashMap<>());
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertSame(map, result);
        assertTrue(map.isEmpty());
    }

    @Test
    void testPutIn_WithValidHeaderMap() {
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("key1", 0);
        headerMap.put("key2", 1);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertEquals("value1", result.get("key1"));
        assertEquals("value2", result.get("key2"));
        assertEquals(2, result.size());
    }

    @Test
    void testPutIn_WithOutOfBoundIndex() {
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("key1", 0);
        // Out of bounds
        headerMap.put("key2", 3);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertEquals("value1", result.get("key1"));
        assertNull(result.get("key2"));
        assertEquals(1, result.size());
    }
}
