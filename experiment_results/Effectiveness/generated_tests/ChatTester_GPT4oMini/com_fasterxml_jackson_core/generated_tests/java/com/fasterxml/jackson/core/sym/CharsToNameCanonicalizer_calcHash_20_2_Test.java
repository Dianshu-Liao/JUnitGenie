package com.fasterxml.jackson.core.sym;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CharsToNameCanonicalizer_calcHash_20_2_Test {

    private CharsToNameCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        StreamReadConstraints constraints = StreamReadConstraints.defaults();
        int factoryFeatures = 0;
        int seed = 1;
        // Fixed line: create a new instance of CharsToNameCanonicalizer using the correct constructor
        canonicalizer = CharsToNameCanonicalizer.createRoot();
    }

    @Test
    public void testCalcHash_NonZeroHash() {
        char[] buffer = { 'a', 'b', 'c' };
        int start = 0;
        int len = 3;
        int expectedHash = (1 * CharsToNameCanonicalizer.HASH_MULT + 'a') * CharsToNameCanonicalizer.HASH_MULT + 'b';
        expectedHash = (expectedHash * CharsToNameCanonicalizer.HASH_MULT) + 'c';
        int result = invokeCalcHash(buffer, start, len);
        assertEquals(expectedHash, result);
    }

    @Test
    public void testCalcHash_ZeroHash() {
        char[] buffer = { '\0', 'b', 'c' };
        int start = 0;
        int len = 3;
        int result = invokeCalcHash(buffer, start, len);
        assertEquals(1, result);
    }

    @Test
    public void testCalcHash_EmptyBuffer() {
        char[] buffer = {};
        int start = 0;
        int len = 0;
        int result = invokeCalcHash(buffer, start, len);
        assertEquals(1, result);
    }

    @Test
    public void testCalcHash_SingleCharacter() {
        char[] buffer = { 'x' };
        int start = 0;
        int len = 1;
        int expectedHash = (1 * CharsToNameCanonicalizer.HASH_MULT) + 'x';
        int result = invokeCalcHash(buffer, start, len);
        assertEquals(expectedHash, result);
    }

    private int invokeCalcHash(char[] buffer, int start, int len) {
        try {
            java.lang.reflect.Method method = CharsToNameCanonicalizer.class.getDeclaredMethod("calcHash", char[].class, int.class, int.class);
            method.setAccessible(true);
            return (int) method.invoke(canonicalizer, buffer, start, len);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
