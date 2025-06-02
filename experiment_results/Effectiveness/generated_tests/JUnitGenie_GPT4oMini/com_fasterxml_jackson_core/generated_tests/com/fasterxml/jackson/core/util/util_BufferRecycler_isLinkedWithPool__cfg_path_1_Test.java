package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_BufferRecycler_isLinkedWithPool__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsLinkedWithPoolWhenPoolIsNull() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        // Directly testing the focal method
        boolean result = bufferRecycler.isLinkedWithPool();
        assertFalse(result);
    }

}