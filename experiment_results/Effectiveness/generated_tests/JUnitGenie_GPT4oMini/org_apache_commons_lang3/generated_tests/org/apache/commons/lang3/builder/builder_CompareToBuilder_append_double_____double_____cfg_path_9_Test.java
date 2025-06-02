package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 4.0};

        builder.append(lhs, rhs);
        
        // Since the last elements are different, the comparison should not be 0
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        
        // lhs is null, so comparison should be -1
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = null;

        builder.append(lhs, rhs);
        
        // rhs is null, so comparison should be 1
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        
        // Both arrays are equal, so comparison should remain 0
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        
        // lhs is shorter than rhs, so comparison should be -1
        assertEquals(-1, builder.toComparison());
    }


}