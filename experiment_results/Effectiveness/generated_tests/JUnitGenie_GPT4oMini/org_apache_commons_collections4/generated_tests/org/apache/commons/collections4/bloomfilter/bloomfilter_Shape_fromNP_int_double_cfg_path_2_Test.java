package org.apache.commons.collections4.bloomfilter;
import org.apache.commons.collections4.bloomfilter.Shape;
import org.junit.Test;
import static org.junit.Assert.*;

public class bloomfilter_Shape_fromNP_int_double_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFromNP_ValidInput() {
        try {
            Shape shape = Shape.fromNP(10, 0.5);
            assertNotNull(shape);
            assertTrue(shape.getProbability(10) >= 0.0 && shape.getProbability(10) <= 1.0);
        } catch (Exception e) {
            fail("Expected no exception, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_ZeroItems() {
        try {
            Shape shape = Shape.fromNP(0, 0.5);
            fail("Expected IllegalArgumentException for zero items.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_NegativeItems() {
        try {
            Shape shape = Shape.fromNP(-1, 0.5);
            fail("Expected IllegalArgumentException for negative items.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_InvalidProbabilityLessThanZero() {
        try {
            Shape shape = Shape.fromNP(10, -0.1);
            fail("Expected IllegalArgumentException for probability less than zero.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_InvalidProbabilityGreaterThanOne() {
        try {
            Shape shape = Shape.fromNP(10, 1.1);
            fail("Expected IllegalArgumentException for probability greater than one.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFromNP_MValueTooHigh() {
        try {
            Shape shape = Shape.fromNP(Integer.MAX_VALUE, 0.5);
            fail("Expected IllegalArgumentException for exceeding max bits.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Expected IllegalArgumentException, but got: " + e.getMessage());
        }
    }

}