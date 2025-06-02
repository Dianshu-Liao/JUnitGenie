package org.apache.commons.lang3;

import org.apache.commons.lang3.CharRange;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

class CharSet_add_1_1_Test {

    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet();
    }

    @Test
    void testAddSingleCharacter() throws Exception {
        invokeAddMethod("a");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertEquals('a', ranges[0].getStart());
        assertEquals('a', ranges[0].getEnd());
        assertEquals(false, ranges[0].isNegated());
    }

    @Test
    void testAddNegatedCharacter() throws Exception {
        invokeAddMethod("^a");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertEquals('a', ranges[0].getStart());
        assertEquals('a', ranges[0].getEnd());
        assertEquals(true, ranges[0].isNegated());
    }

    @Test
    void testAddRange() throws Exception {
        invokeAddMethod("a-c");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertEquals('a', ranges[0].getStart());
        assertEquals('c', ranges[0].getEnd());
        assertEquals(false, ranges[0].isNegated());
    }

    @Test
    void testAddNegatedRange() throws Exception {
        invokeAddMethod("^a-c");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertEquals('a', ranges[0].getStart());
        assertEquals('c', ranges[0].getEnd());
        assertEquals(true, ranges[0].isNegated());
    }

    @Test
    void testAddMultipleElements() throws Exception {
        invokeAddMethod("a-b^c-d");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(3, ranges.length);
        assertEquals('a', ranges[0].getStart());
        assertEquals('b', ranges[0].getEnd());
        assertEquals(false, ranges[0].isNegated());
        assertEquals('c', ranges[1].getStart());
        assertEquals('c', ranges[1].getEnd());
        assertEquals(true, ranges[1].isNegated());
        assertEquals('d', ranges[2].getStart());
        assertEquals('d', ranges[2].getEnd());
        assertEquals(false, ranges[2].isNegated());
    }

    @Test
    void testAddNull() throws Exception {
        invokeAddMethod(null);
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(0, ranges.length);
    }

    private void invokeAddMethod(String str) throws Exception {
        Method method = CharSet.class.getDeclaredMethod("add", String.class);
        method.setAccessible(true);
        method.invoke(charSet, str);
    }
}
