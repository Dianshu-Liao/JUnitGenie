package com.fasterxml.jackson.core.sym;

import com.fasterxml.jackson.core.StreamReadConstraints;
import java.lang.reflect.Field;
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

class CharsToNameCanonicalizer_createRoot_2_0_Test {

    @Test
    void testCreateRootWithValidSeed() throws Exception {
        int seed = 12345;
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        assertNotNull(result);
        assertEquals(seed, (int) getPrivateField(result, "_seed"));
        assertTrue(getPrivateField(result, "_canonicalize"));
        assertNotNull(getPrivateField(result, "_tableInfo"));
    }

    @Test
    void testCreateRootWithNullOwner() throws Exception {
        int seed = 0;
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        assertNotNull(result);
        assertNotNull(getPrivateField(result, "_streamReadConstraints"));
        assertEquals(seed, (int) getPrivateField(result, "_seed"));
    }

    @Test
    void testCreateRootWithZeroSeed() throws Exception {
        int seed = 0;
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        assertNotNull(result);
        // should not be zero
        assertNotEquals(seed, (int) getPrivateField(result, "_seed"));
        assertTrue(getPrivateField(result, "_canonicalize"));
    }

    @Test
    void testCreateRootWithNegativeSeed() throws Exception {
        int seed = -12345;
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        assertNotNull(result);
        assertEquals(seed, (int) getPrivateField(result, "_seed"));
    }

    private <T> T getPrivateField(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (T) field.get(obj);
    }
}
