package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = null;

        // Use the append method directly to check for null arrays
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertFalse(equalsBuilder.isEquals()); // Use the public method to check isEquals
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0};

        // Use the append method directly to check for different length arrays
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertFalse(equalsBuilder.isEquals()); // Use the public method to check isEquals
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = new double[]{1.0, 2.0};
        double[] rhs = lhs; // Same reference

        // Use the append method directly to check for same reference
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertTrue(equalsBuilder.isEquals()); // Use the public method to check isEquals
    }


}