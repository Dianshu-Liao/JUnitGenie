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

public class CSVFormat_isQuoteCharacterSet_51_0_Test {

    private CSVFormat csvFormat;

    @BeforeEach
    public void setUp() {
        // Initialize CSVFormat with a builder that sets quoteCharacter to null
        csvFormat = CSVFormat.newFormat(',').withQuote(null);
    }

    @Test
    public void testIsQuoteCharacterSet_QuoteCharacterIsNull() {
        // Test when quoteCharacter is null
        assertFalse(csvFormat.isQuoteCharacterSet());
    }

    @Test
    public void testIsQuoteCharacterSet_QuoteCharacterIsSet() {
        // Initialize CSVFormat with a builder that sets quoteCharacter to a valid character
        csvFormat = CSVFormat.newFormat(',').withQuote('"');
        // Test when quoteCharacter is set
        assertTrue(csvFormat.isQuoteCharacterSet());
    }

    @Test
    public void testIsQuoteCharacterSet_QuoteCharacterIsSetToDifferentValue() {
        // Initialize CSVFormat with a builder that sets quoteCharacter to a different valid character
        csvFormat = CSVFormat.newFormat(',').withQuote('\'');
        // Test when quoteCharacter is set to a different value
        assertTrue(csvFormat.isQuoteCharacterSet());
    }

    @Test
    public void testIsQuoteCharacterSet_QuoteCharacterIsSetToSpace() {
        // Initialize CSVFormat with a builder that sets quoteCharacter to a space
        csvFormat = CSVFormat.newFormat(',').withQuote(' ');
        // Test when quoteCharacter is set to a space
        assertTrue(csvFormat.isQuoteCharacterSet());
    }

    @Test
    public void testIsQuoteCharacterSet_QuoteCharacterIsSetToTab() {
        // Initialize CSVFormat with a builder that sets quoteCharacter to a tab
        csvFormat = CSVFormat.newFormat(',').withQuote('\t');
        // Test when quoteCharacter is set to a tab
        assertTrue(csvFormat.isQuoteCharacterSet());
    }

    // Reflection test for private method
    @Test
    public void testInvokePrivateMethod() throws Exception {
        Method method = CSVFormat.class.getDeclaredMethod("isQuoteCharacterSet");
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(csvFormat);
        assertFalse(result);
    }
}
