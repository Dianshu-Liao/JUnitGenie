package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;
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

public class CSVRecord_getHeaderMapRaw_6_0_Test {

    private CSVParser mockParser;

    private CSVRecord csvRecord;

    @BeforeEach
    public void setUp() throws IOException {
        // Set up a mock parser
        mockParser = new CSVParser(new StringReader("header1,header2\nvalue1,value2"), CSVFormat.DEFAULT);
        // Initialize CSVRecord with the mock parser
        csvRecord = new CSVRecord(mockParser, new String[] { "value1", "value2" }, "Comment", 1, 0, 0);
    }

    @Test
    public void testGetHeaderMapRaw_WhenParserIsNotNull() throws Exception {
        // Prepare expected header map
        Map<String, Integer> expectedHeaderMap = new HashMap<>();
        expectedHeaderMap.put("header1", 0);
        expectedHeaderMap.put("header2", 1);
        // Invoke the private method using reflection
        Method method = CSVRecord.class.getDeclaredMethod("getHeaderMapRaw");
        method.setAccessible(true);
        Map<String, Integer> actualHeaderMap = (Map<String, Integer>) method.invoke(csvRecord);
        // Assert the expected header map matches the actual header map
        assertEquals(expectedHeaderMap, actualHeaderMap);
    }

    @Test
    public void testGetHeaderMapRaw_WhenParserIsNull() throws Exception {
        // Create a CSVRecord with a null parser
        CSVRecord csvRecordWithNullParser = new CSVRecord(null, new String[] { "value1", "value2" }, "Comment", 1, 0, 0);
        // Invoke the private method using reflection
        Method method = CSVRecord.class.getDeclaredMethod("getHeaderMapRaw");
        method.setAccessible(true);
        Map<String, Integer> actualHeaderMap = (Map<String, Integer>) method.invoke(csvRecordWithNullParser);
        // Assert that the actual header map is null
        assertNull(actualHeaderMap);
    }
}
