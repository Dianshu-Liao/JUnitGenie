package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = null;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Check that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = null;
        byte[] rhs = {1, 2, 3};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Check that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {1, 2};

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Check that isEquals is set to false
        try {
            assertFalse("Expected isEquals to be false", result.isEquals());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReferences() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = lhs;

        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        
        // Check that isEquals remains true
        try {
            assertTrue("Expected isEquals to be true", result.isEquals());
        } catch (Exception e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }


}