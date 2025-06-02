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

public class CSVFormat_withAllowDuplicateHeaderNames_75_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        // Initialize with default CSVFormat
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    public void testWithAllowDuplicateHeaderNamesTrue() throws Exception {
        // Invoke the focal method with true
        CSVFormat result = invokeWithAllowDuplicateHeaderNames(true);
        // Assert that the returned CSVFormat is not null
        assertNotNull(result);
        // Validate that the DuplicateHeaderMode is set to ALLOW_ALL
        assertEquals(DuplicateHeaderMode.ALLOW_ALL, getDuplicateHeaderMode(result));
    }

    @Test
    public void testWithAllowDuplicateHeaderNamesFalse() throws Exception {
        // Invoke the focal method with false
        CSVFormat result = invokeWithAllowDuplicateHeaderNames(false);
        // Assert that the returned CSVFormat is not null
        assertNotNull(result);
        // Validate that the DuplicateHeaderMode is set to ALLOW_EMPTY
        assertEquals(DuplicateHeaderMode.ALLOW_EMPTY, getDuplicateHeaderMode(result));
    }

    private CSVFormat invokeWithAllowDuplicateHeaderNames(boolean allowDuplicateHeaderNames) throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("withAllowDuplicateHeaderNames", boolean.class);
        method.setAccessible(true);
        return (CSVFormat) method.invoke(csvFormat, allowDuplicateHeaderNames);
    }

    private DuplicateHeaderMode getDuplicateHeaderMode(CSVFormat csvFormat) throws Exception {
        // Use reflection to access the private field 'duplicateHeaderMode'
        java.lang.reflect.Field field = CSVFormat.class.getDeclaredField("duplicateHeaderMode");
        field.setAccessible(true);
        return (DuplicateHeaderMode) field.get(csvFormat);
    }
}
