package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

class ByteQuadsCanonicalizer__checkNeedForRehash_36_2_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    void setUp() throws Exception {
        // Use reflection to access the private constructor
        Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
        constructor.setAccessible(true);
        canonicalizer = constructor.newInstance(64, 0);
    }

    private boolean invokeCheckNeedForRehash() throws Exception {
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_checkNeedForRehash");
        method.setAccessible(true);
        return (boolean) method.invoke(canonicalizer);
    }

    @Test
    void testCheckNeedForRehashWhenCountIsLessThanHalf() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 30;
        canonicalizer._spilloverEnd = 0;
        assertFalse(invokeCheckNeedForRehash());
    }

    @Test
    void testCheckNeedForRehashWhenCountIsGreaterThanHalfAndNoSpillovers() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 33;
        canonicalizer._spilloverEnd = 0;
        assertTrue(invokeCheckNeedForRehash());
    }

    @Test
    void testCheckNeedForRehashWhenCountIsGreaterThanHalfWithSpillovers() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 33;
        canonicalizer._spilloverEnd = 10;
        assertTrue(invokeCheckNeedForRehash());
    }

    @Test
    void testCheckNeedForRehashWhenCountIsExactlyFourFifthsOfHashSize() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 51;
        canonicalizer._spilloverEnd = 2;
        assertTrue(invokeCheckNeedForRehash());
    }

    @Test
    void testCheckNeedForRehashWhenCountIsLessThanFourFifthsButWithSpillovers() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 50;
        canonicalizer._spilloverEnd = 10;
        assertTrue(invokeCheckNeedForRehash());
    }

    @Test
    void testCheckNeedForRehashWhenNoSpilloversAndCountIsExactlyHalf() throws Exception {
        canonicalizer._hashSize = 64;
        canonicalizer._count = 32;
        canonicalizer._spilloverEnd = 0;
        assertFalse(invokeCheckNeedForRehash());
    }
}
