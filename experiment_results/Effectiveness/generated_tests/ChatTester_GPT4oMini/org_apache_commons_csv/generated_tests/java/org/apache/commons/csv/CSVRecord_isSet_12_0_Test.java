// Test method
package org.apache.commons.csv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CSVRecord_isSet_12_0_Test {

    private CSVRecord csvRecord;

    private static final String[] TEST_VALUES = { "value1", "value2", "value3" };

    @BeforeEach
    public void setUp() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to create an instance of CSVRecord
        Constructor<CSVRecord> constructor = CSVRecord.class.getDeclaredConstructor(CSVParser.class, String[].class, String.class, long.class, long.class, long.class);
        constructor.setAccessible(true);
        // Create a mock CSVParser instance
        CSVParser csvParser = mock(CSVParser.class);
        csvRecord = constructor.newInstance(csvParser, TEST_VALUES, "comment", 1L, 0L, 0L);
    }

    @Test
    public void testIsSet_ValidIndex() {
        assertTrue(csvRecord.isSet(0), "Index 0 should be set.");
        assertTrue(csvRecord.isSet(1), "Index 1 should be set.");
        assertTrue(csvRecord.isSet(2), "Index 2 should be set.");
    }

    @Test
    public void testIsSet_InvalidIndex_Negative() {
        assertFalse(csvRecord.isSet(-1), "Index -1 should not be set.");
    }

    @Test
    public void testIsSet_InvalidIndex_TooHigh() {
        assertFalse(csvRecord.isSet(3), "Index 3 should not be set.");
    }

    @Test
    public void testIsSet_EmptyValues() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Create a CSVRecord instance with empty values
        String[] emptyValues = {};
        Constructor<CSVRecord> constructor = CSVRecord.class.getDeclaredConstructor(CSVParser.class, String[].class, String.class, long.class, long.class, long.class);
        constructor.setAccessible(true);
        CSVParser csvParser = mock(CSVParser.class);
        CSVRecord emptyCsvRecord = constructor.newInstance(csvParser, emptyValues, "comment", 1L, 0L, 0L);
        assertFalse(emptyCsvRecord.isSet(0), "Index 0 should not be set in an empty CSVRecord.");
    }
}
