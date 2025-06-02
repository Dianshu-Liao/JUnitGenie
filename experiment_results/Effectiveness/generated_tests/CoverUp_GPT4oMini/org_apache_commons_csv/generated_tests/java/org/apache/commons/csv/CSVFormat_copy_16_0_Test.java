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

class CSVFormat_copy_16_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    void setUp() {
        // Using the default instance for testing
        csvFormat = CSVFormat.DEFAULT;
    }

    @Test
    void testCopy() {
        // Act
        CSVFormat copiedFormat = csvFormat.copy();
        // Assert
        assertNotNull(copiedFormat);
        // Ensure it's a different instance
        assertNotSame(csvFormat, copiedFormat);
        // Check that all properties are the same
        assertEquals(csvFormat.getAllowMissingColumnNames(), copiedFormat.getAllowMissingColumnNames());
        assertEquals(csvFormat.getAutoFlush(), copiedFormat.getAutoFlush());
        assertEquals(csvFormat.getCommentMarker(), copiedFormat.getCommentMarker());
        assertEquals(csvFormat.getDelimiterString(), copiedFormat.getDelimiterString());
        assertEquals(csvFormat.getDuplicateHeaderMode(), copiedFormat.getDuplicateHeaderMode());
        assertEquals(csvFormat.getEscapeCharacter(), copiedFormat.getEscapeCharacter());
        assertArrayEquals(csvFormat.getHeader(), copiedFormat.getHeader());
        assertArrayEquals(csvFormat.getHeaderComments(), copiedFormat.getHeaderComments());
        assertEquals(csvFormat.getIgnoreEmptyLines(), copiedFormat.getIgnoreEmptyLines());
        assertEquals(csvFormat.getIgnoreHeaderCase(), copiedFormat.getIgnoreHeaderCase());
        assertEquals(csvFormat.getIgnoreSurroundingSpaces(), copiedFormat.getIgnoreSurroundingSpaces());
        assertEquals(csvFormat.getLenientEof(), copiedFormat.getLenientEof());
        assertEquals(csvFormat.getMaxRows(), copiedFormat.getMaxRows());
        assertEquals(csvFormat.getNullString(), copiedFormat.getNullString());
        assertEquals(csvFormat.getQuoteCharacter(), copiedFormat.getQuoteCharacter());
        assertEquals(csvFormat.getQuoteMode(), copiedFormat.getQuoteMode());
        assertEquals(csvFormat.getRecordSeparator(), copiedFormat.getRecordSeparator());
        assertEquals(csvFormat.getSkipHeaderRecord(), copiedFormat.getSkipHeaderRecord());
        assertEquals(csvFormat.getTrailingData(), copiedFormat.getTrailingData());
        assertEquals(csvFormat.getTrailingDelimiter(), copiedFormat.getTrailingDelimiter());
        assertEquals(csvFormat.getTrim(), copiedFormat.getTrim());
    }

    @Test
    void testCopyDifferentInstances() throws Exception {
        // Invoke a private method using reflection
        Method copyMethod = CSVFormat.class.getDeclaredMethod("copy");
        copyMethod.setAccessible(true);
        CSVFormat copiedFormat = (CSVFormat) copyMethod.invoke(csvFormat);
        // Assert that the copied format is not the same instance
        assertNotSame(csvFormat, copiedFormat);
    }
}
