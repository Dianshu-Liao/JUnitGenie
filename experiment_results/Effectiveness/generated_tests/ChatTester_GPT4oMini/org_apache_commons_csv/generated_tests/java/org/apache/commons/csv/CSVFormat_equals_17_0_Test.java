package org.apache.commons.csv;

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

public class CSVFormat_equals_17_0_Test {

    @Test
    public void testEquals_SameInstance() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertTrue(csvFormat.equals(csvFormat));
    }

    @Test
    public void testEquals_NullObject() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertFalse(csvFormat.equals(null));
    }

    @Test
    public void testEquals_DifferentClass() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertFalse(csvFormat.equals(new Object()));
    }

    @Test
    public void testEquals_EqualObjects() throws Exception {
        CSVFormat csvFormat1 = CSVFormat.DEFAULT;
        CSVFormat csvFormat2 = CSVFormat.DEFAULT;
        // Set private fields to be equal
        setPrivateField(csvFormat1, "allowMissingColumnNames", true);
        setPrivateField(csvFormat2, "allowMissingColumnNames", true);
        setPrivateField(csvFormat1, "autoFlush", false);
        setPrivateField(csvFormat2, "autoFlush", false);
        setPrivateField(csvFormat1, "commentMarker", null);
        setPrivateField(csvFormat2, "commentMarker", null);
        setPrivateField(csvFormat1, "delimiter", ",");
        setPrivateField(csvFormat2, "delimiter", ",");
        setPrivateField(csvFormat1, "duplicateHeaderMode", DuplicateHeaderMode.ALLOW_ALL);
        setPrivateField(csvFormat2, "duplicateHeaderMode", DuplicateHeaderMode.ALLOW_ALL);
        setPrivateField(csvFormat1, "escapeCharacter", '\\');
        setPrivateField(csvFormat2, "escapeCharacter", '\\');
        setPrivateField(csvFormat1, "headerComments", new String[] { "Comment1" });
        setPrivateField(csvFormat2, "headerComments", new String[] { "Comment1" });
        setPrivateField(csvFormat1, "headers", new String[] { "Header1" });
        setPrivateField(csvFormat2, "headers", new String[] { "Header1" });
        setPrivateField(csvFormat1, "ignoreEmptyLines", true);
        setPrivateField(csvFormat2, "ignoreEmptyLines", true);
        setPrivateField(csvFormat1, "ignoreHeaderCase", false);
        setPrivateField(csvFormat2, "ignoreHeaderCase", false);
        setPrivateField(csvFormat1, "ignoreSurroundingSpaces", false);
        setPrivateField(csvFormat2, "ignoreSurroundingSpaces", false);
        setPrivateField(csvFormat1, "lenientEof", false);
        setPrivateField(csvFormat2, "lenientEof", false);
        setPrivateField(csvFormat1, "nullString", "NULL");
        setPrivateField(csvFormat2, "nullString", "NULL");
        setPrivateField(csvFormat1, "quoteCharacter", '"');
        setPrivateField(csvFormat2, "quoteCharacter", '"');
        setPrivateField(csvFormat1, "quoteMode", QuoteMode.ALL_NON_NULL);
        setPrivateField(csvFormat2, "quoteMode", QuoteMode.ALL_NON_NULL);
        setPrivateField(csvFormat1, "quotedNullString", "NULL");
        setPrivateField(csvFormat2, "quotedNullString", "NULL");
        setPrivateField(csvFormat1, "recordSeparator", "\n");
        setPrivateField(csvFormat2, "recordSeparator", "\n");
        setPrivateField(csvFormat1, "skipHeaderRecord", false);
        setPrivateField(csvFormat2, "skipHeaderRecord", false);
        setPrivateField(csvFormat1, "trailingData", false);
        setPrivateField(csvFormat2, "trailingData", false);
        setPrivateField(csvFormat1, "trailingDelimiter", false);
        setPrivateField(csvFormat2, "trailingDelimiter", false);
        setPrivateField(csvFormat1, "trim", true);
        setPrivateField(csvFormat2, "trim", true);
        assertTrue(csvFormat1.equals(csvFormat2));
    }

    @Test
    public void testEquals_NotEqualObjects() throws Exception {
        CSVFormat csvFormat1 = CSVFormat.DEFAULT;
        CSVFormat csvFormat2 = CSVFormat.DEFAULT;
        // Set private fields to be different
        setPrivateField(csvFormat1, "allowMissingColumnNames", true);
        setPrivateField(csvFormat2, "allowMissingColumnNames", false);
        assertFalse(csvFormat1.equals(csvFormat2));
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
