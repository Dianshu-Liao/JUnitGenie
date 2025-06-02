package org.apache.commons.csv;

import org.junit.jupiter.api.extension.ExtendWith;
import java.io.StringReader;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVRecord_CSVRecord_22_0_Test {

    @Test
    void testCSVRecordConstructorWithValidParameters() {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT;
        StringReader reader = new StringReader("value1,value2");
        CSVParser parser = null;
        try {
            parser = new CSVParser(reader, format);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
        String[] values = { "value1", "value2" };
        String comment = "This is a comment";
        long recordNumber = 1L;
        long characterPosition = 10L;
        long bytePosition = 20L;
        // Act
        CSVRecord record = new CSVRecord(parser, values, comment, recordNumber, characterPosition, bytePosition);
        // Assert
        assertNotNull(record);
        // Use reflection to access private fields and assert their values
        assertEquals(recordNumber, getFieldValue(record, "recordNumber"));
        assertArrayEquals(values, (String[]) getFieldValue(record, "values"));
        assertEquals(comment, getFieldValue(record, "comment"));
        assertEquals(characterPosition, getFieldValue(record, "characterPosition"));
        assertEquals(bytePosition, getFieldValue(record, "bytePosition"));
        assertEquals(parser, getFieldValue(record, "parser"));
    }

    @Test
    void testCSVRecordConstructorWithNullValues() {
        // Arrange
        CSVFormat format = CSVFormat.DEFAULT;
        StringReader reader = new StringReader("value1,value2");
        CSVParser parser = null;
        try {
            parser = new CSVParser(reader, format);
        } catch (IOException e) {
            fail("IOException should not be thrown");
        }
        // Test with null values
        String[] values = null;
        String comment = "This is a comment";
        long recordNumber = 1L;
        long characterPosition = 10L;
        long bytePosition = 20L;
        // Act
        CSVRecord record = new CSVRecord(parser, values, comment, recordNumber, characterPosition, bytePosition);
        // Assert
        assertNotNull(record);
        // Use reflection to access private fields and assert their values
        assertEquals(recordNumber, getFieldValue(record, "recordNumber"));
        assertArrayEquals(Constants.EMPTY_STRING_ARRAY, (String[]) getFieldValue(record, "values"));
        assertEquals(comment, getFieldValue(record, "comment"));
        assertEquals(characterPosition, getFieldValue(record, "characterPosition"));
        assertEquals(bytePosition, getFieldValue(record, "bytePosition"));
        assertEquals(parser, getFieldValue(record, "parser"));
    }

    private Object getFieldValue(Object obj, String fieldName) {
        try {
            java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
