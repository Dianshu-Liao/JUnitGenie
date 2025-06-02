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

public class StringUtils_rightPad_176_0_Test {

    @Test
    public void testRightPad_NullString() {
        String result = StringUtils.rightPad(null, 10, "*");
        assertNull(result, "Expected null when input string is null");
    }

    @Test
    public void testRightPad_EmptyPadString() {
        String result = StringUtils.rightPad("test", 10, "");
        assertEquals("test      ", result, "Expected spaces to be added when pad string is empty");
    }

    @Test
    public void testRightPad_SmallSize() {
        String result = StringUtils.rightPad("test", 3, "*");
        assertEquals("test", result, "Expected original string when size is smaller than string length");
    }

    @Test
    public void testRightPad_ExactSize() {
        String result = StringUtils.rightPad("test", 4, "*");
        assertEquals("test", result, "Expected original string when size is equal to string length");
    }

    @Test
    public void testRightPad_SingleCharacterPad() {
        String result = StringUtils.rightPad("test", 10, "*");
        assertEquals("test******", result, "Expected padding with single character pad string");
    }

    @Test
    public void testRightPad_MultipleCharacterPad() {
        String result = StringUtils.rightPad("test", 10, "ab");
        assertEquals("testababab", result, "Expected padding with multiple character pad string");
    }

    @Test
    public void testRightPad_PadLongerThanNeeded() {
        String result = StringUtils.rightPad("test", 10, "abcdef");
        assertEquals("testabcdef", result, "Expected padding with substring of pad string when it's longer than needed");
    }

    @Test
    public void testRightPad_PadShorterThanNeeded() {
        String result = StringUtils.rightPad("test", 12, "ab");
        assertEquals("testabababab", result, "Expected padding with repeated pad string when it's shorter than needed");
    }

    @Test
    public void testRightPad_LargePadLimit() {
        String result = StringUtils.rightPad("test", 8196, "*");
        assertEquals("test" + repeatString("*", 8192), result, "Expected padding with large pad limit");
    }

    private String repeatString(String str, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
