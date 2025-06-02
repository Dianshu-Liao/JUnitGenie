package org.apache.commons.lang3;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
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
import java.util.Iterator;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Supplier;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.apache.commons.lang3.function.Suppliers;
import org.apache.commons.lang3.stream.LangCollectors;
import org.apache.commons.lang3.stream.Streams;

public class StringUtils_join_108_1_Test {

    @Test
    public void testJoin_NullList() {
        String result = invokeJoinMethod(null, ',', 0, 5);
        assertNull(result);
    }

    @Test
    public void testJoin_EmptySubList() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = invokeJoinMethod(list, ',', 1, 1);
        assertEquals("", result);
    }

    @Test
    public void testJoin_SingleElementSubList() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = invokeJoinMethod(list, ',', 1, 2);
        assertEquals("b", result);
    }

    @Test
    public void testJoin_MultipleElements() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = invokeJoinMethod(list, ',', 0, 3);
        assertEquals("a,b,c", result);
    }

    @Test
    public void testJoin_OutOfBounds() {
        List<String> list = Arrays.asList("a", "b", "c");
        String result = invokeJoinMethod(list, ',', 0, 5);
        assertEquals("a,b,c", result);
    }

    private String invokeJoinMethod(List<?> list, char separator, int startIndex, int endIndex) {
        try {
            Method joinMethod = StringUtils.class.getDeclaredMethod("join", List.class, char.class, int.class, int.class);
            joinMethod.setAccessible(true);
            return (String) joinMethod.invoke(null, list, separator, startIndex, endIndex);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
