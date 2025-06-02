package org.apache.commons.csv;

import java.io.IOException;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.csv.Constants.CR;
import static org.apache.commons.csv.Constants.LF;
import static org.apache.commons.csv.Constants.SP;
import java.io.Closeable;
import java.io.Flushable;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CSVPrinter_printRecords_15_0_Test {

    private CSVPrinter csvPrinter;

    private StringWriter stringWriter;

    @BeforeEach
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        // Assuming a default format for testing
        CSVFormat format = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(stringWriter, format);
    }

    @Test
    public void testPrintRecords_WithEmptyIterable() throws IOException {
        csvPrinter.printRecords(new Iterable<Object>() {

            @Override
            public java.util.Iterator<Object> iterator() {
                return java.util.Collections.emptyIterator();
            }
        });
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintRecords_WithSingleRecord() throws IOException {
        csvPrinter.printRecords(java.util.Collections.singletonList("Test"));
        // Assuming the format adds a newline
        assertEquals("Test\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecords_WithMultipleRecords() throws IOException {
        csvPrinter.printRecords(java.util.Arrays.asList("Test1", "Test2", "Test3"));
        assertEquals("Test1\nTest2\nTest3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecords_WithIOException() {
        Appendable faultyAppendable = Mockito.mock(Appendable.class);
        // Fixed Buggy Line: Catching the IOException in a try-catch block
        try {
            doThrow(new IOException("Mocked IOException")).when(faultyAppendable).append(Mockito.any(CharSequence.class));
            CSVPrinter faultyCSVPrinter = new CSVPrinter(faultyAppendable, CSVFormat.DEFAULT);
            IOException thrown = assertThrows(IOException.class, () -> {
                faultyCSVPrinter.printRecords(java.util.Collections.singletonList("Test"));
            });
            assertEquals("Mocked IOException", thrown.getMessage());
        } catch (IOException e) {
            fail("Unexpected IOException: " + e.getMessage());
        }
    }
}
