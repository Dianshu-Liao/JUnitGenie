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

class CSVPrinter_CSVPrinter_20_0_Test {

    private StringWriter stringWriter;

    private CSVFormat csvFormat;

    @BeforeEach
    void setUp() {
        stringWriter = new StringWriter();
        csvFormat = CSVFormat.DEFAULT.builder().setHeader("Header1", "Header2").setHeaderComments(new String[] { "Comment1", "Comment2" }).setSkipHeaderRecord(false).get();
    }

    @Test
    void testCSVPrinterConstructorWithNullAppendable() {
        assertThrows(NullPointerException.class, () -> new CSVPrinter(null, csvFormat));
    }

    @Test
    void testCSVPrinterConstructorWithNullFormat() {
        assertThrows(NullPointerException.class, () -> new CSVPrinter(stringWriter, null));
    }

    @Test
    void testCSVPrinterConstructorPrintsHeaderComments() throws IOException {
        CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat);
        assertEquals("# Comment1\n# Comment2\n", stringWriter.toString());
    }

    @Test
    void testCSVPrinterConstructorPrintsHeader() throws IOException {
        CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat);
        assertTrue(stringWriter.toString().contains("Header1,Header2"));
    }

    @Test
    void testCSVPrinterConstructorWithSkipHeaderRecord() throws IOException {
        csvFormat = CSVFormat.DEFAULT.builder().setHeader("Header1", "Header2").setSkipHeaderRecord(true).get();
        CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat);
        assertFalse(stringWriter.toString().contains("Header1,Header2"));
    }

    @Test
    void testGetOut() throws IOException {
        CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat);
        assertEquals(stringWriter, printer.getOut());
    }

    @Test
    void testGetRecordCount() throws IOException {
        CSVPrinter printer = new CSVPrinter(stringWriter, csvFormat);
        assertEquals(0, printer.getRecordCount());
    }
}
