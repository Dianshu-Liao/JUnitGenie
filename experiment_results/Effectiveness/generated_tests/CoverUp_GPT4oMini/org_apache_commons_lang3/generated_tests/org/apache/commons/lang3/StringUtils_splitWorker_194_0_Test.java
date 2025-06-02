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

public class StringUtils_splitWorker_194_0_Test {

    @Test
    public void testSplitWorker_NullString() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, null, ',', false);
        assertNull(result);
    }

    @Test
    public void testSplitWorker_EmptyString() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "", ',', false);
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    public void testSplitWorker_NoSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "test", ',', false);
        assertArrayEquals(new String[] { "test" }, result);
    }

    @Test
    public void testSplitWorker_WithSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "a,b,c", ',', false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    public void testSplitWorker_PreserveAllTokens() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "a,,b,c", ',', true);
        assertArrayEquals(new String[] { "a", "", "b", "c" }, result);
    }

    @Test
    public void testSplitWorker_TrailingSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "a,b,c,", ',', false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    public void testSplitWorker_LeadingSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, ",a,b,c", ',', false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    public void testSplitWorker_OnlySeparators() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, ",,", ',', true);
        assertArrayEquals(new String[] { "", "", "" }, result);
    }

    private String[] invokeSplitWorker(StringUtils stringUtils, String str, char separatorChar, boolean preserveAllTokens) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, char.class, boolean.class);
        method.setAccessible(true);
        return (String[]) method.invoke(null, str, separatorChar, preserveAllTokens);
    }
}
