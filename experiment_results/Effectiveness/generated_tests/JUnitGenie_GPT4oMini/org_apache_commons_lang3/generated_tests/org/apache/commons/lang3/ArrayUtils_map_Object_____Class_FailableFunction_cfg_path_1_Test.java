package org.apache.commons.lang3;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.function.FailableFunction;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertArrayEquals;

public class ArrayUtils_map_Object_____Class_FailableFunction_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testMap() {
        try {
            // Prepare input data
            String[] inputArray = {"1", "2", "3"};
            Class<String> componentType = String.class;

            // Implementing the FailableFunction interface
            FailableFunction<String, String, Exception> mapper = new FailableFunction<String, String, Exception>() {
                @Override
                public String apply(String s) throws Exception {
                    return s + " processed";
                }
            };

            // Accessing the private static method using reflection
            Method method = ArrayUtils.class.getDeclaredMethod("map", Object[].class, Class.class, FailableFunction.class);
            method.setAccessible(true);

            // Invoking the method
            String[] resultArray = (String[]) method.invoke(null, (Object) inputArray, componentType, mapper);

            // Expected output
            String[] expectedArray = {"1 processed", "2 processed", "3 processed"};

            // Assert the result
            assertArrayEquals(expectedArray, resultArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}