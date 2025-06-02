package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_Object_____Object_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = null;
        Object[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are null, isEquals should be set to false
        assertFalse("isEquals should be false when both arrays are null", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = new Object[2];
        Object[] rhs = new Object[3];

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs have different lengths, isEquals should be set to false
        assertFalse("isEquals should be false when arrays have different lengths", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = new Object[] { "test", "example" };
        Object[] rhs = new Object[] { "test", "example" };

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are equal, isEquals should remain true
        assertTrue("isEquals should remain true when arrays are equal", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }


}