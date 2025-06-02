package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;

class ByteQuadsCanonicalizer_addName_30_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    void setUp() {
        // Initialize ByteQuadsCanonicalizer with a default size and seed
        try {
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            canonicalizer = constructor.newInstance(64, 0);
        } catch (Exception e) {
            fail("Failed to create ByteQuadsCanonicalizer instance: " + e.getMessage());
        }
    }

    @Test
    void testAddName_withInterning() throws StreamConstraintsException {
        // Arrange
        String name = "testName";
        int q1 = 1, q2 = 2, q3 = 3;
        // Set the _interner to use the InternCache
        try {
            Field internerField = ByteQuadsCanonicalizer.class.getDeclaredField("_interner");
            internerField.setAccessible(true);
            internerField.set(canonicalizer, InternCache.instance);
        } catch (Exception e) {
            fail("Failed to set _interner field: " + e.getMessage());
        }
        // Act
        String result = canonicalizer.addName(name, q1, q2, q3);
        // Assert
        assertEquals(name, result);
    }

    @Test
    void testAddName_withoutInterning() throws StreamConstraintsException {
        // Arrange
        String name = "anotherName";
        int q1 = 4, q2 = 5, q3 = 6;
        // Set the _interner to null
        try {
            Field internerField = ByteQuadsCanonicalizer.class.getDeclaredField("_interner");
            internerField.setAccessible(true);
            internerField.set(canonicalizer, null);
        } catch (Exception e) {
            fail("Failed to set _interner field: " + e.getMessage());
        }
        // Act
        String result = canonicalizer.addName(name, q1, q2, q3);
        // Assert
        assertEquals(name, result);
    }

    @Test
    void testAddName_whenHashShared() throws StreamConstraintsException {
        // Arrange
        String name = "sharedName";
        int q1 = 7, q2 = 8, q3 = 9;
        // Act
        String result = canonicalizer.addName(name, q1, q2, q3);
        // Assert
        assertEquals(name, result);
    }

    @Test
    void testAddName_whenCountIsZero() {
        // Arrange
        String name = "errorName";
        int q1 = 10, q2 = 11, q3 = 12;
        // Set the _count to 0 to simulate the error case
        try {
            Field countField = ByteQuadsCanonicalizer.class.getDeclaredField("_count");
            countField.setAccessible(true);
            countField.set(canonicalizer, 0);
        } catch (Exception e) {
            fail("Failed to set _count field: " + e.getMessage());
        }
        // Act & Assert
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            canonicalizer.addName(name, q1, q2, q3);
        });
        assertEquals("Internal error: Cannot add names to Root symbol table", thrown.getMessage());
    }

    @Test
    void testAddName_whenHashAreaFull() {
        // Arrange
        String name = "overflowName";
        int q1 = 13, q2 = 14, q3 = 15;
        // Simulate a full hash area by setting the _spilloverEnd to a high value
        try {
            Field spilloverEndField = ByteQuadsCanonicalizer.class.getDeclaredField("_spilloverEnd");
            spilloverEndField.setAccessible(true);
            spilloverEndField.set(canonicalizer, Integer.MAX_VALUE);
        } catch (Exception e) {
            fail("Failed to set _spilloverEnd field: " + e.getMessage());
        }
        // Act & Assert
        StreamConstraintsException thrown = assertThrows(StreamConstraintsException.class, () -> {
            canonicalizer.addName(name, q1, q2, q3);
        });
        assertNotNull(thrown);
    }
}
