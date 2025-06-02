package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class reflect_MethodUtils_distance_Class_____Class_____cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testDistance() {
        try {
            // Prepare test input
            Class<?>[] fromClassArray = {String.class, Object.class};
            Class<?>[] toClassArray = {CharSequence.class, Object.class};

            // Access the private static method using reflection
            Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
            method.setAccessible(true);

            // Invoke the method and capture the result
            int result = (int) method.invoke(null, (Object) fromClassArray, (Object) toClassArray);

            // Assert the expected output
            assertEquals(1, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}