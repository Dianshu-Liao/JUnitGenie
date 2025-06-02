package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ByteQuadsCanonicalizer_addName_29_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    void setUp() {
        // Create an instance of ByteQuadsCanonicalizer using reflection
        try {
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            canonicalizer = constructor.newInstance(64, 0);
        } catch (Exception e) {
            fail("Failed to create ByteQuadsCanonicalizer instance: " + e.getMessage());
        }
        // Initialize hash area
        canonicalizer._hashArea = new int[64 * 4];
        // Initialize names array
        canonicalizer._names = new String[64];
        // Set count to 0
        canonicalizer._count = 0;
        // Set spillover end
        canonicalizer._spilloverEnd = 64 * 4;
    }

    @Test
    void testAddName_withValidInput() throws Exception {
        String name = "testName";
        int q1 = 1;
        int q2 = 2;
        // Invoke the addName method using reflection
        Method addNameMethod = ByteQuadsCanonicalizer.class.getDeclaredMethod("addName", String.class, int.class, int.class);
        addNameMethod.setAccessible(true);
        String result = (String) addNameMethod.invoke(canonicalizer, name, q1, q2);
        // Assertions
        assertEquals(name, result);
        assertEquals(1, canonicalizer._count);
        assertEquals(name, canonicalizer._names[0]);
        assertEquals(q1, canonicalizer._hashArea[0]);
        assertEquals(q2, canonicalizer._hashArea[1]);
    }

    @Test
    void testAddName_withInternCache() throws Exception {
        // Create a mock for InternCache
        InternCache mockInternCache = mock(InternCache.class);
        when(mockInternCache.intern(anyString())).thenAnswer(invocation -> invocation.getArgument(0));
        // Set the interner using reflection
        try {
            Field internerField = ByteQuadsCanonicalizer.class.getDeclaredField("_interner");
            internerField.setAccessible(true);
            internerField.set(canonicalizer, mockInternCache);
        } catch (Exception e) {
            fail("Failed to set _interner: " + e.getMessage());
        }
        String name = "testName";
        int q1 = 1;
        int q2 = 2;
        // Invoke the addName method using reflection
        Method addNameMethod = ByteQuadsCanonicalizer.class.getDeclaredMethod("addName", String.class, int.class, int.class);
        addNameMethod.setAccessible(true);
        String result = (String) addNameMethod.invoke(canonicalizer, name, q1, q2);
        // Assertions
        assertEquals(name, result);
        assertEquals(1, canonicalizer._count);
        assertEquals(name, canonicalizer._names[0]);
        assertEquals(q1, canonicalizer._hashArea[0]);
        assertEquals(q2, canonicalizer._hashArea[1]);
    }

    @Test
    void testAddName_withCollisions() throws Exception {
        String name1 = "name1";
        String name2 = "name2";
        int q1 = 1;
        int q2 = 2;
        // Add first name
        Method addNameMethod = ByteQuadsCanonicalizer.class.getDeclaredMethod("addName", String.class, int.class, int.class);
        addNameMethod.setAccessible(true);
        addNameMethod.invoke(canonicalizer, name1, q1, q2);
        // Change hash area to simulate collision
        // Simulate existing entry
        canonicalizer._hashArea[0] = q1;
        // Simulate existing entry
        canonicalizer._hashArea[1] = q2;
        // Add second name
        String result = (String) addNameMethod.invoke(canonicalizer, name2, q1, q2);
        // Assertions
        assertEquals(name2, result);
        assertEquals(2, canonicalizer._count);
        // Ensure the new name is added
        assertEquals(name2, canonicalizer._names[0]);
    }
}
