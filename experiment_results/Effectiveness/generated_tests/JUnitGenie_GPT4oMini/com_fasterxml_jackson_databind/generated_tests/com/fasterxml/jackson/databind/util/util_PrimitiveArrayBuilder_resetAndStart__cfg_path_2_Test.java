package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_PrimitiveArrayBuilder_resetAndStart__cfg_path_2_Test {

    private class TestPrimitiveArrayBuilder extends PrimitiveArrayBuilder<Object> {
        @Override
        public Object _constructArray(int size) {
            return new Object[size]; // Simple implementation for testing
        }
    }

    @Test(timeout = 4000)
    public void testResetAndStart_WithFreeBufferNull() {
        TestPrimitiveArrayBuilder builder = new TestPrimitiveArrayBuilder();
        // Simulate _freeBuffer being null
        try {
            Object result = builder.resetAndStart();
            assertNotNull(result);
            assertEquals(12, ((Object[]) result).length); // Check if the array size is INITIAL_CHUNK_SIZE (12)
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testResetAndStart_WithFreeBufferNotNull() {
        TestPrimitiveArrayBuilder builder = new TestPrimitiveArrayBuilder();
        // Simulate _freeBuffer being not null
        try {
            builder._freeBuffer = new Object[5]; // Set _freeBuffer to a non-null value
            Object result = builder.resetAndStart();
            assertNotNull(result);
            assertEquals(5, ((Object[]) result).length); // Check if the returned buffer is the same as _freeBuffer
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}