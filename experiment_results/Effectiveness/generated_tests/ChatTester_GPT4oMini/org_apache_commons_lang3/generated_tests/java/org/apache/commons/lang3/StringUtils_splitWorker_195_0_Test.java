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

class StringUtils_splitWorker_195_0_Test {

    @Test
    void testSplitWorkerWithNullString() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, null, null, 0, false);
        assertNull(result);
    }

    @Test
    void testSplitWorkerWithEmptyString() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "", null, 0, false);
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    void testSplitWorkerWithWhitespace() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "   ", null, 0, false);
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    void testSplitWorkerWithSingleSeparator() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a,b,c", ",", 0, false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    void testSplitWorkerWithMultipleSeparators() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a,b,c", ",", 5, false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    void testSplitWorkerWithPreserveAllTokens() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a,,b", ",", 0, true);
        assertArrayEquals(new String[] { "a", "", "b" }, result);
    }

    @Test
    void testSplitWorkerWithMaxTokens() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a,b,c,d", ",", 2, false);
        assertArrayEquals(new String[] { "a", "b" }, result);
    }

    @Test
    void testSplitWorkerWithCustomSeparators() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a|b|c", "|", 0, false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    void testSplitWorkerWithMixedSeparators() throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        String[] result = (String[]) method.invoke(null, "a,b c|d", ", |", 0, false);
        assertArrayEquals(new String[] { "a", "b", "c", "d" }, result);
    }
}
