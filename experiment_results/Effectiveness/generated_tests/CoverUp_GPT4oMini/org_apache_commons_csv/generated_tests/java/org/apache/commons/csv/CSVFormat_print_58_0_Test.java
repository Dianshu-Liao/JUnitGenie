package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.QuoteMode;
import java.io.IOException;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.InputStream;
import java.io.Reader;
import java.io.ByteArrayInputStream;
import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.OutputStream;
import java.io.Serializable;
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

class CSVFormat_print_58_0_Test {

    private CSVFormat csvFormat;

    private StringWriter output;

    @BeforeEach
    void setUp() {
        csvFormat = CSVFormat.DEFAULT;
        output = new StringWriter();
    }

    @Test
    void testPrintNullValueWithoutNullString() throws IOException {
        csvFormat.print(null, output, true);
        assertEquals("", output.toString());
    }

    @Test
    void testPrintNullValueWithNullString() throws IOException {
        CSVFormat customFormat = CSVFormat.DEFAULT.builder().setNullString("NULL").build();
        customFormat.print(null, output, true);
        assertEquals("NULL", output.toString());
    }

    @Test
    void testPrintCharSequence() throws IOException {
        CharSequence input = "TestString";
        csvFormat.print(input, output, true);
        assertEquals("TestString", output.toString());
    }

    @Test
    void testPrintReader() throws IOException {
        String input = "ReaderInput";
        csvFormat.print(new StringReader(input), output, true);
        assertEquals("ReaderInput", output.toString());
    }

    @Test
    void testPrintInputStream() throws IOException {
        String input = "InputStreamInput";
        csvFormat.print(new ByteArrayInputStream(input.getBytes()), output, true);
        assertEquals("InputStreamInput", output.toString());
    }

    @Test
    void testPrintWithNewRecord() throws IOException {
        csvFormat.print("First", output, true);
        csvFormat.print("Second", output, false);
        assertEquals("First,Second", output.toString());
    }

    @Test
    void testPrintWithEscapeCharacter() throws Exception {
        CSVFormat customFormat = invokeSetEscapeCharacter(CSVFormat.DEFAULT.builder(), '\\').build();
        customFormat.print("Escape\\Test", output, true);
        assertEquals("Escape\\Test", output.toString());
    }

    @Test
    void testPrintWithQuoteCharacter() throws Exception {
        CSVFormat customFormat = invokeSetQuoteCharacter(CSVFormat.DEFAULT.builder(), '"').build();
        customFormat.print("Quote\"Test", output, true);
        assertEquals("\"Quote\"\"Test\"", output.toString());
    }

    @Test
    void testPrintWithTrim() throws Exception {
        CSVFormat customFormat = CSVFormat.DEFAULT.builder().setTrim(true).build();
        customFormat.print("   TrimTest   ", output, true);
        assertEquals("TrimTest", output.toString());
    }

    @Test
    void testPrintWithTrailingData() throws Exception {
        CSVFormat customFormat = CSVFormat.DEFAULT.builder().setTrailingData(true).build();
        customFormat.print("Data", output, true);
        assertEquals("Data", output.toString());
    }

    private CSVFormat.Builder invokeSetEscapeCharacter(CSVFormat.Builder builder, char escape) throws Exception {
        Method method = builder.getClass().getDeclaredMethod("setEscapeCharacter", char.class);
        method.setAccessible(true);
        method.invoke(builder, escape);
        return builder;
    }

    private CSVFormat.Builder invokeSetQuoteCharacter(CSVFormat.Builder builder, char quote) throws Exception {
        Method method = builder.getClass().getDeclaredMethod("setQuoteCharacter", char.class);
        method.setAccessible(true);
        method.invoke(builder, quote);
        return builder;
    }
}
