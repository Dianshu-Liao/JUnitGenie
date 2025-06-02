package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.StreamReadConstraints;
import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharsToNameCanonicalizer_calcHash_21_0_Test {

    private CharsToNameCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() throws Exception {
        StreamReadConstraints constraints = createStreamReadConstraints();
        canonicalizer = createCharsToNameCanonicalizer(constraints, 0, 0);
    }

    @Test
    public void testCalcHash_withNormalString() throws Exception {
        String key = "test";
        int expectedHash = calculateExpectedHash(key);
        int actualHash = invokeCalcHash(key);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testCalcHash_withEmptyString() throws Exception {
        String key = "";
        int actualHash = invokeCalcHash(key);
        assertEquals(1, actualHash);
    }

    @Test
    public void testCalcHash_withStringLeadingToZeroHash() throws Exception {
        String key = "0";
        int actualHash = invokeCalcHash(key);
        assertEquals(1, actualHash);
    }

    private int invokeCalcHash(String key) throws Exception {
        Method method = CharsToNameCanonicalizer.class.getDeclaredMethod("calcHash", String.class);
        method.setAccessible(true);
        return (int) method.invoke(canonicalizer, key);
    }

    private int calculateExpectedHash(String key) {
        final int len = key.length();
        int hash = 0;
        for (int i = 0; i < len; ++i) {
            hash = (hash * CharsToNameCanonicalizer.HASH_MULT) + key.charAt(i);
        }
        return (hash == 0) ? 1 : hash;
    }

    private StreamReadConstraints createStreamReadConstraints() throws Exception {
        // Use reflection to access the protected constructor
        Class<?> clazz = StreamReadConstraints.class;
        return (StreamReadConstraints) clazz.getDeclaredConstructor(int.class, long.class, int.class, int.class, int.class, long.class).newInstance(1000, 0L, 1000, 20000000, 50000, 0L);
    }

    private CharsToNameCanonicalizer createCharsToNameCanonicalizer(StreamReadConstraints constraints, int factoryFeatures, int seed) throws Exception {
        // Use reflection to access the private constructor
        Class<?> clazz = CharsToNameCanonicalizer.class;
        return (CharsToNameCanonicalizer) clazz.getDeclaredConstructor(StreamReadConstraints.class, int.class, int.class).newInstance(constraints, factoryFeatures, seed);
    }
}
