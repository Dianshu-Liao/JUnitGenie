package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        // The comparison should be -1 since lhs is shorter than rhs
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0};

        builder.append(lhs, rhs);
        // The comparison should be -1 since lhs is null
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = null;

        builder.append(lhs, rhs);
        // The comparison should be 1 since rhs is null
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0};

        builder.append(lhs, rhs);
        // The comparison should remain 0 since both arrays are equal
        assertEquals(0, builder.toComparison());
    }


}