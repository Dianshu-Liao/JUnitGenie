package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class ClassUtils_getAllInterfaces_Class_HashSet_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetAllInterfacesWithNullClass() {
        try {
            // Prepare the parameters
            Class<?> cls = null;
            HashSet<Class<?>> interfacesFound = new HashSet<>();

            // Access the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
            method.setAccessible(true);

            // Invoke the method
            method.invoke(null, cls, interfacesFound);

            // Verify that interfacesFound is still empty
            assertTrue(interfacesFound.isEmpty());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}