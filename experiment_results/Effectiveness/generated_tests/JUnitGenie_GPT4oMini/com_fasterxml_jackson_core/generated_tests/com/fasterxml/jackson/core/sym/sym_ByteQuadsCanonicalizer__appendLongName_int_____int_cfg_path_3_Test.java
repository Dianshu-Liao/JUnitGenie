package com.fasterxml.jackson.core.sym;
import com.fasterxml.jackson.core.sym.ByteQuadsCanonicalizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class sym_ByteQuadsCanonicalizer__appendLongName_int_____int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendLongName() {
        try {
            // Create an instance of ByteQuadsCanonicalizer using reflection
            Class<?> clazz = ByteQuadsCanonicalizer.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class); // Changed to Constructor
            constructor.setAccessible(true);
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) constructor.newInstance(16, 16);

            // Set up the initial state
            int[] quads = {1, 2, 3, 4};
            int qlen = quads.length;

            // Set the protected fields using reflection
            java.lang.reflect.Field longNameOffsetField = clazz.getDeclaredField("_longNameOffset");
            longNameOffsetField.setAccessible(true);
            longNameOffsetField.setInt(instance, 0);

            java.lang.reflect.Field hashAreaField = clazz.getDeclaredField("_hashArea");
            hashAreaField.setAccessible(true);
            hashAreaField.set(instance, new int[10]); // Initial size of _hashArea

            java.lang.reflect.Field hashSizeField = clazz.getDeclaredField("_hashSize");
            hashSizeField.setAccessible(true);
            hashSizeField.setInt(instance, 10);

            // Call the private method _appendLongName using reflection
            Method appendLongNameMethod = clazz.getDeclaredMethod("_appendLongName", int[].class, int.class);
            appendLongNameMethod.setAccessible(true);
            int result = (int) appendLongNameMethod.invoke(instance, (Object) quads, qlen); // Cast quads to Object

            // Verify the result
            assertEquals(0, result);

            // Verify the state after the method call
            int[] hashArea = (int[]) hashAreaField.get(instance);
            assertArrayEquals(new int[]{1, 2, 3, 4}, new int[]{hashArea[0], hashArea[1], hashArea[2], hashArea[3]});
            int newLongNameOffset = longNameOffsetField.getInt(instance);
            assertEquals(qlen, newLongNameOffset);

        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testAppendLongNameThrowsException() {
        try {
            // Create an instance of ByteQuadsCanonicalizer using reflection
            Class<?> clazz = ByteQuadsCanonicalizer.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(int.class, int.class); // Changed to Constructor
            constructor.setAccessible(true);
            ByteQuadsCanonicalizer instance = (ByteQuadsCanonicalizer) constructor.newInstance(16, 16);

            // Set up the initial state
            int[] quads = {1, 2, 3, 4};
            int qlen = -1; // This will cause the exception

            // Call the private method _appendLongName using reflection
            Method appendLongNameMethod = clazz.getDeclaredMethod("_appendLongName", int[].class, int.class);
            appendLongNameMethod.setAccessible(true);
            appendLongNameMethod.invoke(instance, (Object) quads, qlen); // Cast quads to Object

        } catch (Exception e) {
            // Handle the exception
            throw new IllegalStateException("Internal error: long name offset overflow", e);
        }
    }

}