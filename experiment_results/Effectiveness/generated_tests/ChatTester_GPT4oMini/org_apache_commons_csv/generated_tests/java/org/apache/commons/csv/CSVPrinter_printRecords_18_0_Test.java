package org.apache.commons.csv;

import java.io.IOException;
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

    private StringWriter stringWriter;

    private ResultSet mockResultSet;

    @BeforeEach
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        CSVFormat mockFormat = mock(CSVFormat.class);
        csvPrinter = new CSVPrinter(stringWriter, mockFormat);
        mockResultSet = mock(ResultSet.class);
    }

    @Test
    public void testPrintRecordsWithHeader() throws SQLException, IOException {
        // Arrange
        when(mockResultSet.getMetaData()).thenReturn(mockResultSet.getMetaData());
        when(mockResultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(mockResultSet.getMetaData().getColumnName(1)).thenReturn("Header1");
        when(mockResultSet.getMetaData().getColumnName(2)).thenReturn("Header2");
        // Simulating two records
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getString(1)).thenReturn("Value1", "Value2");
        when(mockResultSet.getString(2)).thenReturn("Value3", "Value4");
        // Act
        csvPrinter.printRecords(mockResultSet, true);
        // Assert
        String expectedOutput = "Header1,Header2\nValue1,Value3\nValue2,Value4\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithoutHeader() throws SQLException, IOException {
        // Arrange
        when(mockResultSet.getMetaData()).thenReturn(mockResultSet.getMetaData());
        when(mockResultSet.getMetaData().getColumnCount()).thenReturn(2);
        // Simulating two records
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getString(1)).thenReturn("Value1", "Value2");
        when(mockResultSet.getString(2)).thenReturn("Value3", "Value4");
        // Act
        csvPrinter.printRecords(mockResultSet, false);
        // Assert
        String expectedOutput = "Value1,Value3\nValue2,Value4\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithEmptyResultSet() throws SQLException, IOException {
        // Arrange
        when(mockResultSet.getMetaData()).thenReturn(mockResultSet.getMetaData());
        when(mockResultSet.getMetaData().getColumnCount()).thenReturn(2);
        // Simulating no records
        when(mockResultSet.next()).thenReturn(false);
        // Act
        csvPrinter.printRecords(mockResultSet, true);
        // Assert
        // Assuming headers are printed even if no records
        String expectedOutput = "Header1,Header2\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }

    @Test
    public void testPrintRecordsWithNullValues() throws SQLException, IOException {
        // Arrange
        when(mockResultSet.getMetaData()).thenReturn(mockResultSet.getMetaData());
        when(mockResultSet.getMetaData().getColumnCount()).thenReturn(2);
        when(mockResultSet.getMetaData().getColumnName(1)).thenReturn("Header1");
        when(mockResultSet.getMetaData().getColumnName(2)).thenReturn("Header2");
        // Simulating two records
        when(mockResultSet.next()).thenReturn(true, true, false);
        when(mockResultSet.getString(1)).thenReturn(null, "Value2");
        when(mockResultSet.getString(2)).thenReturn("Value3", null);
        // Act
        csvPrinter.printRecords(mockResultSet, true);
        // Assert
        // Handling null values
        String expectedOutput = "Header1,Header2\n,,Value3\nValue2,\n";
        assertEquals(expectedOutput, stringWriter.toString());
    }
}
