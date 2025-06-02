package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_double_____double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison()); // Use toComparison() method instead of accessing comparison directly
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = null;
        double[] rhs = {1.0, 2.0};

        builder.append(lhs, rhs);
        assertEquals(-1, builder.toComparison()); // Use toComparison() method instead of accessing comparison directly
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = null;

        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison()); // Use toComparison() method instead of accessing comparison directly
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0};

        builder.append(lhs, rhs);
        assertEquals(0, builder.toComparison()); // Use toComparison() method instead of accessing comparison directly
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        CompareToBuilder builder = new CompareToBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 3.0};

        builder.append(lhs, rhs);
        assertEquals(-1, builder.toComparison()); // Use toComparison() method instead of accessing comparison directly
    }


}