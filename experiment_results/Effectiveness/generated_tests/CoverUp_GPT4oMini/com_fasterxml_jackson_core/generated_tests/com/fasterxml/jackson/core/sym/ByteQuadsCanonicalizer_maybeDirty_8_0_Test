package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ByteQuadsCanonicalizer_maybeDirty_8_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        // Create a root instance of ByteQuadsCanonicalizer
        canonicalizer = ByteQuadsCanonicalizer.createRoot();
    }

    @Test
    public void testMaybeDirtyWhenHashSharedIsFalse() throws Exception {
        // Set _hashShared to false using reflection
        setPrivateField(canonicalizer, "_hashShared", false);
        // Invoke maybeDirty method
        boolean result = canonicalizer.maybeDirty();
        // Assert that the result is true
        assertTrue(result);
    }

    @Test
    public void testMaybeDirtyWhenHashSharedIsTrue() throws Exception {
        // Set _hashShared to true using reflection
        setPrivateField(canonicalizer, "_hashShared", true);
        // Invoke maybeDirty method
        boolean result = canonicalizer.maybeDirty();
        // Assert that the result is false
        assertFalse(result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
