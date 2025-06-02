package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class CSVFormat_print_59_1_Test {

    @Test
    public void testPrintWithNewRecordAndNullObject() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        invokePrint(csvFormat, null, "value", writer, true);
        assertEquals("\"value\"", writer.toString());
    }

    @Test
    public void testPrintWithNewRecordAndNonNullObject() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        invokePrint(csvFormat, new Object(), "value", writer, true);
        assertEquals("\"value\"", writer.toString());
    }

    @Test
    public void testPrintWithoutNewRecord() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        invokePrint(csvFormat, null, "value", writer, false);
        assertEquals(",", writer.toString());
    }

    @Test
    public void testPrintWithEscapedCharacters() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        invokePrint(csvFormat, null, "value,with,commas", writer, true);
        assertEquals("\"value,with,commas\"", writer.toString());
    }

    @Test
    public void testPrintWithEscapedNewLine() throws Exception {
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        invokePrint(csvFormat, null, "value\nwith\nnewlines", writer, true);
        assertEquals("\"value\\nwith\\nnewlines\"", writer.toString());
    }

    @Test
    public void testPrintWithInvalidAppendable() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertThrows(IOException.class, () -> {
            invokePrint(csvFormat, null, "value", new Appendable() {

                @Override
                public Appendable append(CharSequence csq) throws IOException {
                    throw new IOException("Append failed");
                }

                @Override
                public Appendable append(CharSequence csq, int start, int end) throws IOException {
                    return this;
                }

                @Override
                public Appendable append(char c) throws IOException {
                    return this;
                }
            }, true);
        });
    }

    private void invokePrint(CSVFormat csvFormat, Object object, CharSequence value, Appendable out, boolean newRecord) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("print", Object.class, CharSequence.class, Appendable.class, boolean.class);
        method.setAccessible(true);
        method.invoke(csvFormat, object, value, out, newRecord);
    }
}
