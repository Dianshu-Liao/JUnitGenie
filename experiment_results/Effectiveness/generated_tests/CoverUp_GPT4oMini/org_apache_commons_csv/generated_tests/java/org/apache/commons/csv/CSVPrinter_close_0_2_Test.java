package org.apache.commons.csv;

import java.io.IOException;
import java.io.StringWriter;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
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

class CSVPrinter_close_0_2_Test {

    private StringWriter stringWriter;

    private CSVFormat csvFormat;

    private CSVPrinter csvPrinter;

    @BeforeEach
    void setUp() throws IOException {
        stringWriter = new StringWriter();
        csvFormat = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(stringWriter, csvFormat);
    }

    @Test
    void testCloseWithoutFlush() throws Exception {
        // Close the CSVPrinter without flushing
        csvPrinter.close();
        // Verify that the StringWriter is still open and usable
        assertNotNull(stringWriter.toString());
    }

    @Test
    void testCloseWithFlush() throws Exception {
        // Close the CSVPrinter with flushing
        csvPrinter.close(true);
        // Verify that the StringWriter is still open and usable
        assertNotNull(stringWriter.toString());
    }

    @Test
    void testCloseWithAppendableAsCloseable() throws Exception {
        Appendable closeableAppendable = mock(Appendable.class);
        CSVPrinter printer = new CSVPrinter(closeableAppendable, csvFormat);
        // Close the printer
        printer.close();
        // Verify that the close method of the Appendable was called
        verify((Closeable) closeableAppendable).close();
    }

    @Test
    void testCloseWithIOException() throws Exception {
        Appendable faultyAppendable = mock(Appendable.class);
        doThrow(new IOException("Close failed")).when((Closeable) faultyAppendable).close();
        CSVPrinter printer = new CSVPrinter(faultyAppendable, csvFormat);
        // Verify that closing the printer throws an IOException
        assertThrows(IOException.class, printer::close);
    }
}
