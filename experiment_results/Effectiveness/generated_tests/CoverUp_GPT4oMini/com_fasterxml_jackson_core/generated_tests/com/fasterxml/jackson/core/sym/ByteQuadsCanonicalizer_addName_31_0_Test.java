package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonFactory;

class ByteQuadsCanonicalizer_addName_31_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    void setUp() {
        // Initialize the ByteQuadsCanonicalizer with a default size and seed
        // Using reflection to access the private constructor
        try {
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            canonicalizer = constructor.newInstance(64, 0);
        } catch (Exception e) {
            fail("Failed to initialize ByteQuadsCanonicalizer: " + e.getMessage());
        }
        // Setup the internal structures
        canonicalizer._hashArea = new int[256];
        canonicalizer._names = new String[64];
    }

    @Test
    void testAddNameWithSingleQuad() throws Exception {
        String name = "testName";
        int[] quads = { 1 };
        int qlen = 1;
        String result = invokeAddName(name, quads, qlen);
        assertEquals(name, result);
        assertEquals(1, canonicalizer._hashArea[0]);
        assertEquals(1, canonicalizer._hashArea[3]);
    }

    @Test
    void testAddNameWithTwoQuads() throws Exception {
        String name = "testName";
        int[] quads = { 1, 2 };
        int qlen = 2;
        String result = invokeAddName(name, quads, qlen);
        assertEquals(name, result);
        assertEquals(1, canonicalizer._hashArea[0]);
        assertEquals(2, canonicalizer._hashArea[1]);
        assertEquals(2, canonicalizer._hashArea[3]);
    }

    @Test
    void testAddNameWithThreeQuads() throws Exception {
        String name = "testName";
        int[] quads = { 1, 2, 3 };
        int qlen = 3;
        String result = invokeAddName(name, quads, qlen);
        assertEquals(name, result);
        assertEquals(1, canonicalizer._hashArea[0]);
        assertEquals(2, canonicalizer._hashArea[1]);
        assertEquals(3, canonicalizer._hashArea[2]);
        assertEquals(3, canonicalizer._hashArea[3]);
    }

    @Test
    void testAddNameWithLongName() throws Exception {
        String name = "testNameLong";
        int[] quads = { 1, 2, 3, 4, 5 };
        int qlen = 5;
        String result = invokeAddName(name, quads, qlen);
        assertEquals(name, result);
        // Check the hash area for the long name
        // Ensure it has resized
        assertTrue(canonicalizer._hashArea.length > 64);
    }

    private String invokeAddName(String name, int[] quads, int qlen) throws Exception {
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("addName", String.class, int[].class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(canonicalizer, name, quads, qlen);
    }
}
