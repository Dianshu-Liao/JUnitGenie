package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = null;

        // Testing the condition where both arrays are null
        equalsBuilder.append(lhs, rhs);
        // Here isEquals should be set to false due to the null check
        // Ensuring that isEquals is false
        assertFalse(equalsBuilder.isEquals()); // Changed to isEquals() method
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = new double[]{1.0, 2.0};
        double[] rhs = new double[]{1.0};

        // Testing the condition where arrays have different lengths
        equalsBuilder.append(lhs, rhs);
        // Ensuring that isEquals is false
        assertFalse(equalsBuilder.isEquals()); // Changed to isEquals() method
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = new double[]{1.0, 2.0};
        double[] rhs = lhs; // Same reference
        
        // Testing the condition where both arrays reference to the same array
        equalsBuilder.append(lhs, rhs);
        // isEquals should remain true
        assertTrue(equalsBuilder.isEquals()); // Changed to isEquals() method
    }


}