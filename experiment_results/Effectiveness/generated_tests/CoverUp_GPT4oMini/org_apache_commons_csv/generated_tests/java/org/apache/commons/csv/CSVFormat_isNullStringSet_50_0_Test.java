package org.apache.commons.csv;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
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

public class CSVFormat_isNullStringSet_50_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        // Using reflection to create an instance of CSVFormat since its constructor is private
        try {
            Constructor<CSVFormat> constructor = CSVFormat.class.getDeclaredConstructor(CSVFormat.Builder.class);
            constructor.setAccessible(true);
            csvFormat = constructor.newInstance(CSVFormat.Builder.create());
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIsNullStringSet_WhenNullStringIsNotSet() {
        // Arrange
        setNullString(null);
        // Act
        boolean result = csvFormat.isNullStringSet();
        // Assert
        assertFalse(result);
    }

    @Test
    public void testIsNullStringSet_WhenNullStringIsSet() {
        // Arrange
        setNullString("NULL");
        // Act
        boolean result = csvFormat.isNullStringSet();
        // Assert
        assertTrue(result);
    }

    private void setNullString(String nullString) {
        try {
            Field field = CSVFormat.class.getDeclaredField("nullString");
            field.setAccessible(true);
            field.set(csvFormat, nullString);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
