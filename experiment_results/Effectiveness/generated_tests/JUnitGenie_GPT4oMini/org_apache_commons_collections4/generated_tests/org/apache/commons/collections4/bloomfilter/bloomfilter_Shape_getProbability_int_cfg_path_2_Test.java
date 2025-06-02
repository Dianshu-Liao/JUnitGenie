package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class bloomfilter_Shape_getProbability_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetProbability() {
        try {
            // Using reflection to access the private constructor
            java.lang.reflect.Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Shape shape = constructor.newInstance(10, 100); // Example values for numberOfHashFunctions and numberOfBits

            // Test case for numberOfItems > 0
            double result = shape.getProbability(5);
            assertTrue(result >= 0); // Assuming probability should be non-negative

            // Test case for numberOfItems == 0
            result = shape.getProbability(0);
            assertEquals(0.0, result, 0.0001);

            // Test case for numberOfItems < 0 (should throw IllegalArgumentException)
            try {
                shape.getProbability(-1);
                fail("Expected IllegalArgumentException for negative numberOfItems");
            } catch (IllegalArgumentException e) {
                assertEquals("Number of items must be greater than or equal to 0: -1", e.getMessage());
            }

        } catch (Exception e) {
            e.printStackTrace();
            fail("Exception occurred: " + e.getMessage());
        }
    }

}