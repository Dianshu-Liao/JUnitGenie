package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecyclers;
import com.fasterxml.jackson.core.util.BufferRecycler;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_BufferRecyclers_getBufferRecycler__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetBufferRecycler() {
        try {
            // Ensure that the _recyclerRef is null to trigger the creation of a new BufferRecycler
            BufferRecyclers._recyclerRef.set(null);
            BufferRecycler bufferRecycler = BufferRecyclers.getBufferRecycler();
            assertNotNull("BufferRecycler should not be null", bufferRecycler);
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}