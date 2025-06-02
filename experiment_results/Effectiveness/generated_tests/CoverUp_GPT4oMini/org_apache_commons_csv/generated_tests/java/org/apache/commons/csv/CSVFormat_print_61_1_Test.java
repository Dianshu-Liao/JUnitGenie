package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.io.IOException;
import java.io.Reader;
import java.io.StringWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import java.io.StringReader;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.InputStream;
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

class CSVFormat_print_61_1_Test {

    @Test
    void testPrintWithQuotes() throws Exception {
        // Arrange
        String input = "value1,value2,value3\n";
        Reader reader = new StringReader(input);
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Act
        invokePrintMethod(csvFormat, reader, writer, true);
        // Assert
        String expectedOutput = "\"value1\",\"value2\",\"value3\"\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testPrintWithEscapes() throws Exception {
        // Arrange
        String input = "value1,value2,value3\n";
        Reader reader = new StringReader(input);
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Act
        invokePrintMethod(csvFormat, reader, writer, false);
        // Assert
        String expectedOutput = "value1,value2,value3\n";
        assertEquals(expectedOutput, writer.toString());
    }

    @Test
    void testPrintWithDelimiter() throws Exception {
        // Arrange
        String input = "value1,value2,value3\n";
        Reader reader = new StringReader(input);
        StringWriter writer = new StringWriter();
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        // Act
        invokePrintMethod(csvFormat, reader, writer, false);
        // Assert
        String expectedOutput = "value1,value2,value3\n";
        assertEquals(expectedOutput, writer.toString());
    }

    private void invokePrintMethod(CSVFormat csvFormat, Reader reader, Appendable out, boolean newRecord) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
        method.setAccessible(true);
        method.invoke(csvFormat, reader, out, newRecord);
    }
}
