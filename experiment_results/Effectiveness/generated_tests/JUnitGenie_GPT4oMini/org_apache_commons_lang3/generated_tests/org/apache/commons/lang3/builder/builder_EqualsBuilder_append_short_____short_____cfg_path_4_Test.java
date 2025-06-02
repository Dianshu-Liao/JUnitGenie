package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAppend_WithEqualArrays() {
        EqualsBuilder builder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};
        EqualsBuilder result = builder.append(lhs, rhs);

        assertSame(builder, result);
    }

    @Test(timeout = 4000)
    public void testAppend_WithSameReference() {
        EqualsBuilder builder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs; // Same reference
        EqualsBuilder result = builder.append(lhs, rhs);

        assertSame(builder, result);
    }

    @Test(timeout = 4000)
    public void testAppend_WithNulls() {
        EqualsBuilder builder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = null;
        EqualsBuilder result = builder.append(lhs, rhs);

        assertSame(builder, result);
    }

    @Test(timeout = 4000)
    public void testAppend_WithDifferentLengths() {
        EqualsBuilder builder = new EqualsBuilder();
        short[] lhs = {1, 2};
        short[] rhs = {1, 2, 3};
        EqualsBuilder result = builder.append(lhs, rhs);

        assertSame(builder, result);
    }

    @Test(timeout = 4000)
    public void testAppend_WithOneNull() {
        EqualsBuilder builder = new EqualsBuilder();
        short[] lhs = {1, 2};
        short[] rhs = null;
        EqualsBuilder result = builder.append(lhs, rhs);

        assertSame(builder, result);
    }

}