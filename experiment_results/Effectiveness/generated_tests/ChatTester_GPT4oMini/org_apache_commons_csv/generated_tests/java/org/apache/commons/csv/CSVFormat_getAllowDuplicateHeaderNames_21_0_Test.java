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

public class CSVFormat_getAllowDuplicateHeaderNames_21_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        // Assuming a Builder class exists to create instances of CSVFormat
        CSVFormat.Builder builder = CSVFormat.Builder.create().setDuplicateHeaderMode(DuplicateHeaderMode.ALLOW_ALL);
        // Corrected line to build the CSVFormat instance
        csvFormat = builder.build();
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_ReturnsTrue_WhenDuplicateHeaderModeIsAllowAll() {
        // Act
        boolean result = invokeGetAllowDuplicateHeaderNames(csvFormat);
        // Assert
        assertTrue(result, "Expected getAllowDuplicateHeaderNames to return true when duplicateHeaderMode is ALLOW_ALL");
    }

    @Test
    public void testGetAllowDuplicateHeaderNames_ReturnsFalse_WhenDuplicateHeaderModeIsNotAllowAll() {
        // Arrange
        CSVFormat.Builder builder = CSVFormat.Builder.create().setDuplicateHeaderMode(DuplicateHeaderMode.DISALLOW);
        // Corrected line to build the CSVFormat instance
        csvFormat = builder.build();
        // Act
        boolean result = invokeGetAllowDuplicateHeaderNames(csvFormat);
        // Assert
        assertFalse(result, "Expected getAllowDuplicateHeaderNames to return false when duplicateHeaderMode is not ALLOW_ALL");
    }

    private boolean invokeGetAllowDuplicateHeaderNames(CSVFormat csvFormat) {
        try {
            Method method = CSVFormat.class.getDeclaredMethod("getAllowDuplicateHeaderNames");
            method.setAccessible(true);
            return (boolean) method.invoke(csvFormat);
        } catch (Exception e) {
            fail("Exception occurred while invoking getAllowDuplicateHeaderNames: " + e.getMessage());
            // This line will never be reached due to fail() above
            return false;
        }
    }
}
