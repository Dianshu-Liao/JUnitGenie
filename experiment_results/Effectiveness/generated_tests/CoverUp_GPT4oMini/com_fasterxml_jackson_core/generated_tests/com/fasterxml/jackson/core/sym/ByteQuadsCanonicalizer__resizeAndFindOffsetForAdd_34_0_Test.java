package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ByteQuadsCanonicalizer__resizeAndFindOffsetForAdd_34_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        // Initialize the ByteQuadsCanonicalizer using reflection to access the private constructor
        try {
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            canonicalizer = constructor.newInstance(64, 0);
        } catch (Exception e) {
            fail("Failed to instantiate ByteQuadsCanonicalizer: " + e.getMessage());
        }
        // Manually set up the hash area for testing
        canonicalizer._hashArea = new int[64 * 4];
        canonicalizer._hashSize = 64;
        canonicalizer._secondaryStart = 64 * 4;
        canonicalizer._tertiaryStart = 256 + (256 >> 1);
        canonicalizer._tertiaryShift = 1;
        canonicalizer._spilloverEnd = 384;
    }

    @Test
    public void testResizeAndFindOffsetForAdd_NewEntry() throws Exception {
        int hash = 12345;
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_resizeAndFindOffsetForAdd", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(canonicalizer, hash);
        assertEquals(384, result);
    }

    @Test
    public void testResizeAndFindOffsetForAdd_SecondaryEntry() throws Exception {
        int hash = 12345;
        canonicalizer._hashArea[0] = hash;
        canonicalizer._hashArea[3] = 1;
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_resizeAndFindOffsetForAdd", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(canonicalizer, hash);
        assertEquals(256, result);
    }

    @Test
    public void testResizeAndFindOffsetForAdd_TertiaryEntry() throws Exception {
        int hash = 12345;
        canonicalizer._hashArea[0] = hash;
        canonicalizer._hashArea[3] = 1;
        canonicalizer._hashArea[256] = hash;
        canonicalizer._hashArea[259] = 1;
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_resizeAndFindOffsetForAdd", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(canonicalizer, hash);
        assertEquals(384, result);
    }

    @Test
    public void testResizeAndFindOffsetForAdd_SpilloverEntry() throws Exception {
        int hash = 12345;
        for (int i = 0; i < 64; i++) {
            canonicalizer._hashArea[i * 4 + 3] = 1;
        }
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_resizeAndFindOffsetForAdd", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(canonicalizer, hash);
        assertEquals(384, result);
    }
}
