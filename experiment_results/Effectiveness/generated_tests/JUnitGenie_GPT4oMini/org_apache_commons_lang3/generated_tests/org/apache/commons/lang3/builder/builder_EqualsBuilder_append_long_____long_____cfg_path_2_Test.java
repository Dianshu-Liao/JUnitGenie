package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {1L, 2L, 3L};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        // Check if isEquals is set to true
        assertTrue(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        // Check if isEquals is set to false
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L};
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        // Check if isEquals is set to false
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {4L, 5L, 6L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertSame(equalsBuilder, result);
        // Check if isEquals is set to false
        assertFalse(equalsBuilder.isEquals());
    }


}