package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs are null, isEquals should be set to false
        assertFalse("isEquals should be false when both arrays are null", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = {1, 2};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Since lhs and rhs have different lengths, isEquals should be set to false
        assertFalse("isEquals should be false when arrays have different lengths", equalsBuilder.isEquals());
        assertSame("The result should be the same EqualsBuilder instance", equalsBuilder, result);
    }


}