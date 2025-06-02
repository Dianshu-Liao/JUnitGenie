package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_long_____long_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {1L, 2L, 3L};
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = lhs; // same reference
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLeft() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = null;
        long[] rhs = {1L, 2L, 3L};
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRight() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = null;
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengths() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {1L, 2L};
        long[] rhs = {1L, 2L, 3L};
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithIsEqualsFalse() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.append(1L, 2L); // This will set isEquals to false
        long[] lhs = {1L, 2L, 3L};
        long[] rhs = {1L, 2L, 3L};
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEmptyArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        long[] lhs = {};
        long[] rhs = {};
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);
        assertNotNull(result);
    }

    // Add additional tests as necessary to cover other potential paths


}