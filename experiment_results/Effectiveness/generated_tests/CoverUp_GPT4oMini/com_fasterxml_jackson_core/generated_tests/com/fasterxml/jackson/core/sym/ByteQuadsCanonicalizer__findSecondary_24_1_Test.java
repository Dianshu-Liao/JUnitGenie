package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.util.InternCache;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ByteQuadsCanonicalizer__findSecondary_24_1_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        // Initialize with a size that is a power of 2, e.g., 64
        canonicalizer = createCanonicalizer(64, 0);
        // Mock the internal state for testing
        canonicalizer._hashArea = new int[] { 1, 2, 3, 3, 4, 5, 6, 3, 7, 8, 9, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 10, 11, 12, 3, 0, 0, 0 };
        canonicalizer._names = new String[] { "name1", "name2", "name3", "name4", "name5", "name6", "name7", "name8", "name9", "name10" };
        canonicalizer._tertiaryStart = 0;
        canonicalizer._tertiaryShift = 2;
        canonicalizer._spilloverEnd = 20;
    }

    private ByteQuadsCanonicalizer createCanonicalizer(int sz, int seed) {
        try {
            // Use reflection to call the private constructor
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(sz, seed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testFindSecondary_Found() throws Exception {
        String result = invokeFindSecondary(0, 1, 2, 3);
        assertEquals("name1", result);
    }

    @Test
    public void testFindSecondary_NotFound() throws Exception {
        String result = invokeFindSecondary(0, 99, 100, 101);
        assertNull(result);
    }

    @Test
    public void testFindSecondary_SpilloverFound() throws Exception {
        String result = invokeFindSecondary(0, 10, 11, 12);
        assertEquals("name10", result);
    }

    @Test
    public void testFindSecondary_SpilloverNotFound() throws Exception {
        String result = invokeFindSecondary(0, 0, 0, 0);
        assertNull(result);
    }

    private String invokeFindSecondary(int origOffset, int q1, int q2, int q3) throws Exception {
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_findSecondary", int.class, int.class, int.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(canonicalizer, origOffset, q1, q2, q3);
    }
}
