package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class ByteQuadsCanonicalizer_isCanonicalizing_10_0_Test {

    private ByteQuadsCanonicalizer root;

    private ByteQuadsCanonicalizer child;

    @BeforeEach
    public void setUp() {
        // Create root instance
        root = ByteQuadsCanonicalizer.createRoot();
        // Create child instance
        child = root.makeChild(0);
    }

    @Test
    public void testIsCanonicalizingWithParent() {
        // Since child has a parent, it should return true
        assertTrue(child.isCanonicalizing());
    }

    @Test
    public void testIsCanonicalizingWithoutParent() {
        // Root has no parent, it should return false
        assertFalse(root.isCanonicalizing());
    }

    @Test
    public void testIsCanonicalizingWithDifferentChild() throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        // Use reflection to create a child with a null parent
        Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(ByteQuadsCanonicalizer.class, int.class, AtomicReference.class, boolean.class, boolean.class);
        constructor.setAccessible(true);
        // Create a child with null parent
        ByteQuadsCanonicalizer childWithoutParent = constructor.newInstance(null, 1, new AtomicReference<>(), true, false);
        // It should return false as it has no parent
        assertFalse(childWithoutParent.isCanonicalizing());
    }
}
