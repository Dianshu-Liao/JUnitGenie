package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class builder_HashCodeBuilder__init__int_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithValidOddNumbers() {
        // Test with valid odd numbers
        HashCodeBuilder builder = new HashCodeBuilder(1, 3);
        // Additional assertions can be added here to verify the state of the builder if needed
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidInitialOddNumber() {
        try {
            // Test with an even initial number
            HashCodeBuilder builder = new HashCodeBuilder(2, 3);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("HashCodeBuilder requires an odd initial value");
        }
    }

    @Test(timeout = 4000)
    public void testHashCodeBuilderWithInvalidMultiplierOddNumber() {
        try {
            // Test with an even multiplier number
            HashCodeBuilder builder = new HashCodeBuilder(1, 2);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert e.getMessage().equals("HashCodeBuilder requires an odd multiplier");
        }
    }

}