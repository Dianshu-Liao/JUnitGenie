package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_HashCodeBuilder_isRegistered_Object_cfg_path_3_Test {
    
    @Test(timeout = 4000)
    public void testIsRegistered_withNullRegistry() {
        try {
            // Assuming getRegistry is mocked to return null
            // Call the focal method with a sample parameter
            Object sampleValue = new Object();
            boolean result = HashCodeBuilder.isRegistered(sampleValue);
            assertFalse(result); // Expecting false as registry is null
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

}