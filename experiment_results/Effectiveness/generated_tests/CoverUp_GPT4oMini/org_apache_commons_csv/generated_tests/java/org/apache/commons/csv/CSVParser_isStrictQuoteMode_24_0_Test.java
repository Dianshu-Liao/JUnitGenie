package org.apache.commons.csv;

import java.io.StringReader;
import java.io.IOException;
import java.lang.reflect.Method;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
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

public class CSVParser_isStrictQuoteMode_24_0_Test {

    private CSVParser csvParser;

    @BeforeEach
    public void setUp() throws IOException {
        // Set up a CSVFormat with different quote modes for testing
    }

    @Test
    public void testIsStrictQuoteModeWithAllNonNull() throws Exception {
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuoteMode(QuoteMode.ALL_NON_NULL).build();
        csvParser = new CSVParser(new StringReader("test"), format);
        assertTrue(invokeIsStrictQuoteMode());
    }

    @Test
    public void testIsStrictQuoteModeWithNonNumeric() throws Exception {
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuoteMode(QuoteMode.NON_NUMERIC).build();
        csvParser = new CSVParser(new StringReader("test"), format);
        assertTrue(invokeIsStrictQuoteMode());
    }

    @Test
    public void testIsStrictQuoteModeWithMinimal() throws Exception {
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuoteMode(QuoteMode.MINIMAL).build();
        csvParser = new CSVParser(new StringReader("test"), format);
        assertFalse(invokeIsStrictQuoteMode());
    }

    @Test
    public void testIsStrictQuoteModeWithNone() throws Exception {
        CSVFormat format = CSVFormat.DEFAULT.builder().setQuoteMode(QuoteMode.NONE).build();
        csvParser = new CSVParser(new StringReader("test"), format);
        assertFalse(invokeIsStrictQuoteMode());
    }

    private boolean invokeIsStrictQuoteMode() throws Exception {
        Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
        method.setAccessible(true);
        return (Boolean) method.invoke(csvParser);
    }
}
