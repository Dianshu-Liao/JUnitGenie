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

public class StringUtils_splitWorker_195_0_Test {

    @Test
    public void testSplitWorker_NullString() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, null, null, 0, false);
        assertNull(result);
    }

    @Test
    public void testSplitWorker_EmptyString() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "", null, 0, false);
        assertArrayEquals(new String[] {}, result);
    }

    @Test
    public void testSplitWorker_WhitespaceString() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "   ", null, 0, false);
        assertArrayEquals(new String[] { "", "", "", "" }, result);
    }

    @Test
    public void testSplitWorker_SingleCharacterSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "a,b,c", ",", 0, false);
        assertArrayEquals(new String[] { "a", "b", "c" }, result);
    }

    @Test
    public void testSplitWorker_MultipleCharacterSeparator() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "one::two::three", "::", 0, false);
        assertArrayEquals(new String[] { "one", "two", "three" }, result);
    }

    @Test
    public void testSplitWorker_PreserveAllTokens() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "one,,two", ",", 0, true);
        assertArrayEquals(new String[] { "one", "", "two" }, result);
    }

    @Test
    public void testSplitWorker_MaxTokens() throws Exception {
        StringUtils stringUtils = new StringUtils();
        String[] result = invokeSplitWorker(stringUtils, "a,b,c,d", ",", 2, false);
        assertArrayEquals(new String[] { "a", "b" }, result);
    }

    private String[] invokeSplitWorker(StringUtils stringUtils, String str, String separatorChars, int max, boolean preserveAllTokens) throws Exception {
        Method method = StringUtils.class.getDeclaredMethod("splitWorker", String.class, String.class, int.class, boolean.class);
        method.setAccessible(true);
        return (String[]) method.invoke(stringUtils, str, separatorChars, max, preserveAllTokens);
    }
}
