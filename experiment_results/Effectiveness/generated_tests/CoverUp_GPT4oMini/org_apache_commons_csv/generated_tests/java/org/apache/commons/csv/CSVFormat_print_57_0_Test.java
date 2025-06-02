package org.apache.commons.csv;

import org.apache.commons.io.IOUtils;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
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
import org.apache.commons.io.function.IOStream;
import org.apache.commons.io.function.Uncheck;
import org.apache.commons.io.output.AppendableOutputStream;

public class CSVFormat_print_57_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    public void testPrintWithNewRecord() throws Exception {
        String input = "value1,value2,value3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        StringWriter output = new StringWriter();
        invokePrintMethod(inputStream, output, true);
        String expectedOutput = "value1,value2,value3\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testPrintWithoutNewRecord() throws Exception {
        String input = "value1,value2,value3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        StringWriter output = new StringWriter();
        invokePrintMethod(inputStream, output, false);
        String expectedOutput = csvFormat.getDelimiterString() + "value1,value2,value3\n";
        assertEquals(expectedOutput, output.toString());
    }

    @Test
    public void testPrintWithIOException() throws Exception {
        String input = "value1,value2,value3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(input.getBytes());
        StringWriter output = Mockito.mock(StringWriter.class);
        doThrow(new IOException("Mocked IOException")).when(output).append(Mockito.any(CharSequence.class));
        Exception exception = null;
        try {
            invokePrintMethod(inputStream, output, true);
        } catch (Exception e) {
            exception = e;
        }
        assertEquals(IOException.class, exception.getClass());
        assertEquals("Mocked IOException", exception.getMessage());
    }

    private void invokePrintMethod(InputStream inputStream, Appendable out, boolean newRecord) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("print", InputStream.class, Appendable.class, boolean.class);
        method.setAccessible(true);
        method.invoke(csvFormat, inputStream, out, newRecord);
    }
}
