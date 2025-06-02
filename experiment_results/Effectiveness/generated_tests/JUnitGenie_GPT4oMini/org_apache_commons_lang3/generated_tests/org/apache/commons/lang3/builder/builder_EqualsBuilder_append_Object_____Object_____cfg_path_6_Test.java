package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_Object_____Object_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = {1, 2, 3};
        Object[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = {1, 2, 3};
        Object[] rhs = {1, 2};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }


}