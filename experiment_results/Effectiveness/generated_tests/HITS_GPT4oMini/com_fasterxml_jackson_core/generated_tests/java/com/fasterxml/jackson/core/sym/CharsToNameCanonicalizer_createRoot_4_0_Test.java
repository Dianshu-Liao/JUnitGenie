package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
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
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class CharsToNameCanonicalizer_createRoot_4_0_Test {

    @Test
    public void testCreateRootWithNonZeroSeed() {
        // Arrange
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        int seed = 12345;
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, seed);
        // Assert
        assertNotNull(result);
        assertEquals(seed, result._seed);
    }

    @Test
    public void testCreateRootWithZeroSeed() {
        // Arrange
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        Mockito.when(mockFactory.streamReadConstraints()).thenReturn(StreamReadConstraints.defaults());
        Mockito.when(mockFactory.getFactoryFeatures()).thenReturn(0);
        int seed = 0;
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, seed);
        // Assert
        assertNotNull(result);
        // Verify that the seed is set to the identity hash code of the mockFactory
        assertEquals(System.identityHashCode(mockFactory), result._seed);
    }

    @Test
    public void testCreateRootWithNullFactory() {
        // Arrange
        TokenStreamFactory mockFactory = null;
        int seed = 0;
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, seed);
        // Assert
        assertNotNull(result);
        // Verify that the seed is set to the identity hash code of the null factory (which is not applicable, should default)
        // Identity hash code of null is not defined, but we check that it's not zero
        assertEquals(System.identityHashCode(mockFactory), result._seed);
        assertEquals(StreamReadConstraints.defaults(), result._streamReadConstraints);
        assertEquals(0, result._factoryFeatures);
    }
}
