package org.apache.commons.csv;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
// Added import for StringReader
import java.io.StringReader;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
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
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class CSVRecord_get_0_3_Test {

    private CSVParser parser;

    private CSVRecord csvRecord;

    @BeforeEach
    void setUp() throws IOException {
        // Mocking CSVParser
        parser = new CSVParser(new StringReader("header1,header2"), CSVFormat.DEFAULT);
        String[] values = { "value1", "value2" };
        csvRecord = new CSVRecord(parser, values, null, 1, 0, 0);
    }

    @Test
    void testGetWithValidEnum() throws Exception {
        // Mock Enum class
        Enum<?> testEnum = TestEnum.HEADER1;
        // Use reflection to call the private method
        Method method = CSVRecord.class.getDeclaredMethod("get", Enum.class);
        method.setAccessible(true);
        String result = (String) method.invoke(csvRecord, testEnum);
        assertEquals("value1", result);
    }

    @Test
    void testGetWithNullEnum() throws Exception {
        Enum<?> testEnum = null;
        // Use reflection to call the private method
        Method method = CSVRecord.class.getDeclaredMethod("get", Enum.class);
        method.setAccessible(true);
        String result = (String) method.invoke(csvRecord, testEnum);
        assertNull(result);
    }

    @Test
    void testGetWithInvalidEnum() throws Exception {
        // Mock Enum class
        Enum<?> testEnum = TestEnum.INVALID_HEADER;
        // Use reflection to call the private method
        Method method = CSVRecord.class.getDeclaredMethod("get", Enum.class);
        method.setAccessible(true);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            method.invoke(csvRecord, testEnum);
        });
        String expectedMessage = "Mapping for " + testEnum.name() + " not found, expected one of " + csvRecord.getParser().getHeaderMapRaw().keySet();
        assertEquals(expectedMessage, exception.getMessage());
    }

    private enum TestEnum {

        HEADER1, HEADER2, INVALID_HEADER
    }
}
