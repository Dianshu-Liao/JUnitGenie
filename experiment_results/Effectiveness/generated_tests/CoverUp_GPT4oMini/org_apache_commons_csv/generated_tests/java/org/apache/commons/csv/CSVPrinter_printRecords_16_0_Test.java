package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.IOException;
import java.io.StringWriter;
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
import java.util.stream.Stream;
import org.apache.commons.io.function.IOStream;

class CSVPrinter_printRecords_16_0_Test {

    private StringWriter stringWriter;

    private CSVPrinter csvPrinter;

    @BeforeEach
    void setUp() throws IOException {
        stringWriter = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(stringWriter, csvFormat);
    }

    @Test
    void testPrintRecordsWithNonNullValues() throws IOException {
        // Given
        Object[] values = { "value1", "value2", "value3" };
        // When
        csvPrinter.printRecords(values);
        // Then
        assertEquals("value1,value2,value3\n", stringWriter.toString());
    }

    @Test
    void testPrintRecordsWithEmptyValues() throws IOException {
        // Given
        Object[] values = {};
        // When
        csvPrinter.printRecords(values);
        // Then
        assertEquals("", stringWriter.toString());
    }

    @Test
    void testPrintRecordsWithNullValues() throws IOException {
        // Given
        Object[] values = { null, "value2", null };
        // When
        csvPrinter.printRecords(values);
        // Then
        assertEquals(",value2,\n", stringWriter.toString());
    }

    @Test
    void testPrintRecordsWithMixedValues() throws IOException {
        // Given
        Object[] values = { "value1", null, "value3" };
        // When
        csvPrinter.printRecords(values);
        // Then
        assertEquals("value1,,value3\n", stringWriter.toString());
    }

    @Test
    void testPrintRecordsMultipleCalls() throws IOException {
        // Given
        Object[] values1 = { "value1", "value2" };
        Object[] values2 = { "value3", "value4" };
        // When
        csvPrinter.printRecords(values1);
        csvPrinter.printRecords(values2);
        // Then
        assertEquals("value1,value2\nvalue3,value4\n", stringWriter.toString());
    }
}
