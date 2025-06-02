package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.StringReader;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import java.util.HashMap;
import java.util.Map;
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

class CSVRecord_isMapped_11_0_Test {

    private CSVParser parser;

    private CSVRecord csvRecord;

    @BeforeEach
    void setUp() throws Exception {
        // Mocking the CSVParser and its behavior
        parser = mock(CSVParser.class);
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        headerMap.put("header2", 1);
        headerMap.put("header3", 2);
        when(parser.getHeaderMapRaw()).thenReturn(headerMap);
        csvRecord = new CSVRecord(parser, new String[] { "value1", "value2", "value3" }, null, 1, 0, 0);
    }

    @Test
    void testIsMapped_WithExistingHeader() {
        assertTrue(csvRecord.isMapped("header1"));
        assertTrue(csvRecord.isMapped("header2"));
        assertTrue(csvRecord.isMapped("header3"));
    }

    @Test
    void testIsMapped_WithNonExistingHeader() {
        assertFalse(csvRecord.isMapped("header4"));
    }

    @Test
    void testIsMapped_WithNullHeader() {
        assertFalse(csvRecord.isMapped(null));
    }

    @Test
    void testIsMapped_WithEmptyHeader() {
        assertFalse(csvRecord.isMapped(""));
    }

    @Test
    void testIsMapped_WithNullParser() throws Exception {
        // Set the parser to null using reflection
        setField(csvRecord, "parser", null);
        assertFalse(csvRecord.isMapped("header1"));
    }

    private void setField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
