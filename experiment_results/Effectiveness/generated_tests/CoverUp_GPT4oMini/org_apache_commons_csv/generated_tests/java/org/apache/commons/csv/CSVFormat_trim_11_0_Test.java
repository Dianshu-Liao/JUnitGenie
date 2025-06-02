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

public class CSVFormat_trim_11_0_Test {

    @Test
    public void testTrimWithString() throws Exception {
        // Arrange
        String input = "  Hello World  ";
        CharSequence expected = "Hello World";
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        trimMethod.setAccessible(true);
        // Act
        CharSequence result = (CharSequence) trimMethod.invoke(null, input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testTrimWithCharSequence() throws Exception {
        // Arrange
        CharSequence input = "  Test String  ";
        CharSequence expected = "Test String";
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        trimMethod.setAccessible(true);
        // Act
        CharSequence result = (CharSequence) trimMethod.invoke(null, input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testTrimWithNoLeadingOrTrailingSpaces() throws Exception {
        // Arrange
        String input = "NoSpaces";
        CharSequence expected = "NoSpaces";
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        trimMethod.setAccessible(true);
        // Act
        CharSequence result = (CharSequence) trimMethod.invoke(null, input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testTrimWithOnlySpaces() throws Exception {
        // Arrange
        String input = "     ";
        CharSequence expected = "";
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        trimMethod.setAccessible(true);
        // Act
        CharSequence result = (CharSequence) trimMethod.invoke(null, input);
        // Assert
        assertEquals(expected, result);
    }

    @Test
    public void testTrimWithEmptyString() throws Exception {
        // Arrange
        String input = "";
        CharSequence expected = "";
        Method trimMethod = CSVFormat.class.getDeclaredMethod("trim", CharSequence.class);
        trimMethod.setAccessible(true);
        // Act
        CharSequence result = (CharSequence) trimMethod.invoke(null, input);
        // Assert
        assertEquals(expected, result);
    }
}
