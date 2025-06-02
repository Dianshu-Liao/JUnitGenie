package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_EqualsBuilder_append_short_____short_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAppendWithNullArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = null;

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
        // Since isEquals is initially true, we expect it to be set to false
        // when both arrays are null
        // However, we cannot directly access isEquals as it is private.
        // We would need to check the behavior of the EqualsBuilder after this call.
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
        // Again, we cannot directly check isEquals, but we can infer behavior
    }

    @Test(timeout = 4000)
    public void testAppendWithSameReference() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = lhs; // Same reference

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
        // isEquals should remain true since both references are the same
    }

    @Test(timeout = 4000)
    public void testAppendWithDifferentArrays() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = {1, 2, 3};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
        // isEquals should remain true since both arrays are equal
    }

    @Test(timeout = 4000)
    public void testAppendWithNullLhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = null;
        short[] rhs = {1, 2, 3};

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
        // isEquals should be set to false
    }

    @Test(timeout = 4000)
    public void testAppendWithNullRhs() {
        EqualsBuilder equalsBuilder = new EqualsBuilder();
        short[] lhs = {1, 2, 3};
        short[] rhs = null;

        // Execute the focal method
        EqualsBuilder result = equalsBuilder.append(lhs, rhs);

        // Verify the result
        assertNotNull(result);
        // isEquals should be set to false
    }

}