package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class bloomfilter_Shape_getProbability_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetProbabilityWithZeroItems() {
        try {
            // Using reflection to access the private constructor
            java.lang.reflect.Constructor<Shape> constructor = Shape.class.getDeclaredConstructor(int.class, int.class);
            constructor.setAccessible(true);
            Shape shape = constructor.newInstance(1, 1); // Example parameters for the constructor

            double result = shape.getProbability(0);
            assertEquals(0.0, result, 0.0001);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}