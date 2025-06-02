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

public class StringUtils_center_9_0_Test {

    @Test
    public void testCenter_NullString() {
        String result = StringUtils.center(null, 10, '*');
        assertNull(result);
    }

    @Test
    public void testCenter_ZeroSize() {
        String result = StringUtils.center("test", 0, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_NegativeSize() {
        String result = StringUtils.center("test", -5, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_SmallerSize() {
        String result = StringUtils.center("test", 3, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_ExactSize() {
        String result = StringUtils.center("test", 4, '*');
        assertEquals("test", result);
    }

    @Test
    public void testCenter_EvenPadding() {
        String result = StringUtils.center("test", 10, '*');
        assertEquals("***test****", result);
    }

    @Test
    public void testCenter_OddPadding() {
        String result = StringUtils.center("test", 9, '*');
        assertEquals("**test***", result);
    }

    @Test
    public void testCenter_CustomPadCharacter() {
        String result = StringUtils.center("test", 10, '#');
        assertEquals("###test###", result);
    }

    @Test
    public void testCenter_PadCharacterIsSpace() {
        String result = StringUtils.center("test", 10, ' ');
        assertEquals("    test   ", result);
    }

    @Test
    public void testCenter_LargeSize() {
        String result = StringUtils.center("test", 100, '*');
        assertEquals("********************************************test*********************************************", result);
    }
}
