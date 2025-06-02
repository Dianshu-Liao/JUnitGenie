package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = null;

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentLengthArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs;

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithEqualArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendWithIsEqualsFalse() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        equalsBuilder.setEquals(false); // Set isEquals to false
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
    }

}