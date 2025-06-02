package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.IDKey;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.Set;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class builder_HashCodeBuilder_unregister_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testUnregister() {
        try {
            // Access the private static method unregister using reflection
            Method unregisterMethod = HashCodeBuilder.class.getDeclaredMethod("unregister", Object.class);
            unregisterMethod.setAccessible(true);

            // Prepare the test data
            Object testValue = new Object();
            Set<IDKey> registry = HashCodeBuilder.getRegistry();
            registry.add(new IDKey(testValue)); // Add an IDKey to the registry

            // Call the unregister method
            unregisterMethod.invoke(null, testValue);

            // Verify that the IDKey has been removed from the registry
            assertTrue("The registry should be empty after unregistering the value.", registry.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
            // Handle the exception as per rule 4
        }
    }

}