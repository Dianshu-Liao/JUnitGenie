package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_BufferRecycler_isLinkedWithPool__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsLinkedWithPoolWhenPoolIsNull() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        // Directly accessing the private field _pool using reflection
        try {
            java.lang.reflect.Field field = BufferRecycler.class.getDeclaredField("_pool");
            field.setAccessible(true);
            field.set(bufferRecycler, null); // Set _pool to null to cover the CFGPath

            // Now we can test the focal method
            boolean result = bufferRecycler.isLinkedWithPool();
            assertFalse(result); // Expecting false since _pool is null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

}