package com.fasterxml.jackson.core.util;
import com.fasterxml.jackson.core.util.BufferRecycler;
import com.fasterxml.jackson.core.util.RecyclerPool;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_BufferRecycler_withPool_RecyclerPool_cfg_path_1_Test {

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
    public void testWithPool() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        TestRecyclerPool pool = new TestRecyclerPool();

        // Test linking to a pool
        BufferRecycler result = bufferRecycler.withPool(pool);
        assertNotNull(result);
        assertSame(bufferRecycler, result);
    }

    @Test(timeout = 4000)
    public void testWithPoolThrowsExceptionWhenAlreadyLinked() {
        BufferRecycler bufferRecycler = new BufferRecycler();
        TestRecyclerPool pool1 = new TestRecyclerPool();
        TestRecyclerPool pool2 = new TestRecyclerPool();

        // First link to a pool
        bufferRecycler.withPool(pool1);

        // Test that linking to another pool throws an exception
        try {
            bufferRecycler.withPool(pool2);
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("BufferRecycler already linked to pool: " + pool2, e.getMessage());
        }
    }

}