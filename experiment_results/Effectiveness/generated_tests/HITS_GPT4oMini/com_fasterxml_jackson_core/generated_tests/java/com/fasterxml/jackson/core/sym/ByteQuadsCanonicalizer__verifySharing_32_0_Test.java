package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;

public class ByteQuadsCanonicalizer__verifySharing_32_0_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() throws Exception {
        // Use reflection to access the private constructor
        Class<?> clazz = ByteQuadsCanonicalizer.class;
        Method constructor = clazz.getDeclaredMethod("ByteQuadsCanonicalizer", int.class, int.class);
        constructor.setAccessible(true);
        // Using a valid size
        canonicalizer = (ByteQuadsCanonicalizer) constructor.invoke(null, 64, 0);
    }

    @Test
    public void testVerifySharing_ThrowsExceptionWhenAddingToRootTable() throws Exception {
        canonicalizer._hashShared = true;
        canonicalizer._count = 0;
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            invokeVerifySharing();
        });
        assertEquals("Internal error: Cannot add names to Root symbol table", thrown.getMessage());
    }

    @Test
    public void testVerifySharing_ThrowsExceptionWhenAddingToPlaceholderTable() throws Exception {
        canonicalizer._hashShared = true;
        canonicalizer._count = 5;
        IllegalStateException thrown = assertThrows(IllegalStateException.class, () -> {
            invokeVerifySharing();
        });
        assertEquals("Internal error: Cannot add names to Placeholder symbol table", thrown.getMessage());
    }

    @Test
    public void testVerifySharing_CopiesHashAreaAndNamesWhenShared() throws Exception {
        canonicalizer._hashShared = true;
        canonicalizer._count = 1;
        canonicalizer._hashArea = new int[] { 1, 2, 3 };
        canonicalizer._names = new String[] { "name1" };
        invokeVerifySharing();
        assertFalse(canonicalizer._hashShared);
        assertNotSame(canonicalizer._hashArea, new int[] { 1, 2, 3 });
        assertNotSame(canonicalizer._names, new String[] { "name1" });
        assertArrayEquals(new int[] { 1, 2, 3 }, canonicalizer._hashArea);
        assertArrayEquals(new String[] { "name1" }, canonicalizer._names);
    }

    @Test
    public void testVerifySharing_DoesNotModifyWhenNotShared() throws Exception {
        canonicalizer._hashShared = false;
        canonicalizer._count = 1;
        canonicalizer._hashArea = new int[] { 1, 2, 3 };
        canonicalizer._names = new String[] { "name1" };
        invokeVerifySharing();
        assertFalse(canonicalizer._hashShared);
        assertArrayEquals(new int[] { 1, 2, 3 }, canonicalizer._hashArea);
        assertArrayEquals(new String[] { "name1" }, canonicalizer._names);
    }

    private void invokeVerifySharing() throws Exception {
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_verifySharing");
        method.setAccessible(true);
        method.invoke(canonicalizer);
    }
}
