package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.*;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
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

class CSVFormat_print_61_0_Test {

    @Test
    void testPrintWithoutNewRecord() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter output = new StringWriter();
        StringReader input = new StringReader("value1,value2,value3");
        // Invoke the private method `print` using reflection
        java.lang.reflect.Method printMethod = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
        printMethod.setAccessible(true);
        // Call the method with newRecord as false
        printMethod.invoke(csvFormat, input, output, false);
        assertEquals("," + "value1,value2,value3", output.toString());
    }

    @Test
    void testPrintWithQuotes() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter output = new StringWriter();
        StringReader input = new StringReader("value1,\"value2,value3\"");
        // Set the quote character
        setQuoteCharacter(csvFormat, '"');
        // Invoke the private method `print` using reflection
        java.lang.reflect.Method printMethod = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
        printMethod.setAccessible(true);
        printMethod.invoke(csvFormat, input, output, false);
        assertEquals("\"value1\",\"\"value2,value3\"\"", output.toString());
    }

    @Test
    void testPrintWithEscapes() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter output = new StringWriter();
        StringReader input = new StringReader("value1,value2\nvalue3");
        // Set the escape character
        setEscapeCharacter(csvFormat, '\\');
        // Invoke the private method `print` using reflection
        java.lang.reflect.Method printMethod = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
        printMethod.setAccessible(true);
        printMethod.invoke(csvFormat, input, output, false);
        assertEquals("value1,value2\nvalue3", output.toString());
    }

    @Test
    void testPrintWithWriterOutput() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter output = new StringWriter();
        StringReader input = new StringReader("value1,value2");
        // Invoke the private method `print` using reflection
        java.lang.reflect.Method printMethod = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
        printMethod.setAccessible(true);
        printMethod.invoke(csvFormat, input, output, true);
        assertEquals("value1,value2", output.toString());
    }

    private void setQuoteCharacter(CSVFormat csvFormat, char quote) throws Exception {
        java.lang.reflect.Field quoteField = CSVFormat.class.getDeclaredField("quoteCharacter");
        quoteField.setAccessible(true);
        quoteField.set(csvFormat, quote);
    }

    private void setEscapeCharacter(CSVFormat csvFormat, char escape) throws Exception {
        java.lang.reflect.Field escapeField = CSVFormat.class.getDeclaredField("escapeCharacter");
        escapeField.setAccessible(true);
        escapeField.set(csvFormat, escape);
    }
}
