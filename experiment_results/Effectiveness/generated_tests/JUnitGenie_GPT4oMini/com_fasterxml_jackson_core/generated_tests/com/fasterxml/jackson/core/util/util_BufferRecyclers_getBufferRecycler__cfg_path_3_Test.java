package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecyclers;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_BufferRecyclers_getBufferRecycler__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetBufferRecycler() {
        // Calling the static method to retrieve the BufferRecycler instance
        BufferRecycler bufferRecycler = BufferRecyclers.getBufferRecycler();
        
        // Asserting that the returned instance is not null
        assertNotNull("BufferRecycler should not be null", bufferRecycler);
    }

}