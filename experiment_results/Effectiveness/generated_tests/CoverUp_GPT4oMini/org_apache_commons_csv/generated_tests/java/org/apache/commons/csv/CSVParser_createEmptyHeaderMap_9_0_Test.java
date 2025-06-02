package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import java.io.StringReader;
import java.lang.reflect.Method;
import java.util.Map;
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

public class CSVParser_createEmptyHeaderMap_9_0_Test {

    private CSVParser csvParser;

    @BeforeEach
    public void setUp() throws Exception {
        CSVFormat format = mock(CSVFormat.class);
        // Test case for case-sensitive
        when(format.getIgnoreHeaderCase()).thenReturn(false);
        csvParser = new CSVParser(new StringReader(""), format);
        // Set up the format to test case-insensitive as well
        // Test case for case-insensitive
        when(format.getIgnoreHeaderCase()).thenReturn(true);
    }

    @Test
    public void testCreateEmptyHeaderMap_caseSensitive() throws Exception {
        // Use reflection to access the private method
        Method method = CSVParser.class.getDeclaredMethod("createEmptyHeaderMap");
        method.setAccessible(true);
        // Test case for case-sensitive map
        Map<String, Integer> headerMap = (Map<String, Integer>) method.invoke(csvParser);
        assertNotNull(headerMap);
        assertTrue(headerMap instanceof LinkedHashMap);
    }

    @Test
    public void testCreateEmptyHeaderMap_caseInsensitive() throws Exception {
        // Use reflection to access the private method
        Method method = CSVParser.class.getDeclaredMethod("createEmptyHeaderMap");
        method.setAccessible(true);
        // Test case for case-insensitive map
        Map<String, Integer> headerMap = (Map<String, Integer>) method.invoke(csvParser);
        assertNotNull(headerMap);
        assertTrue(headerMap instanceof TreeMap);
    }
}
