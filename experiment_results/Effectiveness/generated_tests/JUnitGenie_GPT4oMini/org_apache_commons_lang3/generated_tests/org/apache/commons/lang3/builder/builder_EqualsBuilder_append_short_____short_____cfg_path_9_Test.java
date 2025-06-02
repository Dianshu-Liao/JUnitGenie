package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2};
        short[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        assertSame(equalsBuilder, result);
    }

}