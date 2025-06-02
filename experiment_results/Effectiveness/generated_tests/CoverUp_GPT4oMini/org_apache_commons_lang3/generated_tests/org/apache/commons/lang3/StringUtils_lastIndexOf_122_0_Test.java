package org.apache.commons.lang3;

import java.lang.reflect.Method;
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

public class StringUtils_lastIndexOf_122_0_Test {

    @Test
    public void testLastIndexOf_NullInput() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, null, 'a');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_EmptyInput() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, "", 'a');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterNotFound() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, "hello", 'z');
        assertEquals(StringUtils.INDEX_NOT_FOUND, result);
    }

    @Test
    public void testLastIndexOf_CharacterFound() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, "hello", 'l');
        assertEquals(3, result);
    }

    @Test
    public void testLastIndexOf_CharacterAtStart() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, "hello", 'h');
        assertEquals(0, result);
    }

    @Test
    public void testLastIndexOf_CharacterAtEnd() throws Exception {
        StringUtils stringUtils = new StringUtils();
        Method method = StringUtils.class.getDeclaredMethod("lastIndexOf", CharSequence.class, int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(stringUtils, "hello", 'o');
        assertEquals(4, result);
    }
}
