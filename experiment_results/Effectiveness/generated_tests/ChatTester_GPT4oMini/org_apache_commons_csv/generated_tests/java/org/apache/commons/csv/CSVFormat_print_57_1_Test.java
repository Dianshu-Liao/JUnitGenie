package org.apache.commons.csv;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.function.Uncheck;
import org.apache.commons.io.output.AppendableOutputStream;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class CSVFormat_print_57_1_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    void setUp() {
        // Initialize with the default format
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    void testPrintWithoutNewRecord() throws Exception {
        // Arrange
        String inputData = "test,data\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean newRecord = false;
        invokePrintMethod(inputStream, new OutputStreamWriter(outputStream), newRecord);
        // Assert
        String expectedOutput = csvFormat.getDelimiterString() + "test,data\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintWithNewRecord() throws Exception {
        // Arrange
        String inputData = "test,data\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean newRecord = true;
        invokePrintMethod(inputStream, new OutputStreamWriter(outputStream), newRecord);
        // Assert
        String expectedOutput = "test,data\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintWithQuoteCharacter() throws Exception {
        // Arrange
        String inputData = "test,data\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean newRecord = false;
        setQuoteCharacter(csvFormat, '"');
        invokePrintMethod(inputStream, new OutputStreamWriter(outputStream), newRecord);
        // Assert
        String expectedOutput = csvFormat.getDelimiterString() + "\"test,data\"\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    void testPrintWithNoQuoteCharacter() throws Exception {
        // Arrange
        String inputData = "test,data\n";
        InputStream inputStream = new ByteArrayInputStream(inputData.getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        boolean newRecord = false;
        setQuoteCharacter(csvFormat, null);
        invokePrintMethod(inputStream, new OutputStreamWriter(outputStream), newRecord);
        // Assert
        String expectedOutput = csvFormat.getDelimiterString() + "test,data\n";
        assertEquals(expectedOutput, outputStream.toString());
    }

    private void invokePrintMethod(InputStream inputStream, Appendable out, boolean newRecord) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("print", InputStream.class, Appendable.class, boolean.class);
        method.setAccessible(true);
        method.invoke(csvFormat, inputStream, out, newRecord);
    }

    private void setQuoteCharacter(CSVFormat csvFormat, Character quoteCharacter) throws Exception {
        Field field = CSVFormat.class.getDeclaredField("quoteCharacter");
        field.setAccessible(true);
        field.set(csvFormat, quoteCharacter);
    }
}
