package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = null;
        byte[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are null, isEquals should be set to false
        assertFalse("isEquals should be false when both arrays are null", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = new byte[]{1, 2, 3};
        byte[] rhs = new byte[]{1, 2};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs have different lengths, isEquals should be set to false
        assertFalse("isEquals should be false when arrays have different lengths", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = new byte[]{1, 2, 3};
        byte[] rhs = lhs; // Same reference

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are the same reference, isEquals should remain true
        assertTrue("isEquals should remain true when both arrays are the same reference", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = new byte[]{1, 2, 3};
        byte[] rhs = new byte[]{1, 2, 4}; // Different content

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs have different contents, isEquals should be set to false
        assertFalse("isEquals should be false when arrays have different contents", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }


}