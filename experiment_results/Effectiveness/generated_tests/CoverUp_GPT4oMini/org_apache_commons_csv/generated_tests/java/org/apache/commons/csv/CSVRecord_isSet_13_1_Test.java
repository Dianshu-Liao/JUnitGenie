package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
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

public class CSVRecord_isSet_13_1_Test {

    private CSVParser mockParser;

    private CSVRecord csvRecord;

    @BeforeEach
    public void setUp() {
        mockParser = mock(CSVParser.class);
    }

    @Test
    public void testIsSetWhenNameIsMappedAndWithinBounds() throws Exception {
        String[] values = { "value1", "value2" };
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        String comment = "Test comment";
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("name1", 0);
        headerMap.put("name2", 1);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        csvRecord = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition, bytePosition);
        assertTrue(csvRecord.isSet("name1"));
        assertTrue(csvRecord.isSet("name2"));
    }

    @Test
    public void testIsSetWhenNameIsMappedButOutOfBounds() throws Exception {
        String[] values = { "value1", "value2" };
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        String comment = "Test comment";
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("name1", 0);
        // Out of bounds
        headerMap.put("name2", 2);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        csvRecord = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition, bytePosition);
        assertFalse(csvRecord.isSet("name2"));
    }

    @Test
    public void testIsSetWhenNameIsNotMapped() throws Exception {
        String[] values = { "value1", "value2" };
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        String comment = "Test comment";
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("name1", 0);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        csvRecord = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition, bytePosition);
        // Not mapped
        assertFalse(csvRecord.isSet("name2"));
    }

    @Test
    public void testIsSetWhenHeaderMapIsNull() throws Exception {
        String[] values = { "value1", "value2" };
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        String comment = "Test comment";
        when(mockParser.getHeaderMapRaw()).thenReturn(null);
        csvRecord = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition, bytePosition);
        // Header map is null
        assertFalse(csvRecord.isSet("name1"));
    }

    @Test
    public void testIsSetWithNullName() throws Exception {
        String[] values = { "value1", "value2" };
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        String comment = "Test comment";
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("name1", 0);
        when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        csvRecord = new CSVRecord(mockParser, values, comment, recordNumber, characterPosition, bytePosition);
        // Null name
        assertFalse(csvRecord.isSet(null));
    }
}
