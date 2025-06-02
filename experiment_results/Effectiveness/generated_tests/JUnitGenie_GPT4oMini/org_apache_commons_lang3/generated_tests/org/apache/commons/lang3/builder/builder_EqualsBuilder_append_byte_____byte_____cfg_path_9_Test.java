package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualByteArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {1, 2, 3};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = new byte[]{1, 2, 3};
        byte[] rhs = lhs; // Same reference
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = null;
        byte[] rhs = {1, 2, 3};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = null;
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2};
        byte[] rhs = {1, 2, 3};
        
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

}