package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.apache.commons.lang3.ClassUtils;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class reflect_MethodUtils_distance_Class_____Class_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testDistance() {
        try {
            // Setup
            Class<?>[] fromClassArray = {String.class, Object.class, Number.class};
            Class<?>[] toClassArray = {String.class, Object.class, Integer.class};

            // Access the private static method 'distance' using reflection
            Method method = MethodUtils.class.getDeclaredMethod("distance", Class[].class, Class[].class);
            method.setAccessible(true);

            // Execute the method
            int result = (Integer) method.invoke(null, new Object[] {fromClassArray, toClassArray});

            // Verify the result
            assertEquals(2, result);
            
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions that might be thrown
        }
    }

}