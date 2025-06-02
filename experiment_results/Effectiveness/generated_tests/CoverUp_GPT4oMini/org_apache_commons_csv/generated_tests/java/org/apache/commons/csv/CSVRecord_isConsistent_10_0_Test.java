package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
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

class CSVRecord_isConsistent_10_0_Test {

    private CSVParser mockParser;

    private CSVRecord csvRecordWithHeader;

    private CSVRecord csvRecordWithoutHeader;

    @BeforeEach
    void setUp() {
        // Mocking a CSVParser with a header map
        mockParser = Mockito.mock(CSVParser.class);
        when(mockParser.getHeaderMapRaw()).thenReturn(createHeaderMap());
        // Creating CSVRecord instances
        csvRecordWithHeader = new CSVRecord(mockParser, new String[] { "value1", "value2" }, null, 1, 0, 0);
        csvRecordWithoutHeader = new CSVRecord(null, new String[] { "value1" }, null, 2, 0, 0);
    }

    private Map<String, Integer> createHeaderMap() {
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("Column1", 0);
        headerMap.put("Column2", 1);
        return headerMap;
    }

    @Test
    void testIsConsistentWithHeader() {
        assertTrue(csvRecordWithHeader.isConsistent(), "Expected isConsistent() to return true when header matches values.");
    }

    @Test
    void testIsConsistentWithoutHeader() {
        assertTrue(csvRecordWithoutHeader.isConsistent(), "Expected isConsistent() to return true when there is no header.");
    }

    @Test
    void testIsConsistentWithDifferentHeaderSize() {
        CSVRecord csvRecordWithDifferentHeader = new CSVRecord(mockParser, new String[] { "value1" }, null, 3, 0, 0);
        assertFalse(csvRecordWithDifferentHeader.isConsistent(), "Expected isConsistent() to return false when header size does not match values size.");
    }

    @Test
    void testIsConsistentWithNullParser() {
        CSVRecord csvRecordNullParser = new CSVRecord(null, new String[] { "value1", "value2" }, null, 4, 0, 0);
        assertTrue(csvRecordNullParser.isConsistent(), "Expected isConsistent() to return true when parser is null.");
    }

    @Test
    void testPrivateMethodGetHeaderMapRaw() throws Exception {
        Method method = CSVRecord.class.getDeclaredMethod("getHeaderMapRaw");
        method.setAccessible(true);
        Map<String, Integer> result = (Map<String, Integer>) method.invoke(csvRecordWithHeader);
        assertNotNull(result, "Expected getHeaderMapRaw() to return a non-null map.");
        assertEquals(2, result.size(), "Expected header map size to be 2.");
    }
}
