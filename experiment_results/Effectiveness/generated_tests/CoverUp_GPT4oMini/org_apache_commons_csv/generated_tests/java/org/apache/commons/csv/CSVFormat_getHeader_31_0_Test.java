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

public class CSVFormat_getHeader_31_0_Test {

    @Test
    public void testGetHeader_WithHeaders() throws Exception {
        // Arrange
        String[] headers = { "Column1", "Column2", "Column3" };
        CSVFormat csvFormat = createCSVFormatWithHeaders(headers);
        // Act
        String[] result = invokeGetHeader(csvFormat);
        // Assert
        assertArrayEquals(headers, result);
    }

    @Test
    public void testGetHeader_NoHeaders() throws Exception {
        // Arrange
        CSVFormat csvFormat = createCSVFormatWithHeaders(null);
        // Act
        String[] result = invokeGetHeader(csvFormat);
        // Assert
        assertNull(result);
    }

    private CSVFormat createCSVFormatWithHeaders(String[] headers) throws Exception {
        // Using reflection to access the private constructor
        Method builderMethod = CSVFormat.class.getDeclaredMethod("builder");
        builderMethod.setAccessible(true);
        Object builder = builderMethod.invoke(null);
        // Setting headers
        Method setHeadersMethod = builder.getClass().getDeclaredMethod("setHeaders", String[].class);
        setHeadersMethod.setAccessible(true);
        setHeadersMethod.invoke(builder, (Object) headers);
        // Building the CSVFormat object
        Method getMethod = builder.getClass().getDeclaredMethod("get");
        getMethod.setAccessible(true);
        return (CSVFormat) getMethod.invoke(builder);
    }

    private String[] invokeGetHeader(CSVFormat csvFormat) throws Exception {
        Method getHeaderMethod = CSVFormat.class.getDeclaredMethod("getHeader");
        getHeaderMethod.setAccessible(true);
        return (String[]) getHeaderMethod.invoke(csvFormat);
    }
}
