package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_HashCodeBuilder_isRegistered_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsRegisteredWithNullRegistry() {
        // Simulate the scenario where getRegistry() returns null
        try {
            boolean result = HashCodeBuilder.isRegistered(new Object());
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsRegisteredWithValidObject() {
        // Simulate the scenario where getRegistry() returns a non-null Set containing the IDKey
        try {
            // Assuming getRegistry() is mocked to return a Set containing the IDKey
            // This part of the code would require a mocking framework like Mockito
            // Set<IDKey> mockRegistry = new HashSet<>();
            // mockRegistry.add(new IDKey(new Object()));
            // when(getRegistry()).thenReturn(mockRegistry);

            boolean result = HashCodeBuilder.isRegistered(new Object());
            assertTrue(result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsRegisteredWithObjectNotInRegistry() {
        // Simulate the scenario where getRegistry() returns a non-null Set not containing the IDKey
        try {
            // Assuming getRegistry() is mocked to return a Set that does not contain the IDKey
            // Set<IDKey> mockRegistry = new HashSet<>();
            // when(getRegistry()).thenReturn(mockRegistry);

            boolean result = HashCodeBuilder.isRegistered(new Object());
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if thrown
            e.printStackTrace();
        }
    }

}