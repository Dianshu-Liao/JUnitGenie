package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_byte_____byte_____cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {1, 2};

        equalsBuilder.append(lhs, rhs);
        // Since lengths are different, isEquals should be set to false
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = null;
        byte[] rhs = {1, 2, 3};

        equalsBuilder.append(lhs, rhs);
        // Since lhs is null, isEquals should be set to false
        assertFalse(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = lhs; // Same reference

        equalsBuilder.append(lhs, rhs);
        // Since lhs and rhs are the same reference, isEquals should remain true
        assertTrue(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {1, 2, 3};

        equalsBuilder.append(lhs, rhs);
        // Since arrays are equal, isEquals should remain true
        assertTrue(equalsBuilder.isEquals());
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        byte[] lhs = {1, 2, 3};
        byte[] rhs = {3, 2, 1};

        equalsBuilder.append(lhs, rhs);
        // Since arrays are different, isEquals should be set to false
        assertFalse(equalsBuilder.isEquals());
    }


}