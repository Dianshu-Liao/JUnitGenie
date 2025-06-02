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

    @Test
    void testCopy() throws Exception {
        // Arrange
        // Using the DEFAULT instance for the test
        CSVFormat original = CSVFormat.DEFAULT;
        assertNotNull(original);
        // Act
        CSVFormat copy = invokeCopyMethod(original);
        // Assert
        assertNotNull(copy);
        // Ensure that the copy is a different instance
        assertNotSame(original, copy);
        assertEquals(original.getAllowMissingColumnNames(), copy.getAllowMissingColumnNames());
        assertEquals(original.getAutoFlush(), copy.getAutoFlush());
        assertEquals(original.getCommentMarker(), copy.getCommentMarker());
        assertEquals(original.getDelimiterString(), copy.getDelimiterString());
        assertEquals(original.getEscapeCharacter(), copy.getEscapeCharacter());
        assertArrayEquals(original.getHeader(), copy.getHeader());
        assertArrayEquals(original.getHeaderComments(), copy.getHeaderComments());
        assertEquals(original.getIgnoreEmptyLines(), copy.getIgnoreEmptyLines());
        assertEquals(original.getIgnoreHeaderCase(), copy.getIgnoreHeaderCase());
        assertEquals(original.getIgnoreSurroundingSpaces(), copy.getIgnoreSurroundingSpaces());
        assertEquals(original.getLenientEof(), copy.getLenientEof());
        assertEquals(original.getMaxRows(), copy.getMaxRows());
        assertEquals(original.getNullString(), copy.getNullString());
        assertEquals(original.getQuoteCharacter(), copy.getQuoteCharacter());
        assertEquals(original.getQuoteMode(), copy.getQuoteMode());
        assertEquals(original.getRecordSeparator(), copy.getRecordSeparator());
        assertEquals(original.getSkipHeaderRecord(), copy.getSkipHeaderRecord());
        assertEquals(original.getTrailingData(), copy.getTrailingData());
        assertEquals(original.getTrailingDelimiter(), copy.getTrailingDelimiter());
        assertEquals(original.getTrim(), copy.getTrim());
    }

    private CSVFormat invokeCopyMethod(CSVFormat csvFormat) throws Exception {
        Method copyMethod = CSVFormat.class.getDeclaredMethod("copy");
        copyMethod.setAccessible(true);
        return (CSVFormat) copyMethod.invoke(csvFormat);
    }
}
