package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import java.io.StringWriter;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
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

class CSVFormat_print_59_0_Test {

    @Test
    void testPrintWithNewRecord() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Invoke the private method using reflection
        invokePrint(csvFormat, null, "value", writer, true);
        assertEquals("value", writer.toString());
    }

    @Test
    void testPrintWithExistingRecord() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Invoke the private method using reflection
        invokePrint(csvFormat, null, "value", writer, false);
        assertEquals("value", writer.toString());
    }

    @Test
    void testPrintWithQuotedValue() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Test with a value that should be quoted
        invokePrint(csvFormat, new Object(), "value, with, commas", writer, true);
        assertEquals("\"value, with, commas\"", writer.toString());
    }

    @Test
    void testPrintWithEscapedValue() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Test with a value that should be escaped
        invokePrint(csvFormat, new Object(), "value\nwith\nnewlines", writer, true);
        assertEquals("\"value\\nwith\\nnewlines\"", writer.toString());
    }

    private void invokePrint(CSVFormat csvFormat, Object object, CharSequence value, StringWriter out, boolean newRecord) throws Exception {
        java.lang.reflect.Method method = CSVFormat.class.getDeclaredMethod("print", Object.class, CharSequence.class, Appendable.class, boolean.class);
        method.setAccessible(true);
        method.invoke(csvFormat, object, value, out, newRecord);
    }
}
