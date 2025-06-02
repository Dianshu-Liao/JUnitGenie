package org.apache.commons.csv;

import java.lang.reflect.Field;
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

public class CSVFormat_copy_3_0_Test {

    @Test
    public void testCopy_NullFormat() {
        // Test the case where the input format is null
        CSVFormat result = CSVFormat.copy(null);
        assertNull(result, "Expected null when input format is null");
    }

    @Test
    public void testCopy_ValidFormat() throws Exception {
        // Test the case where the input format is a valid CSVFormat object
        CSVFormat originalFormat = CSVFormat.DEFAULT;
        // Use reflection to access the private copy method
        Method copyMethod = CSVFormat.class.getDeclaredMethod("copy", CSVFormat.class);
        copyMethod.setAccessible(true);
        CSVFormat result = (CSVFormat) copyMethod.invoke(null, originalFormat);
        assertNotNull(result, "Expected non-null result when copying a valid format");
        // Use reflection to access private fields
        Field[] fields = CSVFormat.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object originalValue = field.get(originalFormat);
            Object copiedValue = field.get(result);
            assertEquals(originalValue, copiedValue, "Field " + field.getName() + " should be equal after copy");
        }
    }
}
