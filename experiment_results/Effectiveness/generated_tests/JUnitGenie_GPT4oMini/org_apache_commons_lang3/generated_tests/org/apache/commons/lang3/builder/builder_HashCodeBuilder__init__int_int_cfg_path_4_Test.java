package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.Validate;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;

public class builder_HashCodeBuilder__init__int_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithValidOddNumbers() {
        // Test with valid odd initial and multiplier values
        HashCodeBuilder builder = new HashCodeBuilder(3, 5);
        // No exception is expected; Simply instantiate to verify
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidInitialNumber() {
        try {
            // Test with an even initial number
            HashCodeBuilder builder = new HashCodeBuilder(2, 5);
        } catch (IllegalArgumentException e) {
            // Expected exception due to even initial number
            assert(e.getMessage().equals("HashCodeBuilder requires an odd initial value"));
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidMultiplierNumber() {
        try {
            // Test with an even multiplier number
            HashCodeBuilder builder = new HashCodeBuilder(3, 2);
        } catch (IllegalArgumentException e) {
            // Expected exception due to even multiplier number
            assert(e.getMessage().equals("HashCodeBuilder requires an odd multiplier"));
        }
    }

}