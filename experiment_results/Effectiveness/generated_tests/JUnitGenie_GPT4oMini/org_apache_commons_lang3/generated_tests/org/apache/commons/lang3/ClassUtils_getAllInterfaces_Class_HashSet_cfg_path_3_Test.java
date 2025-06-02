package org.apache.commons.lang3;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import java.util.HashSet;
import static org.junit.Assert.assertTrue;

public class ClassUtils_getAllInterfaces_Class_HashSet_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetAllInterfaces() {
        try {
            // Prepare the parameters for the focal method
            Class<?> cls = SampleClass.class; // Replace with a class that implements interfaces
            HashSet<Class<?>> interfacesFound = new HashSet<>();

            // Access the private static method using reflection
            Method method = ClassUtils.class.getDeclaredMethod("getAllInterfaces", Class.class, HashSet.class);
            method.setAccessible(true); // Make the method accessible

            // Invoke the method
            method.invoke(null, cls, interfacesFound);

            // Assert that the interfaces were found
            assertTrue(interfacesFound.contains(SampleInterface.class)); // Replace with actual interface to check

        } catch (Exception e) {
            e.printStackTrace(); // Handle the exception as per rule 4
        }
    }

    // Sample class and interface for testing
    interface SampleInterface {}

    class SampleClass implements SampleInterface {}

}