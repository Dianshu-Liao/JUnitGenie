package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = {1, 2, 3};
        
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

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs; // same reference
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentValues() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {4, 5, 6};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

}