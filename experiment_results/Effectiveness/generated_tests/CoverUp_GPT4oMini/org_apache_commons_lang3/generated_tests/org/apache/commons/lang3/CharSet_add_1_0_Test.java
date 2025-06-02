package org.apache.commons.lang3;

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

class CharSet_add_1_0_Test {

    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet();
    }

    @Test
    void testAddSingleCharacter() throws Exception {
        invokeAddMethod(charSet, "a");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertTrue(ranges[0].getStart() == 'a' && ranges[0].getEnd() == 'a' && !ranges[0].isNegated());
    }

    @Test
    void testAddNegatedCharacter() throws Exception {
        invokeAddMethod(charSet, "^a");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertTrue(ranges[0].getStart() == 'a' && ranges[0].getEnd() == 'a' && ranges[0].isNegated());
    }

    @Test
    void testAddRange() throws Exception {
        invokeAddMethod(charSet, "a-c");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertTrue(ranges[0].getStart() == 'a' && ranges[0].getEnd() == 'c' && !ranges[0].isNegated());
    }

    @Test
    void testAddNegatedRange() throws Exception {
        invokeAddMethod(charSet, "^a-c");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(1, ranges.length);
        assertTrue(ranges[0].getStart() == 'a' && ranges[0].getEnd() == 'c' && ranges[0].isNegated());
    }

    @Test
    void testAddMultipleCharactersAndRanges() throws Exception {
        invokeAddMethod(charSet, "a^b-c");
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(3, ranges.length);
        assertTrue(ranges[0].getStart() == 'a' && ranges[0].getEnd() == 'a' && !ranges[0].isNegated());
        assertTrue(ranges[1].getStart() == 'b' && ranges[1].getEnd() == 'b' && ranges[1].isNegated());
        assertTrue(ranges[2].getStart() == 'c' && ranges[2].getEnd() == 'c' && !ranges[2].isNegated());
    }

    @Test
    void testAddNull() throws Exception {
        invokeAddMethod(charSet, null);
        CharRange[] ranges = charSet.getCharRanges();
        assertEquals(0, ranges.length);
    }

    private void invokeAddMethod(CharSet charSet, String str) throws Exception {
        Method method = CharSet.class.getDeclaredMethod("add", String.class);
        method.setAccessible(true);
        method.invoke(charSet, str);
    }
}
