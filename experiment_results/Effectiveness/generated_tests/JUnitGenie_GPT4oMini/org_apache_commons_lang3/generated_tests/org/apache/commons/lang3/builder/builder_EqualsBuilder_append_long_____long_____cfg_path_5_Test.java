package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = {1, 2};

        // This should set isEquals to false
        try {
            equalsBuilder.append(lhs, rhs);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Verify that isEquals is false after the call
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = {1, 2, 3};

        // This should set isEquals to false
        try {
            equalsBuilder.append(lhs, rhs);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Verify that isEquals is false after the call
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = lhs; // Same reference

        // This should not change isEquals
        try {
            equalsBuilder.append(lhs, rhs);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Verify that isEquals remains true
        assertTrue(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1, 2, 3};
        long[] rhs = {1, 2, 3};

        // This should not change isEquals
        try {
            equalsBuilder.append(lhs, rhs);
        } catch (Exception e) {
            fail("Exception should not be thrown");
        }

        // Verify that isEquals remains true
        assertTrue(equalsBuilder.isEquals());
    }


}