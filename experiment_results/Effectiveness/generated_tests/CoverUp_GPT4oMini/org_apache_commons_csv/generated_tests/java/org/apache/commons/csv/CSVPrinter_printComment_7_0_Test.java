package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import java.io.StringWriter;
import java.io.IOException;
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

public class CSVPrinter_printComment_7_0_Test {

    private StringWriter stringWriter;

    private CSVFormat csvFormat;

    private CSVPrinter csvPrinter;

    @BeforeEach
    public void setUp() throws IOException {
        stringWriter = new StringWriter();
        csvFormat = CSVFormat.DEFAULT.builder().setCommentMarker('#').get();
        csvPrinter = new CSVPrinter(stringWriter, csvFormat);
    }

    @Test
    public void testPrintComment_NullComment() throws IOException {
        csvPrinter.printComment(null);
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentMarkerNotSet() throws IOException {
        CSVFormat formatWithoutCommentMarker = CSVFormat.DEFAULT.builder().setCommentMarker(null).get();
        CSVPrinter printer = new CSVPrinter(stringWriter, formatWithoutCommentMarker);
        printer.printComment("This is a comment");
        assertEquals("", stringWriter.toString());
    }

    @Test
    public void testPrintComment_ValidComment() throws IOException {
        csvPrinter.printComment("This is a comment");
        assertEquals("# This is a comment\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentWithNewLine() throws IOException {
        csvPrinter.printComment("Line 1\nLine 2");
        assertEquals("# Line 1\n# Line 2\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentWithCarriageReturn() throws IOException {
        csvPrinter.printComment("Line 1\rLine 2");
        assertEquals("# Line 1\n# Line 2\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentWithCarriageReturnLineFeed() throws IOException {
        csvPrinter.printComment("Line 1\r\nLine 2");
        assertEquals("# Line 1\n# Line 2\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentWithMultipleNewLines() throws IOException {
        csvPrinter.printComment("Line 1\nLine 2\nLine 3");
        assertEquals("# Line 1\n# Line 2\n# Line 3\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentAfterExistingContent() throws IOException {
        csvPrinter.printComment("Initial comment");
        csvPrinter.printComment("Second comment");
        assertEquals("# Initial comment\n# Second comment\n", stringWriter.toString());
    }

    @Test
    public void testPrintComment_CommentAfterNewRecord() throws IOException {
        // Simulate a new record
        csvPrinter.println();
        csvPrinter.printComment("New comment");
        assertEquals("\n# New comment\n", stringWriter.toString());
    }
}
