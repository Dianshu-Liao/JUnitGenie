package org.apache.commons.csv;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.DuplicateHeaderMode;
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

    @Test
    public void testWithAllowDuplicateHeaderNamesTrue() throws Exception {
        // Arrange
        CSVFormat originalFormat = CSVFormat.DEFAULT;
        Method method = CSVFormat.class.getDeclaredMethod("withAllowDuplicateHeaderNames", boolean.class);
        method.setAccessible(true);
        // Act
        CSVFormat modifiedFormat = (CSVFormat) method.invoke(originalFormat, true);
        // Assert
        assertEquals(DuplicateHeaderMode.ALLOW_ALL, modifiedFormat.getDuplicateHeaderMode());
    }

    @Test
    public void testWithAllowDuplicateHeaderNamesFalse() throws Exception {
        // Arrange
        CSVFormat originalFormat = CSVFormat.DEFAULT;
        Method method = CSVFormat.class.getDeclaredMethod("withAllowDuplicateHeaderNames", boolean.class);
        method.setAccessible(true);
        // Act
        CSVFormat modifiedFormat = (CSVFormat) method.invoke(originalFormat, false);
        // Assert
        assertEquals(DuplicateHeaderMode.ALLOW_EMPTY, modifiedFormat.getDuplicateHeaderMode());
    }
}
