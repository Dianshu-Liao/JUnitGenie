package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ByteQuadsCanonicalizer__findSecondary_23_2_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() {
        // Initialize the ByteQuadsCanonicalizer using reflection to access the private constructor
        try {
            Constructor<ByteQuadsCanonicalizer> constructor = ByteQuadsCanonicalizer.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            canonicalizer = constructor.newInstance(64, 0);
        } catch (Exception e) {
            fail("Failed to create ByteQuadsCanonicalizer instance: " + e.getMessage());
        }
        // Set up hash area and names for testing
        canonicalizer._hashArea = new int[256];
        canonicalizer._names = new String[64];
        canonicalizer._tertiaryStart = 64;
        canonicalizer._tertiaryShift = 2;
        canonicalizer._spilloverEnd = 128;
    }

    @Test
    public void testFindSecondary_FoundInPrimary() throws Exception {
        // Arrange
        int origOffset = 0;
        int q1 = 1;
        int q2 = 2;
        canonicalizer._hashArea[64] = q1;
        canonicalizer._hashArea[65] = q2;
        canonicalizer._hashArea[67] = 2;
        canonicalizer._names[16] = "name1";
        // Act
        String result = invokeFindSecondary(origOffset, q1, q2);
        // Assert
        assertEquals("name1", result);
    }

    @Test
    public void testFindSecondary_NotFoundInPrimary() throws Exception {
        // Arrange
        int origOffset = 0;
        int q1 = 3;
        int q2 = 4;
        canonicalizer._hashArea[64] = 1;
        canonicalizer._hashArea[65] = 2;
        canonicalizer._hashArea[67] = 1;
        // Act
        String result = invokeFindSecondary(origOffset, q1, q2);
        // Assert
        assertNull(result);
    }

    @Test
    public void testFindSecondary_FoundInSpillover() throws Exception {
        // Arrange
        int origOffset = 0;
        int q1 = 5;
        int q2 = 6;
        canonicalizer._hashArea[64] = 0;
        canonicalizer._hashArea[128] = q1;
        canonicalizer._hashArea[129] = q2;
        canonicalizer._hashArea[131] = 2;
        canonicalizer._names[32] = "name2";
        // Act
        String result = invokeFindSecondary(origOffset, q1, q2);
        // Assert
        assertEquals("name2", result);
    }

    @Test
    public void testFindSecondary_NotFoundInSpillover() throws Exception {
        // Arrange
        int origOffset = 0;
        int q1 = 7;
        int q2 = 8;
        canonicalizer._hashArea[128] = 9;
        canonicalizer._hashArea[129] = 10;
        canonicalizer._hashArea[131] = 1;
        // Act
        String result = invokeFindSecondary(origOffset, q1, q2);
        // Assert
        assertNull(result);
    }

    private String invokeFindSecondary(int origOffset, int q1, int q2) throws Exception {
        Method method = ByteQuadsCanonicalizer.class.getDeclaredMethod("_findSecondary", int.class, int.class, int.class);
        method.setAccessible(true);
        return (String) method.invoke(canonicalizer, origOffset, q1, q2);
    }
}
