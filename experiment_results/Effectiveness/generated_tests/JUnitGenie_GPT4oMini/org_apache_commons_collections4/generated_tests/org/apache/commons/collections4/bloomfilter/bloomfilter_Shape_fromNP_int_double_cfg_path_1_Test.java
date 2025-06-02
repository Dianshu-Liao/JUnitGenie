package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class bloomfilter_Shape_fromNP_int_double_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFromNP_ThrowsIllegalArgumentException_WhenMExceedsIntegerMaxValue() {
        int numberOfItems = 1000000000; // A large number to ensure m exceeds Integer.MAX_VALUE
        double probability = 0.5; // Valid probability

        try {
            Shape shape = Shape.fromNP(numberOfItems, probability);
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Resulting filter has more than 2147483647 bits: " + Math.ceil(numberOfItems * Math.log(probability) / (-Math.log(2) * Math.log(2))), e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_SuccessfulExecution() {
        int numberOfItems = 10; // Valid number of items
        double probability = 0.5; // Valid probability

        try {
            Shape shape = Shape.fromNP(numberOfItems, probability);
            assertNotNull(shape);
            // Additional assertions can be added here to verify the properties of the shape
        } catch (Exception e) {
            fail("Expected no exception to be thrown, but got: " + e.getMessage());
        }
    }

}