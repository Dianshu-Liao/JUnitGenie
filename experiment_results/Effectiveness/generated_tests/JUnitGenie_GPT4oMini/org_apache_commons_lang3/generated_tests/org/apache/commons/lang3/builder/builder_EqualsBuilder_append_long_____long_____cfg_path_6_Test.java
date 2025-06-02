package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertFalse(equalsBuilder.isEquals()); // Use the method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = {1, 2};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertFalse(equalsBuilder.isEquals()); // Use the method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = lhs; // Same reference

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertTrue(equalsBuilder.isEquals()); // Use the method instead of accessing the field directly
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        assertTrue(equalsBuilder.isEquals()); // Use the method instead of accessing the field directly
    }


}