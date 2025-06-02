package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import java.lang.reflect.Method;
import java.lang.reflect.Field;
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

public class CSVFormat_println_63_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    public void testPrintlnWithTrailingDelimiter() throws Exception {
        StringWriter writer = new StringWriter();
        setPrivateField(csvFormat, "trailingDelimiter", true);
        setPrivateField(csvFormat, "delimiter", ",");
        setPrivateField(csvFormat, "recordSeparator", "\n");
        invokePrivateMethod(csvFormat, "println", writer);
        assertEquals(",\n", writer.toString());
    }

    @Test
    public void testPrintlnWithoutTrailingDelimiter() throws Exception {
        StringWriter writer = new StringWriter();
        setPrivateField(csvFormat, "trailingDelimiter", false);
        setPrivateField(csvFormat, "recordSeparator", "\n");
        invokePrivateMethod(csvFormat, "println", writer);
        assertEquals("\n", writer.toString());
    }

    @Test
    public void testPrintlnWithNullRecordSeparator() throws Exception {
        StringWriter writer = new StringWriter();
        setPrivateField(csvFormat, "trailingDelimiter", true);
        setPrivateField(csvFormat, "delimiter", ",");
        setPrivateField(csvFormat, "recordSeparator", null);
        invokePrivateMethod(csvFormat, "println", writer);
        assertEquals(",", writer.toString());
    }

    private void invokePrivateMethod(Object instance, String methodName, Object... args) throws Exception {
        Method method = instance.getClass().getDeclaredMethod(methodName, Appendable.class);
        method.setAccessible(true);
        method.invoke(instance, args);
    }

    private void setPrivateField(Object instance, String fieldName, Object value) throws Exception {
        Field field = instance.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(instance, value);
    }
}
