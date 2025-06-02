package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.BitSet;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class CharsToNameCanonicalizer_createRoot_2_0_Test {

    @Test
    public void testCreateRoot_WithZeroSeed_UsesIdentityHashCode() {
        // Arrange
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        StreamReadConstraints defaultConstraints = StreamReadConstraints.defaults();
        Mockito.when(mockFactory.streamReadConstraints()).thenReturn(defaultConstraints);
        Mockito.when(mockFactory.getFactoryFeatures()).thenReturn(0);
        int expectedSeed = System.identityHashCode(mockFactory);
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, 0);
        // Assert
        assertNotNull(result);
        assertEquals(expectedSeed, result._seed);
    }

    @Test
    public void testCreateRoot_WithNonZeroSeed_UsesProvidedSeed() {
        // Arrange
        TokenStreamFactory mockFactory = Mockito.mock(TokenStreamFactory.class);
        StreamReadConstraints defaultConstraints = StreamReadConstraints.defaults();
        Mockito.when(mockFactory.streamReadConstraints()).thenReturn(defaultConstraints);
        Mockito.when(mockFactory.getFactoryFeatures()).thenReturn(0);
        int providedSeed = 12345;
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(mockFactory, providedSeed);
        // Assert
        assertNotNull(result);
        assertEquals(providedSeed, result._seed);
    }
}
