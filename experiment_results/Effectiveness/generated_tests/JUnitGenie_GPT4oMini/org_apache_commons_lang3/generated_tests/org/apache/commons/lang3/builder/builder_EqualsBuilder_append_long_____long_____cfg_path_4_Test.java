package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, lhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(null, rhs);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, null);
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L};
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
    }

}