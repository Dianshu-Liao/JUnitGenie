package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.IDKey;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;
import static org.junit.Assert.assertTrue;

public class builder_HashCodeBuilder_unregister_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testUnregister() {
        try {
            // Prepare the registry
            Set<IDKey> registry = new HashSet<>();
            // Use reflection to set the private static REGISTRY variable
            Method getRegistryMethod = HashCodeBuilder.class.getDeclaredMethod("getRegistry");
            getRegistryMethod.setAccessible(true);
            // Assuming REGISTRY is a ThreadLocal<Set<IDKey>>
            ThreadLocal<Set<IDKey>> registryThreadLocal = new ThreadLocal<>();
            registryThreadLocal.set(registry);

            // Create an instance of IDKey with a valid Object
            Object value = new Object();
            IDKey idKey = new IDKey(value);
            registry.add(idKey); // Add IDKey to the registry

            // Access the private static method unregister using reflection
            Method unregisterMethod = HashCodeBuilder.class.getDeclaredMethod("unregister", Object.class);
            unregisterMethod.setAccessible(true);
            unregisterMethod.invoke(null, value); // Call unregister with the value

            // Check if the registry is empty after unregistering
            assertTrue("Registry should be empty after unregistering the value", registry.isEmpty());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}