package org.apache.commons.csv;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Reader;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.ResultSetMetaData;
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
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOStream;

public class CSVPrinter_printRecords_17_0_Test {

    @Mock
    private ResultSet resultSet;

    @Mock
    private ResultSetMetaData metaData;

    private CSVPrinter csvPrinter;

    private StringWriter stringWriter;

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() throws IOException, SQLException {
        MockitoAnnotations.openMocks(this);
        stringWriter = new StringWriter();
        csvFormat = mock(CSVFormat.class);
        csvPrinter = new CSVPrinter(stringWriter, csvFormat);
        when(resultSet.getMetaData()).thenReturn(metaData);
    }

    @Test
    public void testPrintRecordsWithClob() throws SQLException, IOException {
        when(metaData.getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getRow()).thenReturn(1);
        when(csvFormat.useRow(1)).thenReturn(true);
        Clob clob = mock(Clob.class);
        Reader reader = mock(Reader.class);
        when(resultSet.getObject(1)).thenReturn(clob);
        when(clob.getCharacterStream()).thenReturn(reader);
        csvPrinter.printRecords(resultSet);
        // Verify interactions
        verify(resultSet).getMetaData();
        verify(resultSet).next();
        verify(resultSet).getObject(1);
        verify(clob).getCharacterStream();
        // Add more assertions based on the expected output
    }

    @Test
    public void testPrintRecordsWithBlob() throws SQLException, IOException {
        when(metaData.getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getRow()).thenReturn(1);
        when(csvFormat.useRow(1)).thenReturn(true);
        Blob blob = mock(Blob.class);
        InputStream inputStream = mock(InputStream.class);
        when(resultSet.getObject(1)).thenReturn(blob);
        when(blob.getBinaryStream()).thenReturn(inputStream);
        csvPrinter.printRecords(resultSet);
        // Verify interactions
        verify(resultSet).getMetaData();
        verify(resultSet).next();
        verify(resultSet).getObject(1);
        verify(blob).getBinaryStream();
        // Add more assertions based on the expected output
    }

    @Test
    public void testPrintRecordsWithRegularObject() throws SQLException, IOException {
        when(metaData.getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(true).thenReturn(false);
        when(resultSet.getRow()).thenReturn(1);
        when(csvFormat.useRow(1)).thenReturn(true);
        Object regularObject = "test";
        when(resultSet.getObject(1)).thenReturn(regularObject);
        csvPrinter.printRecords(resultSet);
        // Verify interactions
        verify(resultSet).getMetaData();
        verify(resultSet).next();
        verify(resultSet).getObject(1);
        // Add more assertions based on the expected output
    }

    @Test
    public void testPrintRecordsNoRows() throws SQLException, IOException {
        when(metaData.getColumnCount()).thenReturn(1);
        when(resultSet.next()).thenReturn(false);
        csvPrinter.printRecords(resultSet);
        // Verify interactions
        verify(resultSet).getMetaData();
        verify(resultSet).next();
    }

    @Test
    public void testPrintRecordsWithMultipleRows() throws SQLException, IOException {
        when(metaData.getColumnCount()).thenReturn(2);
        when(resultSet.next()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(resultSet.getRow()).thenReturn(1).thenReturn(2);
        when(csvFormat.useRow(1)).thenReturn(true);
        when(csvFormat.useRow(2)).thenReturn(true);
        when(resultSet.getObject(1)).thenReturn("row1_col1");
        when(resultSet.getObject(2)).thenReturn("row1_col2");
        csvPrinter.printRecords(resultSet);
        // Verify interactions
        verify(resultSet, times(2)).getMetaData();
        verify(resultSet, times(2)).next();
        // Add more assertions based on the expected output
    }
}
