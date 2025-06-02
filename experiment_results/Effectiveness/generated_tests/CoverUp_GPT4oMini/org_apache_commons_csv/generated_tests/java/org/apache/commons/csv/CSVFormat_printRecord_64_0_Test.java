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

public class CSVFormat_printRecord_64_0_Test {

    @Test
    public void testPrintRecordWithSingleValue() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter stringWriter = new StringWriter();
        Object[] values = { "value1" };
        // Invoke the private method using reflection
        invokePrintRecord(csvFormat, stringWriter, values);
        assertEquals("value1\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordWithMultipleValues() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter stringWriter = new StringWriter();
        Object[] values = { "value1", "value2", "value3" };
        // Invoke the private method using reflection
        invokePrintRecord(csvFormat, stringWriter, values);
        assertEquals("value1value2value3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordWithNullValue() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter stringWriter = new StringWriter();
        Object[] values = { "value1", null, "value3" };
        // Invoke the private method using reflection
        invokePrintRecord(csvFormat, stringWriter, values);
        assertEquals("value1nullvalue3\n", stringWriter.toString());
    }

    @Test
    public void testPrintRecordWithEmptyValues() throws Exception {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        StringWriter stringWriter = new StringWriter();
        Object[] values = { "", "" };
        // Invoke the private method using reflection
        invokePrintRecord(csvFormat, stringWriter, values);
        assertEquals("\n\n", stringWriter.toString());
    }

    private void invokePrintRecord(CSVFormat csvFormat, StringWriter stringWriter, Object[] values) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("printRecord", Appendable.class, Object[].class);
        method.setAccessible(true);
        method.invoke(csvFormat, stringWriter, (Object) values);
    }
}
