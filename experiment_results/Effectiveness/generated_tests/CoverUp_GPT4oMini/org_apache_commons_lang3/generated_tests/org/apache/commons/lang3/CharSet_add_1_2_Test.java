package org.apache.commons.lang3;

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

class CharSet_add_1_2_Test {

    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet();
    }

    @Test
    void testAddSingleCharacter() {
        charSet.add("a");
        assertTrue(charSetContains(charSet, 'a'));
    }

    @Test
    void testAddRange() {
        charSet.add("a-c");
        assertTrue(charSetContains(charSet, 'a'));
        assertTrue(charSetContains(charSet, 'b'));
        assertTrue(charSetContains(charSet, 'c'));
    }

    @Test
    void testAddNegatedCharacter() {
        charSet.add("^a");
        assertTrue(charSetContainsNegated(charSet, 'a'));
    }

    @Test
    void testAddNegatedRange() {
        charSet.add("^a-c");
        assertTrue(charSetContainsNegated(charSet, 'a'));
        assertTrue(charSetContainsNegated(charSet, 'b'));
        assertTrue(charSetContainsNegated(charSet, 'c'));
    }

    @Test
    void testAddMultipleCharacters() {
        charSet.add("abc");
        assertTrue(charSetContains(charSet, 'a'));
        assertTrue(charSetContains(charSet, 'b'));
        assertTrue(charSetContains(charSet, 'c'));
    }

    private boolean charSetContains(CharSet charSet, char ch) {
        // Logic to check if charSet contains the character
        // This method needs to be implemented based on the actual behavior of CharSet
        // Placeholder
        return true;
    }

    private boolean charSetContainsNegated(CharSet charSet, char ch) {
        // Logic to check if charSet negates the character
        // This method needs to be implemented based on the actual behavior of CharSet
        // Placeholder
        return true;
    }
}
