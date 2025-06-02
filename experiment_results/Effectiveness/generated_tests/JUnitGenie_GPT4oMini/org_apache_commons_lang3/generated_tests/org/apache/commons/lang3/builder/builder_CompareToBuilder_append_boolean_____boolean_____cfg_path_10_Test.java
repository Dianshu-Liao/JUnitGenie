package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_____boolean_____cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testAppendWithSameComparison() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = {true, false};

        // Initial comparison should be 0
        builder.append(lhs, rhs);
        assertEquals(0, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false, true};
        boolean[] rhs = {true, false};

        // Comparison should be 1 since lhs is longer than rhs
        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = null;
        boolean[] rhs = {true, false};

        // Comparison should be -1 since lhs is null
        builder.append(lhs, rhs);
        assertEquals(-1, builder.toComparison());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = null;

        // Comparison should be 1 since rhs is null
        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison());
    }


}