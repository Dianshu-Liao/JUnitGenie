package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_InvokerTransformer__init__String_Class_____Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testInvokerTransformerInitialization() {
        String methodName = "testMethod";
        Class<?>[] paramTypes = {String.class, Integer.class};
        Object[] args = {"arg1", 2};

        try {
            InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
            // Accessing private fields using reflection for verification
            java.lang.reflect.Field methodNameField = InvokerTransformer.class.getDeclaredField("iMethodName");
            methodNameField.setAccessible(true);
            String actualMethodName = (String) methodNameField.get(transformer);
            assertEquals(methodName, actualMethodName);

            java.lang.reflect.Field paramTypesField = InvokerTransformer.class.getDeclaredField("iParamTypes");
            paramTypesField.setAccessible(true);
            Class<?>[] actualParamTypes = (Class<?>[]) paramTypesField.get(transformer);
            assertArrayEquals(paramTypes, actualParamTypes);

            java.lang.reflect.Field argsField = InvokerTransformer.class.getDeclaredField("iArgs");
            argsField.setAccessible(true);
            Object[] actualArgs = (Object[]) argsField.get(transformer);
            assertArrayEquals(args, actualArgs);
        } catch (Exception e) {
            fail("Exception occurred during test: " + e.getMessage());
        }
    }

}