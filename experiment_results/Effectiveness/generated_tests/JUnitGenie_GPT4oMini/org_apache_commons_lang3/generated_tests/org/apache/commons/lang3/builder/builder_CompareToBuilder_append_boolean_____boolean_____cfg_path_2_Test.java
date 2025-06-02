package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class builder_CompareToBuilder_append_boolean_____boolean_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = {true, false, true};

        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison()); // lhs.length < rhs.length
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = null;
        boolean[] rhs = {true, false};

        builder.append(lhs, rhs);
        assertEquals(-1, builder.toComparison()); // lhs is null
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = null;

        builder.append(lhs, rhs);
        assertEquals(1, builder.toComparison()); // rhs is null
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = {true, false};

        builder.append(lhs, rhs);
        assertEquals(0, builder.toComparison()); // lhs is equal to rhs
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        CompareToBuilder builder = new CompareToBuilder();
        boolean[] lhs = {true, false};
        boolean[] rhs = {false, true};

        builder.append(lhs, rhs);
        assertEquals(0, builder.toComparison()); // comparison remains 0 as values are compared
    }


}