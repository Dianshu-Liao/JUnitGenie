package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class util_BufferRecycler_releaseToPool__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReleaseToPoolWhenPoolIsNull() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        
        // Set the _pool field to null using reflection
        try {
            java.lang.reflect.Field poolField = BufferRecycler.class.getDeclaredField("_pool");
            poolField.setAccessible(true);
            poolField.set(bufferRecycler, null);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        // Call the method under test
        bufferRecycler.releaseToPool();

        // Verify that the _pool field is still null
        try {
            java.lang.reflect.Field poolField = BufferRecycler.class.getDeclaredField("_pool");
            poolField.setAccessible(true);
            RecyclerPool<BufferRecycler> poolValue = (RecyclerPool<BufferRecycler>) poolField.get(bufferRecycler);
            assertNull(poolValue);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}