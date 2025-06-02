package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since isEquals is true and arrays are equal, the result should be the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since both arrays are null, the result should be the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L};
        long[] rhs = {1L, 2L, 3L};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since the lengths are different, the result should be the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = new long[]{1L, 2L, 3L};
        long[] rhs = lhs; // Same reference

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since both references are the same, the result should be the same instance
        assertSame(equalsBuilder, result);
    }

}