package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecyclers;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_BufferRecyclers_getBufferRecycler__cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testGetBufferRecycler() {
        // Clear the ThreadLocal to ensure we are testing the case where no BufferRecycler is cached
        BufferRecyclers._recyclerRef.remove();

        // Call the focal method
        BufferRecycler result = BufferRecyclers.getBufferRecycler();

        // Assert that the result is not null, indicating a new BufferRecycler was created
        assertNotNull("Expected a new BufferRecycler to be created", result);
    }

}