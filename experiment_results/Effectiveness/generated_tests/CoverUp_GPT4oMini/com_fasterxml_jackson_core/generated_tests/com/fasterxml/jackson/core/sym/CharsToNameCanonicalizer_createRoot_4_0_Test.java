package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

class CharsToNameCanonicalizer_createRoot_4_0_Test {

    @Test
    void testCreateRootWithNullOwner() {
        // Test with a null TokenStreamFactory
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(null, 0);
        assertNotNull(result);
        // Seed should be set to identity hash code
        assertEquals(0, result._seed);
        assertEquals(StreamReadConstraints.defaults(), result._streamReadConstraints);
        assertEquals(0, result._factoryFeatures);
    }

    @Test
    void testCreateRootWithNonNullOwner() {
        // Test with a valid TokenStreamFactory
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        int seed = 12345;
        Mockito.when(mockFactory.streamReadConstraints()).thenReturn(StreamReadConstraints.defaults());
        Mockito.when(mockFactory.getFactoryFeatures()).thenReturn(seed);
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, seed);
        assertNotNull(result);
        assertEquals(seed, result._seed);
        assertEquals(mockFactory.streamReadConstraints(), result._streamReadConstraints);
        assertEquals(mockFactory.getFactoryFeatures(), result._factoryFeatures);
    }

    @Test
    void testCreateRootWithZeroSeed() {
        // Test with zero seed, should use identity hash code of owner
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, 0);
        assertNotNull(result);
        assertEquals(System.identityHashCode(mockFactory), result._seed);
    }
}
