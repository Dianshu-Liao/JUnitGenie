package org.apache.commons.lang3;

import java.util.Set;
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
import java.util.stream.Stream;

class CharSet_add_1_0_Test {

    @Test
    void testAddSingleCharacter() {
        CharSet charSet = new CharSet();
        charSet.add("a");
        Set<CharRange> ranges = getCharRanges(charSet);
        assertEquals(1, ranges.size());
        CharRange range = ranges.iterator().next();
        assertEquals('a', range.getStart());
        assertEquals('a', range.getEnd());
        assertFalse(range.isNegated());
    }

    @Test
    void testAddNegatedCharacter() {
        CharSet charSet = new CharSet();
        charSet.add("^a");
        Set<CharRange> ranges = getCharRanges(charSet);
        assertEquals(1, ranges.size());
        CharRange range = ranges.iterator().next();
        assertEquals('a', range.getStart());
        assertEquals('a', range.getEnd());
        assertTrue(range.isNegated());
    }

    @Test
    void testAddCharacterRange() {
        CharSet charSet = new CharSet();
        charSet.add("a-c");
        Set<CharRange> ranges = getCharRanges(charSet);
        assertEquals(1, ranges.size());
        CharRange range = ranges.iterator().next();
        assertEquals('a', range.getStart());
        assertEquals('c', range.getEnd());
        assertFalse(range.isNegated());
    }

    @Test
    void testAddNegatedRange() {
        CharSet charSet = new CharSet();
        charSet.add("^a-c");
        Set<CharRange> ranges = getCharRanges(charSet);
        assertEquals(1, ranges.size());
        CharRange range = ranges.iterator().next();
        assertEquals('a', range.getStart());
        assertEquals('c', range.getEnd());
        assertTrue(range.isNegated());
    }

    @Test
    void testAddMultipleCharactersAndRanges() {
        CharSet charSet = new CharSet();
        charSet.add("a");
        charSet.add("b");
        charSet.add("c");
        charSet.add("d-f");
        Set<CharRange> ranges = getCharRanges(charSet);
        assertEquals(4, ranges.size());
        assertTrue(ranges.contains(CharRange.is('a')));
        assertTrue(ranges.contains(CharRange.is('b')));
        assertTrue(ranges.contains(CharRange.is('c')));
        assertTrue(ranges.contains(CharRange.isIn('d', 'f')));
    }

    private Set<CharRange> getCharRanges(CharSet charSet) {
        // Using reflection or another method to access the private 'set' field
        try {
            java.lang.reflect.Field field = CharSet.class.getDeclaredField("set");
            field.setAccessible(true);
            return (Set<CharRange>) field.get(charSet);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
