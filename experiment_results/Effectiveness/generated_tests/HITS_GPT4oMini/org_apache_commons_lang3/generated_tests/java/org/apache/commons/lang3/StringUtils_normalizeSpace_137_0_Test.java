package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.UnsupportedEncodingException;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_normalizeSpace_137_0_Test {

    @Test
    public void testNormalizeSpace_WithNullString() {
        String result = StringUtils.normalizeSpace(null);
        assertNull(result, "Expected null for input null");
    }

    @Test
    public void testNormalizeSpace_WithEmptyString() {
        String result = StringUtils.normalizeSpace("");
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for input empty string");
    }

    @Test
    public void testNormalizeSpace_WithSingleWhitespace() {
        String result = StringUtils.normalizeSpace(" ");
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for input single whitespace");
    }

    @Test
    public void testNormalizeSpace_WithMultipleWhitespaces() {
        String result = StringUtils.normalizeSpace("   Hello   World   ");
        assertEquals("Hello World", result, "Expected 'Hello World' for input with multiple spaces");
    }

    @Test
    public void testNormalizeSpace_WithLeadingAndTrailingSpaces() {
        String result = StringUtils.normalizeSpace("   Java   ");
        assertEquals("Java", result, "Expected 'Java' for input with leading and trailing spaces");
    }

    @Test
    public void testNormalizeSpace_WithNonWhitespaceCharacters() {
        String result = StringUtils.normalizeSpace("Java   Programming");
        assertEquals("Java Programming", result, "Expected 'Java Programming' for input with spaces between words");
    }

    @Test
    public void testNormalizeSpace_WithNonBreakingSpaces() {
        String result = StringUtils.normalizeSpace("Java\u00A0Programming");
        assertEquals("Java Programming", result, "Expected 'Java Programming' for input with non-breaking space");
    }

    @Test
    public void testNormalizeSpace_WithOnlyWhitespaceCharacters() {
        String result = StringUtils.normalizeSpace("\t\n\r  ");
        assertEquals(StringUtils.EMPTY, result, "Expected empty string for input with only whitespace characters");
    }

    @Test
    public void testNormalizeSpace_WithMixedWhitespaceCharacters() {
        String result = StringUtils.normalizeSpace("   \tHello\nWorld\r   ");
        assertEquals("Hello World", result, "Expected 'Hello World' for input with mixed whitespace characters");
    }
}
