package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.StringWriter;
import java.io.IOException;
import java.sql.*;
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
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOStream;

public class CSVPrinter_printRecords_17_0_Test {

    @Mock
    private ResultSet resultSet;

    private CSVPrinter csvPrinter;

    private StringWriter stringWriter;

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() throws IOException {
        MockitoAnnotations.openMocks(this);
        stringWriter = new StringWriter();
        csvFormat = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(stringWriter, csvFormat);
    }

    @Test
    public void testPrintRecordsWithClob() throws SQLException, IOException {
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
        when(resultSet.getMetaData().getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn(mock(Clob.class));
        Clob clob = mock(Clob.class);
        when(clob.getCharacterStream()).thenReturn(new java.io.StringReader("Clob data"));
        when(resultSet.getObject(1)).thenReturn(clob);
        csvPrinter.printRecords(resultSet);
        assertEquals("Clob data\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithBlob() throws SQLException, IOException {
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
        when(resultSet.getMetaData().getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn(mock(Blob.class));
        Blob blob = mock(Blob.class);
        when(blob.getBinaryStream()).thenReturn(new java.io.ByteArrayInputStream("Blob data".getBytes()));
        when(resultSet.getObject(1)).thenReturn(blob);
        csvPrinter.printRecords(resultSet);
        assertEquals("Blob data\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithNormalObject() throws SQLException, IOException {
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
        when(resultSet.getMetaData().getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn("Normal data");
        csvPrinter.printRecords(resultSet);
        assertEquals("Normal data\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithMultipleColumns() throws SQLException, IOException {
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
        when(resultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn("Data1");
        when(resultSet.getObject(2)).thenReturn("Data2");
        csvPrinter.printRecords(resultSet);
        assertEquals("Data1Data2\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithNoRows() throws SQLException, IOException {
        when(resultSet.getMetaData()).thenReturn(mock(ResultSetMetaData.class));
        when(resultSet.getMetaData().getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(false);
        csvPrinter.printRecords(resultSet);
        assertEquals("", stringWriter.toString());
    }
}
