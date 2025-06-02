package org.apache.commons.csv;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.StringReader;
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

class CSVRecord_putIn_15_0_Test {

    private CSVRecord csvRecord;

    private CSVParser parser;

    @BeforeEach
    void setUp() throws Exception {
        // Create a CSVParser with a dummy Reader and CSVFormat
        parser = new CSVParser(new StringReader("value1,value2,value3"), CSVFormat.DEFAULT);
        String[] values = { "value1", "value2", "value3" };
        String comment = "This is a comment";
        long recordNumber = 1;
        long characterPosition = 0;
        long bytePosition = 0;
        csvRecord = new CSVRecord(parser, values, comment, recordNumber, characterPosition, bytePosition);
    }

    @Test
    void testPutIn_withNullHeaderMapRaw() throws Exception {
        // Mocking the parser to return null for header map
        setHeaderMapRaw(null);
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertSame(map, result);
    }

    @Test
    void testPutIn_withValidHeaderMapRaw() throws Exception {
        // Use reflection to set up the header map raw
        setHeaderMapRaw(new HashMap<String, Integer>() {

            {
                put("key1", 0);
                put("key2", 1);
                // This index is out of bounds for values
                put("key3", 3);
            }
        });
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertEquals(2, result.size());
        assertEquals("value1", result.get("key1"));
        assertEquals("value2", result.get("key2"));
        // key3 should not be added
        assertNull(result.get("key3"));
    }

    @Test
    void testPutIn_withEmptyMap() throws Exception {
        setHeaderMapRaw(new HashMap<String, Integer>() {

            {
                put("key1", 0);
            }
        });
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertEquals(1, result.size());
        assertEquals("value1", result.get("key1"));
    }

    @Test
    void testPutIn_withOutOfBoundsIndex() throws Exception {
        setHeaderMapRaw(new HashMap<String, Integer>() {

            {
                // This index is out of bounds for values
                put("key1", 3);
            }
        });
        Map<String, String> map = new HashMap<>();
        Map<String, String> result = csvRecord.putIn(map);
        assertTrue(result.isEmpty(), "Map should be empty as all indices are out of bounds");
    }

    private void setHeaderMapRaw(Map<String, Integer> headerMap) throws Exception {
        // Use reflection to access the private method
        Method method = CSVRecord.class.getDeclaredMethod("setHeaderMapRaw", Map.class);
        method.setAccessible(true);
        method.invoke(csvRecord, headerMap);
    }
}
