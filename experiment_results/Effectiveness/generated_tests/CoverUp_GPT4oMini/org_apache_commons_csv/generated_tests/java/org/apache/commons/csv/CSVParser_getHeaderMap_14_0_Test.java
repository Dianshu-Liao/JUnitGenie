package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.csv.Token;
import java.io.StringReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.csv.Token.Type.TOKEN;
import java.io.Closeable;
import java.io.File;
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

public class CSVParser_getHeaderMap_14_0_Test {

    private CSVParser csvParser;

    @BeforeEach
    public void setUp() throws IOException {
        String csvData = "header1,header2\nvalue1,value2";
        CSVFormat format = CSVFormat.DEFAULT;
        csvParser = new CSVParser(new StringReader(csvData), format);
    }

    @Test
    public void testGetHeaderMap_NonNullHeaders() throws Exception {
        // Setup headers
        Map<String, Integer> headerMap = new HashMap<>();
        headerMap.put("header1", 0);
        headerMap.put("header2", 1);
        setPrivateField(csvParser, "headers", new Headers(headerMap));
        Map<String, Integer> result = invokeGetHeaderMap(csvParser);
        assertEquals(headerMap, result);
    }

    @Test
    public void testGetHeaderMap_NullHeaders() throws Exception {
        // Setup headers to null
        setPrivateField(csvParser, "headers", new Headers(null));
        Map<String, Integer> result = invokeGetHeaderMap(csvParser);
        assertNull(result);
    }

    private void setPrivateField(Object object, String fieldName, Object value) throws Exception {
        Field field = object.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(object, value);
    }

    private Map<String, Integer> invokeGetHeaderMap(CSVParser parser) throws Exception {
        Method method = CSVParser.class.getDeclaredMethod("getHeaderMap");
        method.setAccessible(true);
        return (Map<String, Integer>) method.invoke(parser);
    }

    private static class Headers {

        private final Map<String, Integer> headerMap;

        public Headers(Map<String, Integer> headerMap) {
            this.headerMap = headerMap;
        }
    }
}
