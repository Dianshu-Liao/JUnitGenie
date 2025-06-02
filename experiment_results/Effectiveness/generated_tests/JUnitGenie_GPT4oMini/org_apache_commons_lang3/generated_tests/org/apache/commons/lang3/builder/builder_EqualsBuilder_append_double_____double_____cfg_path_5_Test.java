package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0};

        try {
            equalsBuilder.append(lhs, rhs);
            // Check if isEquals is set to false
            assertFalse(equalsBuilder.isEquals()); // Changed to isEquals() method
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0};

        try {
            equalsBuilder.append(lhs, rhs);
            // Check if isEquals is set to false
            assertFalse(equalsBuilder.isEquals()); // Changed to isEquals() method
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = lhs; // Same reference

        try {
            equalsBuilder.append(lhs, rhs);
            // Check if isEquals remains true
            assertTrue(equalsBuilder.isEquals()); // Changed to isEquals() method
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};

        try {
            equalsBuilder.append(lhs, rhs);
            // Check if isEquals remains true
            assertTrue(equalsBuilder.isEquals()); // Changed to isEquals() method
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }
    }


}