package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since isEquals is true, the result should be the same EqualsBuilder instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = lhs; // Same reference

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are the same reference, the result should be the same EqualsBuilder instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs is null, isEquals should be set to false
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since rhs is null, isEquals should be set to false
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs have different lengths, isEquals should be set to false
        assertSame(equalsBuilder, result);
    }

}