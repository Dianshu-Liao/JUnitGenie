package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_Object_____Object_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppend_withDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = new Object[]{1, 2};
        Object[] rhs = new Object[]{1};

        // The expected behavior is that equalsBuilder will set isEquals to false
        try {
            EqualsBuilder result = equalsBuilder.append(lhs, rhs);
            assertFalse(result.isEquals()); // Changed to use the method
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppend_withNull() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = null;
        Object[] rhs = new Object[]{1, 2};

        // The expected behavior is that equalsBuilder will set isEquals to false
        try {
            EqualsBuilder result = equalsBuilder.append(lhs, rhs);
            assertFalse(result.isEquals()); // Changed to use the method
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppend_withEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = new Object[]{1, 2, 3};
        Object[] rhs = new Object[]{1, 2, 3};

        // The expected behavior is that isEquals remains true
        try {
            EqualsBuilder result = equalsBuilder.append(lhs, rhs);
            assertTrue(result.isEquals()); // Changed to use the method
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppend_withBothNull() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        Object[] lhs = null;
        Object[] rhs = null;

        // The expected behavior is that isEquals remains true
        try {
            EqualsBuilder result = equalsBuilder.append(lhs, rhs);
            assertTrue(result.isEquals()); // Changed to use the method
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testAppend_isEqualsFalseScenario() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.setEquals(false); // Set isEquals to false directly

        Object[] lhs = new Object[]{1, 2};
        Object[] rhs = new Object[]{1, 3};

        // isEquals should remain false
        try {
            EqualsBuilder result = equalsBuilder.append(lhs, rhs);
            assertFalse(result.isEquals()); // Changed to use the method
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


}