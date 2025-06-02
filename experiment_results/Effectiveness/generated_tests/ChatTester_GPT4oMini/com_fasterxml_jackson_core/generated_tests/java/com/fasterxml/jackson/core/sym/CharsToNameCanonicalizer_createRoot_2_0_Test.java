package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Field;
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
import com.fasterxml.jackson.core.StreamReadConstraints;
import com.fasterxml.jackson.core.TokenStreamFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class CharsToNameCanonicalizer_createRoot_2_0_Test {

    @Test
    public void testCreateRoot() throws Exception {
        // Given
        int seed = 12345;
        // When
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        // Then
        assertNotNull(result);
        assertEquals(seed, getPrivateField(result, "_seed"));
    }

    @Test
    public void testCreateRootWithNullParent() throws Exception {
        // Given
        int seed = 67890;
        // When
        CharsToNameCanonicalizer result = CharsToNameCanonicalizer.createRoot(seed);
        // Then
        assertNotNull(result);
        assertEquals(seed, getPrivateField(result, "_seed"));
    }

    private Object getPrivateField(CharsToNameCanonicalizer instance, String fieldName) throws Exception {
        Field field = CharsToNameCanonicalizer.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(instance);
    }
}
