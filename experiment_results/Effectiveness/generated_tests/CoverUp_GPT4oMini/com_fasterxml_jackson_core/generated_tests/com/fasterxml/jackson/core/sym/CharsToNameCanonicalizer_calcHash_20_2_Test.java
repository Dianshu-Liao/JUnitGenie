package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.StreamReadConstraints;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
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

public class CharsToNameCanonicalizer_calcHash_20_2_Test {

    private CharsToNameCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() throws Exception {
        StreamReadConstraints constraints = createStreamReadConstraints();
        canonicalizer = createCharsToNameCanonicalizer(constraints, 0, 0);
    }

    @Test
    public void testCalcHash_NonEmptyBuffer() throws Exception {
        char[] buffer = { 'a', 'b', 'c' };
        int start = 0;
        int len = 3;
        int expectedHash = (0 * CharsToNameCanonicalizer.HASH_MULT + 'a') * CharsToNameCanonicalizer.HASH_MULT + 'b';
        expectedHash = (expectedHash * CharsToNameCanonicalizer.HASH_MULT + 'c');
        expectedHash = (expectedHash == 0) ? 1 : expectedHash;
        int actualHash = invokeCalcHash(buffer, start, len);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testCalcHash_EmptyBuffer() throws Exception {
        char[] buffer = {};
        int start = 0;
        int len = 0;
        int actualHash = invokeCalcHash(buffer, start, len);
        assertEquals(1, actualHash);
    }

    @Test
    public void testCalcHash_SingleCharacter() throws Exception {
        char[] buffer = { 'z' };
        int start = 0;
        int len = 1;
        int expectedHash = (0 * CharsToNameCanonicalizer.HASH_MULT + 'z');
        expectedHash = (expectedHash == 0) ? 1 : expectedHash;
        int actualHash = invokeCalcHash(buffer, start, len);
        assertEquals(expectedHash, actualHash);
    }

    @Test
    public void testCalcHash_NegativeSeed() throws Exception {
        char[] buffer = { 'a', 'b', 'c' };
        int start = 0;
        int len = 3;
        int negativeSeed = -1;
        StreamReadConstraints constraints = createStreamReadConstraints();
        canonicalizer = createCharsToNameCanonicalizer(constraints, 0, negativeSeed);
        int expectedHash = (negativeSeed * CharsToNameCanonicalizer.HASH_MULT + 'a') * CharsToNameCanonicalizer.HASH_MULT + 'b';
        expectedHash = (expectedHash * CharsToNameCanonicalizer.HASH_MULT + 'c');
        expectedHash = (expectedHash == 0) ? 1 : expectedHash;
        int actualHash = invokeCalcHash(buffer, start, len);
        assertEquals(expectedHash, actualHash);
    }

    private int invokeCalcHash(char[] buffer, int start, int len) throws Exception {
        Method method = CharsToNameCanonicalizer.class.getDeclaredMethod("calcHash", char[].class, int.class, int.class);
        method.setAccessible(true);
        return (int) method.invoke(canonicalizer, buffer, start, len);
    }

    private StreamReadConstraints createStreamReadConstraints() throws Exception {
        // Using reflection to access the protected constructor
        return (StreamReadConstraints) StreamReadConstraints.class.getDeclaredConstructor(int.class, long.class, int.class, int.class, int.class, long.class).newInstance(1000, 0L, 1000, 20000000, 50000, 0L);
    }

    private CharsToNameCanonicalizer createCharsToNameCanonicalizer(StreamReadConstraints constraints, int factoryFeatures, int seed) throws Exception {
        // Using reflection to access the private constructor
        return (CharsToNameCanonicalizer) CharsToNameCanonicalizer.class.getDeclaredConstructor(StreamReadConstraints.class, int.class, int.class).newInstance(constraints, factoryFeatures, seed);
    }
}
