package org.apache.commons.lang3;

import java.lang.reflect.Constructor;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

final class CharRange_equals_6_0_Test {

    private CharRange range1;

    private CharRange range2;

    private CharRange range3;

    private CharRange range4;

    @BeforeEach
    void setUp() {
        try {
            range1 = createCharRange('a', 'z', false);
            range2 = createCharRange('a', 'z', false);
            range3 = createCharRange('a', 'z', true);
            range4 = createCharRange('b', 'y', false);
        } catch (Exception e) {
            fail("Setup failed: " + e.getMessage());
        }
    }

    private CharRange createCharRange(char start, char end, boolean negated) {
        try {
            Constructor<CharRange> constructor = CharRange.class.getDeclaredConstructor(char.class, char.class, boolean.class);
            constructor.setAccessible(true);
            return constructor.newInstance(start, end, negated);
        } catch (Exception e) {
            fail("Failed to create CharRange: " + e.getMessage());
            // This line will never be reached due to fail above
            return null;
        }
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(range1.equals(range1));
    }

    @Test
    void testEquals_Null() {
        assertFalse(range1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(range1.equals("Not a CharRange"));
    }

    @Test
    void testEquals_SameValues() {
        assertTrue(range1.equals(range2));
    }

    @Test
    void testEquals_DifferentNegation() {
        assertFalse(range1.equals(range3));
    }

    @Test
    void testEquals_DifferentStart() {
        assertFalse(range1.equals(range4));
    }

    @Test
    void testEquals_DifferentEnd() {
        CharRange range5 = createCharRange('a', 'y', false);
        assertFalse(range1.equals(range5));
    }

    @Test
    void testEquals_EmptyRanges() {
        CharRange emptyRange1 = createCharRange('\0', '\0', false);
        CharRange emptyRange2 = createCharRange('\0', '\0', false);
        assertTrue(emptyRange1.equals(emptyRange2));
    }
}
