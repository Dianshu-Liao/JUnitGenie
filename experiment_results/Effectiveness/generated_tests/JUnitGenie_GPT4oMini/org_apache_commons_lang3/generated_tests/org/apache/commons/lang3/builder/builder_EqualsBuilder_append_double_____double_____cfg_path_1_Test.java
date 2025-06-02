package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_double_____double_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = null;
        double[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0};
        double[] rhs = {1.0, 2.0, 3.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = lhs;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        double[] lhs = {1.0, 2.0, 3.0};
        double[] rhs = {4.0, 5.0, 6.0};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

}