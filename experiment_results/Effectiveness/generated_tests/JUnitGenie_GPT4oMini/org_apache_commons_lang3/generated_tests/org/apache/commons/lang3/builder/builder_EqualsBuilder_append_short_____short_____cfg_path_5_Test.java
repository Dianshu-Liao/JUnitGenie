package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify that isEquals is set to false
        try {
            // Since setEquals(false) is called, we need to check the state of isEquals
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = null;

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs; // Same reference

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify that isEquals remains true
        try {
            assertTrue("Expected isEquals to be true", result.isEquals());
        } catch (Exception e) {
            fail("Exception thrown during test: " + e.getMessage());
        }
    }


}