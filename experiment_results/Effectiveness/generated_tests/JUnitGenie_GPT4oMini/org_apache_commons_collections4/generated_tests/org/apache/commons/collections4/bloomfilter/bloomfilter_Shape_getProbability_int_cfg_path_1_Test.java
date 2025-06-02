package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class bloomfilter_Shape_getProbability_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetProbabilityThrowsIllegalArgumentException() {
        Shape shape = null;
        try {
            // Using reflection to access the private constructor
            java.lang.reflect.Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            shape = constructor.newInstance(1, 1); // Example values for the constructor

            // This should throw an IllegalArgumentException
            shape.getProbability(-1);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Number of items must be greater than or equal to 0: -1", e.getMessage());
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

}