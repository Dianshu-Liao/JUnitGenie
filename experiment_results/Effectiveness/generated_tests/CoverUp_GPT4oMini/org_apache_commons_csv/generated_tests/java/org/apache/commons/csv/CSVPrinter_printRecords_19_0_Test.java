package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.StringWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Stream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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
import org.apache.commons.io.function.IOStream;

public class CSVPrinter_printRecords_19_0_Test {

    private StringWriter stringWriter;

    private CSVPrinter csvPrinter;

    @BeforeEach
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(stringWriter, format);
    }

    @Test
    public void testPrintRecordsSingleValue() throws IOException {
        Stream<String> values = Stream.of("value1");
        csvPrinter.printRecords(values);
        assertEquals("value1\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsMultipleValues() throws IOException {
        Stream<String> values = Stream.of("value1", "value2", "value3");
        csvPrinter.printRecords(values);
        assertEquals("value1,value2,value3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsEmptyStream() throws IOException {
        Stream<String> values = Stream.empty();
        csvPrinter.printRecords(values);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsNullValues() throws IOException {
        Stream<String> values = Stream.of("value1", null, "value3");
        csvPrinter.printRecords(values);
        assertEquals("value1,,value3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithNewLines() throws IOException {
        Stream<String> values = Stream.of("value1\nvalue2", "value3");
        csvPrinter.printRecords(values);
        assertEquals("value1\nvalue2,value3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithSpecialCharacters() throws IOException {
        Stream<String> values = Stream.of("value1", "value2,with,comma", "value3");
        csvPrinter.printRecords(values);
        assertEquals("value1,value2,with,comma,value3\n", stringWriter.toString());
    }
}
