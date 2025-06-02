package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.StringWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;
import org.apache.commons.io.function.IOStream;

public class CSVPrinter_printRecords_18_0_Test {

    private CSVPrinter csvPrinter;

    @Mock
    private ResultSet resultSet;

    private StringWriter output;

    private CSVFormat format;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        output = new StringWriter();
        format = CSVFormat.DEFAULT;
        csvPrinter = new CSVPrinter(output, format);
    }

    @Test
    public void testPrintRecords_WithHeader() throws SQLException, IOException {
        when(resultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(resultSet.getMetaData().getColumnLabel(1)).thenReturn("Header1");
        when(resultSet.getMetaData().getColumnLabel(2)).thenReturn("Header2");
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn("Value1");
        when(resultSet.getObject(2)).thenReturn("Value2");
        csvPrinter.printRecords(resultSet, true);
        String expectedOutput = "Header1,Header2\nValue1,Value2\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testPrintRecords_WithoutHeader() throws SQLException, IOException {
        when(resultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn("Value1");
        when(resultSet.getObject(2)).thenReturn("Value2");
        csvPrinter.printRecords(resultSet, false);
        String expectedOutput = "Value1,Value2\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testPrintRecords_EmptyResultSet() throws SQLException, IOException {
        when(resultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(resultSet.next()).thenReturn(false);
        csvPrinter.printRecords(resultSet, true);
        String expectedOutput = "";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testPrintRecords_HandlesSQLException() throws SQLException {
        when(resultSet.getMetaData().getColumnCount()).thenThrow(new SQLException("SQL Exception"));
        assertThrows(SQLException.class, () -> {
            csvPrinter.printRecords(resultSet, true);
        });
    }

    @Test
    public void testPrintRecords_HandlesIOException() throws SQLException, IOException {
        when(resultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(resultSet.next()).thenReturn(true, false);
        when(resultSet.getObject(1)).thenReturn("Value1");
        when(resultSet.getObject(2)).thenReturn("Value2");
        // Simulate IOException
        doThrow(new IOException("IO Exception")).when(csvPrinter).print(any());
        assertThrows(IOException.class, () -> {
            csvPrinter.printRecords(resultSet, true);
        });
    }
}
