package org.apache.commons.csv;

import java.io.StringReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.io.IOException;
import org.apache.commons.csv.CSVFormat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class CSVParser_handleNull_20_0_Test {

    private CSVParser csvParser;

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() throws IOException {
        csvFormat = mock(CSVFormat.class);
        csvParser = new CSVParser(new StringReader(""), csvFormat);
    }

    private Token getReusableToken() throws Exception {
        Field reusableTokenField = CSVParser.class.getDeclaredField("reusableToken");
        reusableTokenField.setAccessible(true);
        return (Token) reusableTokenField.get(csvParser);
    }

    private boolean isStrictQuoteMode() throws Exception {
        Method isStrictQuoteModeMethod = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
        isStrictQuoteModeMethod.setAccessible(true);
        return (boolean) isStrictQuoteModeMethod.invoke(csvParser);
    }

    @Test
    public void testHandleNullWithNullString() throws Exception {
        when(csvFormat.getNullString()).thenReturn("NULL");
        Method handleNullMethod = CSVParser.class.getDeclaredMethod("handleNull", String.class);
        handleNullMethod.setAccessible(true);
        // Test case where input is equal to nullString
        String result = (String) handleNullMethod.invoke(csvParser, "NULL");
        assertNull(result);
    }

    @Test
    public void testHandleNullWithQuotedInput() throws Exception {
        when(csvFormat.getNullString()).thenReturn("NULL");
        Token reusableToken = getReusableToken();
        // Set the isQuoted field
        reusableToken.isQuoted = true;
        Method handleNullMethod = CSVParser.class.getDeclaredMethod("handleNull", String.class);
        handleNullMethod.setAccessible(true);
        // Test case where input is quoted and equal to nullString
        String result = (String) handleNullMethod.invoke(csvParser, "NULL");
        assertEquals("NULL", result);
    }

    @Test
    public void testHandleNullWithEmptyInput() throws Exception {
        when(csvFormat.getNullString()).thenReturn(null);
        Token reusableToken = getReusableToken();
        // Set the isQuoted field
        reusableToken.isQuoted = false;
        Method handleNullMethod = CSVParser.class.getDeclaredMethod("handleNull", String.class);
        handleNullMethod.setAccessible(true);
        // Test case where input is empty
        String result = (String) handleNullMethod.invoke(csvParser, "");
        assertNull(result);
    }

    @Test
    public void testHandleNullWithNonNullInput() throws Exception {
        when(csvFormat.getNullString()).thenReturn("NULL");
        Token reusableToken = getReusableToken();
        // Set the isQuoted field
        reusableToken.isQuoted = false;
        Method handleNullMethod = CSVParser.class.getDeclaredMethod("handleNull", String.class);
        handleNullMethod.setAccessible(true);
        // Test case where input is a non-null string
        String result = (String) handleNullMethod.invoke(csvParser, "Some Value");
        assertEquals("Some Value", result);
    }

    @Test
    public void testHandleNullWithStrictQuoteMode() throws Exception {
        when(csvFormat.getNullString()).thenReturn(null);
        Token reusableToken = getReusableToken();
        // Set the isQuoted field
        reusableToken.isQuoted = false;
        Method handleNullMethod = CSVParser.class.getDeclaredMethod("handleNull", String.class);
        handleNullMethod.setAccessible(true);
        // Test case where input is empty in strict quote mode
        when(isStrictQuoteMode()).thenReturn(true);
        String result = (String) handleNullMethod.invoke(csvParser, "");
        assertNull(result);
    }
}
