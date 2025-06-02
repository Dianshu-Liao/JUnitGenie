package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.PrimitiveArrayBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class util_PrimitiveArrayBuilder_resetAndStart__cfg_path_1_Test {

    private class TestPrimitiveArrayBuilder extends PrimitiveArrayBuilder<Object> {
        @Override
        public Object _constructArray(int size) {
            return new Object[size];
        }
    }

    @Test(timeout = 4000)
    public void testResetAndStart_WhenFreeBufferIsNull() {
        TestPrimitiveArrayBuilder builder = new TestPrimitiveArrayBuilder();
        // Assuming _freeBuffer is initialized to null by default in the constructor
        Object result = builder.resetAndStart();
        assertNotNull(result); // Ensure that the result is not null
    }

    @Test(timeout = 4000)
    public void testResetAndStart_WhenFreeBufferIsNotNull() {
        TestPrimitiveArrayBuilder builder = new TestPrimitiveArrayBuilder();
        // Directly accessing the protected field _freeBuffer using reflection
        try {
            java.lang.reflect.Field field = PrimitiveArrayBuilder.class.getDeclaredField("_freeBuffer");
            field.setAccessible(true);
            field.set(builder, new Object()); // Set _freeBuffer to a non-null value

            Object result = builder.resetAndStart();
            assertNotNull(result); // Ensure that the result is not null
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle the exception
        }
    }

}