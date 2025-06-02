package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.ArrayCountingBloomFilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.*;

public class bloomfilter_ArrayCountingBloomFilter_subtract_int_int_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testSubtract() {
        try {
            // Create an instance of ArrayCountingBloomFilter using reflection
            Class<?> clazz = ArrayCountingBloomFilter.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(Shape.class);
            constructor.setAccessible(true);
            Shape shape = createShape(); // Use a method to create Shape instance
            ArrayCountingBloomFilter bloomFilter = (ArrayCountingBloomFilter) constructor.newInstance(shape);

            // Set up the cells and state for testing
            int[] cells = {10, 20, 30}; // Example values
            setPrivateField(bloomFilter, "cells", cells);
            setPrivateField(bloomFilter, "state", 0);

            // Test valid subtraction
            boolean result = invokeSubtract(bloomFilter, 1, 5);
            assertTrue(result);
            assertEquals(15, cells[1]); // Expecting cells[1] to be updated to 15
            assertEquals(15, getPrivateField(bloomFilter, "state")); // Expecting state to be updated to 15

        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSubtractThrowsIllegalArgumentException() {
        try {
            // Create an instance of ArrayCountingBloomFilter using reflection
            Class<?> clazz = ArrayCountingBloomFilter.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(Shape.class);
            constructor.setAccessible(true);
            Shape shape = createShape(); // Use a method to create Shape instance
            ArrayCountingBloomFilter bloomFilter = (ArrayCountingBloomFilter) constructor.newInstance(shape);

            // Set up the cells and state for testing
            int[] cells = {10, 20, 30}; // Example values
            setPrivateField(bloomFilter, "cells", cells);
            setPrivateField(bloomFilter, "state", 0);

            // Attempt to subtract with an invalid index
            invokeSubtract(bloomFilter, 5, 5); // This should throw an exception

            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertTrue(e.getMessage().contains("Filter only accepts values in the [0,10) range"));
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private Shape createShape() throws Exception {
        // Use reflection to access the private constructor of Shape
        Constructor<?> shapeConstructor = Shape.class.getDeclaredConstructor(int.class, int.class);
        shapeConstructor.setAccessible(true);
        return (Shape) shapeConstructor.newInstance(10, 10);
    }

    private boolean invokeSubtract(ArrayCountingBloomFilter bloomFilter, int idx, int subtrahend) throws Exception {
        Method method = ArrayCountingBloomFilter.class.getDeclaredMethod("subtract", int.class, int.class);
        method.setAccessible(true);
        return (boolean) method.invoke(bloomFilter, idx, subtrahend);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private int getPrivateField(Object obj, String fieldName) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return (int) field.get(obj);
    }

}