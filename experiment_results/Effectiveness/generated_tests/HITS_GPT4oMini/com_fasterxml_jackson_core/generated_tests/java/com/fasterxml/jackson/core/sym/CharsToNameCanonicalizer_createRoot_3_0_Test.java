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

public class CharsToNameCanonicalizer_createRoot_3_0_Test {

    @Test
    public void testCreateRootWithNullOwner() {
        // Test case when owner is null
        TokenStreamFactory owner = null;
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(owner);
        assertNotNull(result);
        // Check if seed is initialized to 0
        assertEquals(0, result._seed);
        // Check if default constraints are set
        assertNotNull(result._streamReadConstraints);
    }

    @Test
    public void testCreateRootWithNonNullOwner() {
        // Test case when owner is not null
        TokenStreamFactory owner = Mockito.mock(TokenStreamFactory.class);
        Mockito.when(owner.streamReadConstraints()).thenReturn(StreamReadConstraints.defaults());
        Mockito.when(owner.getFactoryFeatures()).thenReturn(0);
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(owner);
        assertNotNull(result);
        // Check if constraints are set from owner
        assertNotNull(result._streamReadConstraints);
        // Check if factory features are set correctly
        assertEquals(0, result._factoryFeatures);
    }

    @Test
    public void testCreateRootWithZeroSeed() {
        // Test case when seed is zero
        TokenStreamFactory owner = Mockito.mock(TokenStreamFactory.class);
        Mockito.when(owner.streamReadConstraints()).thenReturn(StreamReadConstraints.defaults());
        Mockito.when(owner.getFactoryFeatures()).thenReturn(0);
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(owner, 0);
        assertNotNull(result);
        // Check if constraints are set from owner
        assertNotNull(result._streamReadConstraints);
        // Check if seed is set to identity hash code of owner
        assertNotEquals(0, result._seed);
    }
}
