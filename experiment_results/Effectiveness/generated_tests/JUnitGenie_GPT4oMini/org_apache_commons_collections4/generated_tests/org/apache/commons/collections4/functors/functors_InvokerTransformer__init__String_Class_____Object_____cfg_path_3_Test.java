package org.apache.commons.collections4.functors;
import org.apache.commons.collections4.functors.InvokerTransformer;
import org.junit.Test;
import static org.junit.Assert.*;

public class functors_InvokerTransformer__init__String_Class_____Object_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInvokerTransformerWithNullParamTypesAndArgs() {
        try {
            // Arrange
            String methodName = "testMethod";
            Class<?>[] paramTypes = null; // Testing with null paramTypes
            Object[] args = null; // Testing with null args
            
            // Act
            InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
            
            // Assert
            assertNotNull(transformer);
            // Since iMethodName is private and final, we need to access it via reflection
            String actualMethodName = (String) InvokerTransformer.class.getDeclaredField("iMethodName").get(transformer);
            assertEquals(methodName, actualMethodName);
            // iArgs and iParamTypes should also be null
            assertNull(InvokerTransformer.class.getDeclaredField("iArgs").get(transformer));
            assertNull(InvokerTransformer.class.getDeclaredField("iParamTypes").get(transformer));
        } catch (Exception e) {
            fail("Exception was thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testInvokerTransformerWithValidParameters() {
        try {
            // Arrange
            String methodName = "testMethod";
            Class<?>[] paramTypes = new Class<?>[]{String.class};
            Object[] args = new Object[]{"argument"};
            
            // Act
            InvokerTransformer transformer = new InvokerTransformer(methodName, paramTypes, args);
            
            // Assert
            assertNotNull(transformer);
            String actualMethodName = (String) InvokerTransformer.class.getDeclaredField("iMethodName").get(transformer);
            assertEquals(methodName, actualMethodName);
            Class<?>[] actualParamTypes = (Class<?>[]) InvokerTransformer.class.getDeclaredField("iParamTypes").get(transformer);
            assertArrayEquals(paramTypes, actualParamTypes);
            Object[] actualArgs = (Object[]) InvokerTransformer.class.getDeclaredField("iArgs").get(transformer);
            assertArrayEquals(args, actualArgs);
        } catch (Exception e) {
            fail("Exception was thrown: " + e.getMessage());
        }
    }

}