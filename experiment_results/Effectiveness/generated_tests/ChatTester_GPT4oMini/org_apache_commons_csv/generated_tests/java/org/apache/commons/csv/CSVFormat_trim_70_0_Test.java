package org.apache.commons.csv;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class CSVFormat_trim_70_0_Test {

    @Test
    public void testTrimWithTrimEnabled() throws Exception {
        CSVFormat csvFormatWithTrim = CSVFormat.DEFAULT.withTrim();
        String input = "   test   ";
        // Act
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", String.class);
        trimMethod.setAccessible(true);
        String result = (String) trimMethod.invoke(csvFormatWithTrim, input);
        // Assert
        assertEquals("test", result);
    }

    @Test
    public void testTrimWithTrimDisabled() throws Exception {
        CSVFormat csvFormatWithoutTrim = CSVFormat.DEFAULT.withIgnoreSurroundingSpaces(false);
        String input = "   test   ";
        // Act
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", String.class);
        trimMethod.setAccessible(true);
        String result = (String) trimMethod.invoke(csvFormatWithoutTrim, input);
        // Assert
        assertEquals("   test   ", result);
    }

    @Test
    public void testTrimWithEmptyString() throws Exception {
        CSVFormat csvFormatWithTrim = CSVFormat.DEFAULT.withTrim();
        String input = "";
        // Act
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", String.class);
        trimMethod.setAccessible(true);
        String result = (String) trimMethod.invoke(csvFormatWithTrim, input);
        // Assert
        assertEquals("", result);
    }

    @Test
    public void testTrimWithNull() throws Exception {
        CSVFormat csvFormatWithTrim = CSVFormat.DEFAULT.withTrim();
        String input = null;
        // Act
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", String.class);
        trimMethod.setAccessible(true);
        String result = (String) trimMethod.invoke(csvFormatWithTrim, input);
        // Assert
        assertNull(result);
    }

    @Test
    public void testTrimWithWhitespaceOnly() throws Exception {
        CSVFormat csvFormatWithTrim = CSVFormat.DEFAULT.withTrim();
        String input = "       ";
        // Act
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", String.class);
        trimMethod.setAccessible(true);
        String result = (String) trimMethod.invoke(csvFormatWithTrim, input);
        // Assert
        assertEquals("", result);
    }
}
