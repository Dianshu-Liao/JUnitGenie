package com.fasterxml.jackson.core.sym;

import java.util.concurrent.atomic.AtomicReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

class CharsToNameCanonicalizer_createRoot_4_0_Test {

    private TokenStreamFactory mockTokenStreamFactory;

    private StreamReadConstraints mockStreamReadConstraints;

    @BeforeEach
    void setUp() {
        mockTokenStreamFactory = mock(TokenStreamFactory.class);
        mockStreamReadConstraints = mock(StreamReadConstraints.class);
    }

    @Test
    void testCreateRootWithNullOwner() {
        // Arrange
        when(mockTokenStreamFactory.streamReadConstraints()).thenReturn(mockStreamReadConstraints);
        when(mockTokenStreamFactory.getFactoryFeatures()).thenReturn(0);
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(null, 0);
        // Assert
        assertNotNull(result);
        assertEquals(0, result._factoryFeatures);
        assertTrue(result._canonicalize);
    }

    @Test
    void testCreateRootWithOwner() {
        // Arrange
        int seed = 12345;
        when(mockTokenStreamFactory.streamReadConstraints()).thenReturn(mockStreamReadConstraints);
        when(mockTokenStreamFactory.getFactoryFeatures()).thenReturn(10);
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockTokenStreamFactory, seed);
        // Assert
        assertNotNull(result);
        assertEquals(10, result._factoryFeatures);
        assertEquals(System.identityHashCode(mockTokenStreamFactory), result._seed);
    }

    @Test
    void testCreateRootWithZeroSeed() {
        // Arrange
        int seed = 0;
        when(mockTokenStreamFactory.streamReadConstraints()).thenReturn(mockStreamReadConstraints);
        when(mockTokenStreamFactory.getFactoryFeatures()).thenReturn(5);
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockTokenStreamFactory, seed);
        // Assert
        assertNotNull(result);
        assertEquals(5, result._factoryFeatures);
        assertEquals(System.identityHashCode(mockTokenStreamFactory), result._seed);
    }
}
