package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class reflect_MethodUtils_distance_Class_____Class_____cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testDistanceWithNonAssignableClasses() {
        try {
            // Prepare the parameters for the test
            Class<?>[] fromClassArray = {String.class};
            Class<?>[] toClassArray = {Integer.class};

            // Access the private static method using reflection
            Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
            method.setAccessible(true);

            // Invoke the method and assert the expected result
            int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);
            assertEquals(-1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}