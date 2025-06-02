package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.csv.Token.Type.TOKEN;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.apache.commons.io.build.AbstractStreamBuilder;
import org.apache.commons.io.function.Uncheck;

public class CSVParser_addRecordValue_7_0_Test {

    private CSVParser csvParser;

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() throws Exception {
        csvFormat = CSVFormat.DEFAULT;
        StringReader reader = new StringReader("header1,header2\nvalue1,value2");
        csvParser = new CSVParser(reader, csvFormat);
    }

    @Test
    public void testAddRecordValueWithTrailingDelimiter() throws Exception {
        // Set up the reusableToken to simulate the state before calling addRecordValue
        Method setReusableTokenMethod = CSVParser.class.getDeclaredMethod("setReusableToken", String.class, boolean.class);
        setReusableTokenMethod.setAccessible(true);
        setReusableTokenMethod.invoke(csvParser, "value1", false);
        // Call the private method addRecordValue with lastRecord as true
        Method addRecordValueMethod = CSVParser.class.getDeclaredMethod("addRecordValue", boolean.class);
        addRecordValueMethod.setAccessible(true);
        addRecordValueMethod.invoke(csvParser, true);
        // Verify that the recordList contains the value
        assertEquals(1, csvParser.getRecords().size());
        assertEquals("value1", csvParser.getRecords().get(0).get(0));
    }

    @Test
    public void testAddRecordValueWithEmptyInputAndTrailingDelimiter() throws Exception {
        // Set up the reusableToken to simulate empty input
        Method setReusableTokenMethod = CSVParser.class.getDeclaredMethod("setReusableToken", String.class, boolean.class);
        setReusableTokenMethod.setAccessible(true);
        setReusableTokenMethod.invoke(csvParser, "", false);
        // Call the private method addRecordValue with lastRecord as true
        Method addRecordValueMethod = CSVParser.class.getDeclaredMethod("addRecordValue", boolean.class);
        addRecordValueMethod.setAccessible(true);
        addRecordValueMethod.invoke(csvParser, true);
        // Verify that the recordList is still empty
        assertTrue(csvParser.getRecords().isEmpty());
    }

    @Test
    public void testAddRecordValueWithNonEmptyInput() throws Exception {
        // Set up the reusableToken to simulate non-empty input
        Method setReusableTokenMethod = CSVParser.class.getDeclaredMethod("setReusableToken", String.class, boolean.class);
        setReusableTokenMethod.setAccessible(true);
        setReusableTokenMethod.invoke(csvParser, "value2", false);
        // Call the private method addRecordValue with lastRecord as false
        Method addRecordValueMethod = CSVParser.class.getDeclaredMethod("addRecordValue", boolean.class);
        addRecordValueMethod.setAccessible(true);
        addRecordValueMethod.invoke(csvParser, false);
        // Verify that the recordList contains the value
        assertEquals(1, csvParser.getRecords().size());
        assertEquals("value2", csvParser.getRecords().get(0).get(1));
    }

    @Test
    public void testAddRecordValueWithNullHandling() throws Exception {
        // Set up the reusableToken to simulate a null string
        Method setReusableTokenMethod = CSVParser.class.getDeclaredMethod("setReusableToken", String.class, boolean.class);
        setReusableTokenMethod.setAccessible(true);
        setReusableTokenMethod.invoke(csvParser, csvFormat.getNullString(), false);
        // Call the private method addRecordValue with lastRecord as false
        Method addRecordValueMethod = CSVParser.class.getDeclaredMethod("addRecordValue", boolean.class);
        addRecordValueMethod.setAccessible(true);
        addRecordValueMethod.invoke(csvParser, false);
        // Verify that the recordList contains null
        assertEquals(1, csvParser.getRecords().size());
        assertEquals(null, csvParser.getRecords().get(0).get(0));
    }
}
