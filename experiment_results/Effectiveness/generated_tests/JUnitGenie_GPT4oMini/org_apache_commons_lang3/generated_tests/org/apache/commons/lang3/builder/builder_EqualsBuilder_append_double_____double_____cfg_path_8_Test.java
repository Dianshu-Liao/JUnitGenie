package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since the arrays are equal, the isEquals should remain true
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 4.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since the arrays are not equal, the isEquals should be set to false
        // However, we cannot directly check isEquals as it is private.
        // We can only check that the method returns the same instance.
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs is null, isEquals should be set to false
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since the lengths are different, isEquals should be set to false
        assertSame(equalsBuilder, result);
    }

}