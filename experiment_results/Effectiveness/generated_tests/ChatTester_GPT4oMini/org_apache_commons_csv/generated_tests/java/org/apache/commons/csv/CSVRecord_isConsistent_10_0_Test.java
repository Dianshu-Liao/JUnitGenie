package org.apache.commons.csv;

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

class CSVRecord_isConsistent_10_0_Test {

    private CSVParser mockParser;

    private CSVRecord csvRecord;

    @BeforeEach
    void setUp() {
        mockParser = Mockito.mock(CSVParser.class);
    }

    @Test
    void testIsConsistent_HeaderMapNull() throws Exception {
        // Arrange
        String[] values = { "value1", "value2" };
        csvRecord = new CSVRecord(mockParser, values, null, 1, 0, 0);
        // Mock the behavior of the parser to return null for header map
        Mockito.when(mockParser.getHeaderMapRaw()).thenReturn(null);
        // Act
        boolean result = invokeIsConsistent();
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsConsistent_HeaderMapSizeMatchesValues() throws Exception {
        // Arrange
        String[] values = { "value1", "value2" };
        csvRecord = new CSVRecord(mockParser, values, null, 1, 0, 0);
        // Mock the behavior of the parser to return a header map with the same size as values
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        headerMap.put("header2", 1);
        Mockito.when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        // Act
        boolean result = invokeIsConsistent();
        // Assert
        assertTrue(result);
    }

    @Test
    void testIsConsistent_HeaderMapSizeDoesNotMatchValues() throws Exception {
        // Arrange
        String[] values = { "value1", "value2" };
        csvRecord = new CSVRecord(mockParser, values, null, 1, 0, 0);
        // Mock the behavior of the parser to return a header map with a different size
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        Mockito.when(mockParser.getHeaderMapRaw()).thenReturn(headerMap);
        // Act
        boolean result = invokeIsConsistent();
        // Assert
        assertFalse(result);
    }

    private boolean invokeIsConsistent() throws Exception {
        Method method = CSVRecord.class.getDeclaredMethod("isConsistent");
        method.setAccessible(true);
        return (boolean) method.invoke(csvRecord);
    }
}
