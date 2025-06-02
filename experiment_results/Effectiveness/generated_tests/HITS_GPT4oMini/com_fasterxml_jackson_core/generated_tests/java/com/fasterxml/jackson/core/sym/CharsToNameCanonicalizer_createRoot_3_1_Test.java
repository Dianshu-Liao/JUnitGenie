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

public class CharsToNameCanonicalizer_createRoot_3_1_Test {

    @Test
    public void testCreateRootWithNullOwner() {
        // Arrange
        TokenStreamFactory owner = null;
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(owner);
        // Assert
        assertNotNull(result);
        // Seed should not be zero when owner is null
        assertNotEquals(0, result._seed);
        assertNotNull(result._streamReadConstraints);
        assertEquals(StreamReadConstraints.DEFAULT_MAX_DEPTH, result._streamReadConstraints.getMaxNestingDepth());
        assertEquals(StreamReadConstraints.DEFAULT_MAX_DOC_LEN, result._streamReadConstraints.getMaxDocumentLength());
    }

    @Test
    public void testCreateRootWithValidOwner() {
        // Arrange
        TokenStreamFactory owner = Mockito.mock(TokenStreamFactory.class);
        // Use default constraints
        StreamReadConstraints constraints = StreamReadConstraints.defaults();
        Mockito.when(owner.streamReadConstraints()).thenReturn(constraints);
        Mockito.when(owner.getFactoryFeatures()).thenReturn(1);
        // Act
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(owner);
        // Assert
        assertNotNull(result);
        assertNotNull(result._streamReadConstraints);
        assertEquals(constraints.getMaxNestingDepth(), result._streamReadConstraints.getMaxNestingDepth());
        assertEquals(1, result._factoryFeatures);
    }
}
