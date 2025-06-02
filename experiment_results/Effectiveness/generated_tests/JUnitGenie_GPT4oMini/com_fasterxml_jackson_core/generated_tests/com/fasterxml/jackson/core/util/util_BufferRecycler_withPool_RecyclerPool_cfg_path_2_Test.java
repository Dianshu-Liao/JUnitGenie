package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_BufferRecycler_withPool_RecyclerPool_cfg_path_2_Test {

    private class TestRecyclerPool implements RecyclerPool<BufferRecycler> {
        @Override
        public BufferRecycler acquirePooled() {
            return new BufferRecycler();
        }

        @Override
        public void releasePooled(BufferRecycler recycler) {
            // Implementation for releasing the pooled BufferRecycler
        }

        @Override
        public int pooledCount() {
            return 0; // Return the count of pooled BufferRecycler instances
        }

        @Override
        public boolean clear() {
            return true; // Clear the pool
        }

        @Override
        public BufferRecycler acquireAndLinkPooled() {
            return new BufferRecycler();
        }
    }

    @Test(timeout = 4000)
    public void testWithPool_throwsIllegalStateException_whenAlreadyLinked() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        RecyclerPool<BufferRecycler> pool = new TestRecyclerPool();
        
        // First call to link the pool should succeed
        bufferRecycler.withPool(pool);
        
        try {
            // Second call should throw IllegalStateException
            bufferRecycler.withPool(pool);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("BufferRecycler already linked to pool: " + pool, e.getMessage());
        }
    }

}