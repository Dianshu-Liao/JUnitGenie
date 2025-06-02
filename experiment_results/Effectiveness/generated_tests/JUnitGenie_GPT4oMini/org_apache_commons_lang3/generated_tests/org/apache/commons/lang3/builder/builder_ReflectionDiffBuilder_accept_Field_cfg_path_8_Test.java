package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testAcceptFieldWithInnerClassSeparator() {
        try {
            // Create an instance of ReflectionDiffBuilder using reflection
            Class<?> clazz = ReflectionDiffBuilder.class;
            Constructor<?> constructor = clazz.getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class);
            constructor.setAccessible(true);
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) constructor.newInstance(null, null, null);

            // Create a mock Field with an inner class separator
            Field field = createMockFieldWithName("Inner$ClassName");
            boolean result = (boolean) invokePrivateMethod(builder, "accept", field);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Object invokePrivateMethod(Object obj, String methodName, Object... args) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, Field.class);
        method.setAccessible(true);
        return method.invoke(obj, args);
    }

    // Mock method to create a Field object for testing
    private Field createMockFieldWithName(String fieldName) throws NoSuchFieldException {
        // Assuming we are mocking a field from a class named MockClass
        return MockClass.class.getDeclaredField(fieldName);
    }

    // Mock class to simulate the existence of a field
    private static class MockClass {
        public String Inner$ClassName;
    }

}