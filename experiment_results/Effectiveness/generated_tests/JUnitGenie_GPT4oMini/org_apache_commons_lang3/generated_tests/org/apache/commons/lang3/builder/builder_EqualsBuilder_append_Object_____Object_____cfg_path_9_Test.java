package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_Object_____Object_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = {1, 2, 3};
        Object[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Verify that the result is the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = null;
        Object[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Verify that the result is the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = {1, 2};
        Object[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Verify that the result is the same instance
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = new Object[]{1, 2, 3};
        Object[] rhs = lhs; // Same reference

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Verify that the result is the same instance
        assertSame(equalsBuilder, result);
    }

}