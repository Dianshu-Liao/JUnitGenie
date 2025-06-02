package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class builder_EqualsBuilder_append_boolean_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppend_whenIsEqualsTrueAndLhsNotEqualToRhs_shouldSetIsEqualsToFalse() {
        EqualsBuilder builder = new EqualsBuilder();
        // Set initial condition where isEquals is true
        builder.append(true, false); // here lhs is true and rhs is false
        
        // Verify that isEquals is set to false
        // Since isEquals is private, we can use the isEquals() method to check its value
        assertTrue(!builder.isEquals()); // Use the public method to check the value
    }

    @Test(timeout = 4000)
    public void testAppend_whenIsEqualsTrueAndLhsEqualToRhs_shouldSetIsEqualsToTrue() {
        EqualsBuilder builder = new EqualsBuilder();
        builder.append(true, true); // here lhs and rhs are both true
        
        // Verify that isEquals remains true
        assertTrue(builder.isEquals()); // Use the public method to check the value
    }


}