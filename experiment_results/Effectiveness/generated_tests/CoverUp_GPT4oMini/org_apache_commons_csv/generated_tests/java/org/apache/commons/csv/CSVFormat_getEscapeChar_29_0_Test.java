package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import static org.apache.commons.io.IOUtils.EOF;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
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

public class CSVFormat_getEscapeChar_29_0_Test {

    @Test
    public void testGetEscapeCharWithEscapeCharacter() throws Exception {
        // Create a builder with a specific escape character
        CSVFormat formatWithEscape = CSVFormat.DEFAULT.builder().setEscape('\\').get();
        // Use reflection to invoke the private method
        Method method = CSVFormat.class.getDeclaredMethod("getEscapeChar");
        method.setAccessible(true);
        // Invoke the method and assert the expected value
        char escapeChar = (char) method.invoke(formatWithEscape);
        assertEquals('\\', escapeChar);
    }

    @Test
    public void testGetEscapeCharWithoutEscapeCharacter() throws Exception {
        // Create a builder without an escape character
        CSVFormat formatWithoutEscape = CSVFormat.DEFAULT.builder().setEscape(null).get();
        // Use reflection to invoke the private method
        Method method = CSVFormat.class.getDeclaredMethod("getEscapeChar");
        method.setAccessible(true);
        // Invoke the method and assert the expected value
        char escapeChar = (char) method.invoke(formatWithoutEscape);
        assertEquals(0, escapeChar);
    }
}
