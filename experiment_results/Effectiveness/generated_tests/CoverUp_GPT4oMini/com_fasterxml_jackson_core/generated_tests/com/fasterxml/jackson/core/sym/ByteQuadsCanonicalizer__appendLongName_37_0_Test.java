package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;

public class ByteQuadsCanonicalizer__appendLongName_37_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        // Initialize ByteQuadsCanonicalizer with a default size and seed
        canonicalizer = createByteQuadsCanonicalizer(64, 0);
        // Initialize _hashArea to prevent NullPointerException
        canonicalizer._hashArea = new int[64];
        // Initialize _longNameOffset
        canonicalizer._longNameOffset = 0;
    }

    private ByteQuadsCanonicalizer createByteQuadsCanonicalizer(int size, int seed) {
        try {
            // Use reflection to access the private constructor
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            return constructor.newInstance(size, seed);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testAppendLongName_Success() throws Exception {
        int[] quads = { 1, 2, 3, 4 };
        int qlen = quads.length;
        // Invoke the private method _appendLongName using reflection
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_appendLongName", int[].class, int.class);
        method.setAccessible(true);
        int startOffset = (int) method.invoke(canonicalizer, quads, qlen);
        // Verify the long name offset and the contents of the hash area
        assertEquals(0, startOffset);
        assertArrayEquals(quads, Arrays.copyOfRange(canonicalizer._hashArea, startOffset, startOffset + qlen));
        assertEquals(qlen, canonicalizer._longNameOffset);
    }

    @Test
    public void testAppendLongName_Overflow() throws Exception {
        int[] quads = { 1, 2, 3, 4 };
        int qlen = quads.length;
        // Set _longNameOffset to a value that will cause overflow
        canonicalizer._longNameOffset = Integer.MAX_VALUE - 3;
        // Invoke the private method and expect an exception
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_appendLongName", int[].class, int.class);
        method.setAccessible(true);
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            method.invoke(canonicalizer, quads, qlen);
        });
        String expectedMessage = String.format("Internal error: long name offset overflow; start=%s, qlen=%s", canonicalizer._longNameOffset, qlen);
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    public void testAppendLongName_ResizeHashArea() throws Exception {
        int initialSize = canonicalizer._hashArea.length;
        int[] quads = new int[initialSize + 10];
        // Fill with sample data
        Arrays.fill(quads, 1);
        int qlen = quads.length;
        // Invoke the private method
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_appendLongName", int[].class, int.class);
        method.setAccessible(true);
        int startOffset = (int) method.invoke(canonicalizer, quads, qlen);
        // Verify that the hash area has resized
        assertTrue(canonicalizer._hashArea.length > initialSize);
        assertEquals(0, startOffset);
        assertArrayEquals(quads, Arrays.copyOfRange(canonicalizer._hashArea, startOffset, startOffset + qlen));
        assertEquals(qlen, canonicalizer._longNameOffset);
    }
}
