package org.apache.commons.csv;

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

public class CSVFormat_isNullStringSet_50_0_Test {

    private CSVFormat csvFormatWithNullString;

    private CSVFormat csvFormatWithoutNullString;

    @BeforeEach
    public void setUp() {
        // Using reflection to create instances of CSVFormat with different nullString values
        csvFormatWithNullString = invokeBuilderWithNullString("test");
        csvFormatWithoutNullString = invokeBuilderWithNullString(null);
    }

    private CSVFormat invokeBuilderWithNullString(String nullString) {
        try {
            // Accessing the Builder class through reflection
            Class<?> builderClass = Class.forName("CSVFormat$Builder");
            Object builderInstance = builderClass.getMethod("create").invoke(null);
            // Setting the nullString field via reflection
            builderClass.getMethod("setNullString", String.class).invoke(builderInstance, nullString);
            // Building the CSVFormat instance
            return (CSVFormat) builderClass.getMethod("get").invoke(builderInstance);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testIsNullStringSet_withNonNullString() throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("isNullStringSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormatWithNullString);
        assertTrue(result, "Expected isNullStringSet to return true when nullString is set.");
    }

    @Test
    public void testIsNullStringSet_withNullString() throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("isNullStringSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormatWithoutNullString);
        assertFalse(result, "Expected isNullStringSet to return false when nullString is not set.");
    }
}
