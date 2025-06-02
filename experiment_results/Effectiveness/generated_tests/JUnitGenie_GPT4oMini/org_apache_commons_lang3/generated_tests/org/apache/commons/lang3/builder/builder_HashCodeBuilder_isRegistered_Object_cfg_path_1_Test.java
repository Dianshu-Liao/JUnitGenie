package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_HashCodeBuilder_isRegistered_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsRegistered() {
        // Assuming getRegistry() returns a non-null Set containing an IDKey with the value "testValue"
        Object testValue = "testValue";
        
        try {
            boolean result = HashCodeBuilder.isRegistered(testValue);
            assertTrue(result); // Expecting true if the value is registered
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}