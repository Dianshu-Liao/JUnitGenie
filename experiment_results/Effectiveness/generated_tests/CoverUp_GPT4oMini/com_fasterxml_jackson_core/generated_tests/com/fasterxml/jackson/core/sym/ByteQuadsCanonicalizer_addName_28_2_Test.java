package com.fasterxml.jackson.core.sym;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.exc.StreamConstraintsException;
import com.fasterxml.jackson.core.util.InternCache;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ByteQuadsCanonicalizer_addName_28_2_Test {

    private ByteQuadsCanonicalizer canonicalizer;

    @BeforeEach
    public void setUp() throws Exception {
        // Create a new instance of ByteQuadsCanonicalizer using reflection
        Field defaultTSizeField = ByteQuadsCanonicalizer.class.getDeclaredField("DEFAULT_T_SIZE");
        defaultTSizeField.setAccessible(true);
        int defaultTSize = (int) defaultTSizeField.get(null);
        canonicalizer = (ByteQuadsCanonicalizer) ByteQuadsCanonicalizer.class.getDeclaredConstructors()[0].newInstance(defaultTSize, 0);
        // Initialize the _hashArea and _names arrays
        canonicalizer._hashArea = new int[64 * 4];
        canonicalizer._names = new String[64];
        // Setting a default interner
        Field internerField = canonicalizer.getClass().getDeclaredField("_interner");
        internerField.setAccessible(true);
        internerField.set(canonicalizer, InternCache.instance);
        // Initialize count
        canonicalizer._count = 0;
    }

    @Test
    public void testAddNameWithInterning() throws Exception {
        String name = "testName";
        int q1 = 12345;
        String result = invokeAddName(canonicalizer, name, q1);
        assertEquals(name, result);
        assertEquals(1, canonicalizer._count);
        // Check if q1 is added
        assertEquals(q1, canonicalizer._hashArea[canonicalizer._hashArea.length - 4]);
        // Check if name is stored
        assertEquals(name, canonicalizer._names[0]);
    }

    @Test
    public void testAddNameWithoutInterning() throws Exception {
        String name = "testName";
        int q1 = 12345;
        // Set the _interner to null using reflection
        Field internerField = canonicalizer.getClass().getDeclaredField("_interner");
        internerField.setAccessible(true);
        internerField.set(canonicalizer, null);
        String result = invokeAddName(canonicalizer, name, q1);
        assertEquals(name, result);
        assertEquals(1, canonicalizer._count);
        // Check if q1 is added
        assertEquals(q1, canonicalizer._hashArea[canonicalizer._hashArea.length - 4]);
        // Check if name is stored
        assertEquals(name, canonicalizer._names[0]);
    }

    @Test
    public void testAddNameWithCollisions() throws Exception {
        String name1 = "testName1";
        String name2 = "testName2";
        int q1 = 12345;
        int q2 = 12346;
        // Simulate a collision scenario by manually setting the hash area
        // First entry
        canonicalizer._hashArea[0] = q1;
        // Mark as occupied
        canonicalizer._hashArea[4] = 1;
        // Second entry
        canonicalizer._hashArea[8] = q2;
        // Mark as occupied
        canonicalizer._hashArea[12] = 1;
        invokeAddName(canonicalizer, name1, q1);
        String result = invokeAddName(canonicalizer, name2, q2);
        assertEquals(name2, result);
        assertEquals(2, canonicalizer._count);
        // Check if first name is stored
        assertEquals(name1, canonicalizer._names[0]);
        // Check if second name is stored
        assertEquals(name2, canonicalizer._names[1]);
    }

    private String invokeAddName(ByteQuadsCanonicalizer canonicalizer, String name, int q1) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        Method addNameMethod = ByteQuadsCanonicalizer.class.getDeclaredMethod("addName", String.class, int.class);
        addNameMethod.setAccessible(true);
        return (String) addNameMethod.invoke(canonicalizer, name, q1);
    }
}
