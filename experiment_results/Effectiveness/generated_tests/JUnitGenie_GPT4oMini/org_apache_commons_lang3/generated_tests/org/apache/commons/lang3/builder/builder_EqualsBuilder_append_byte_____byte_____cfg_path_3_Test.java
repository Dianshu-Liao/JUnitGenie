package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualByteArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = null;
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

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = lhs;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {4, 5, 6};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        assertSame(equalsBuilder, result);
    }

}