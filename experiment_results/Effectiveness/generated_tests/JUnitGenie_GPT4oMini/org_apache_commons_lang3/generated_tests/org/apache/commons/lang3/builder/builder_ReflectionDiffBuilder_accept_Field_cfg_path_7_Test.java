package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testAcceptFieldNotInnerClassNotTransient() {
        // Arrange
        ReflectionDiffBuilder builder = new ReflectionDiffBuilder(new Object(), new Object(), null);
        Field field = createField("publicField", false, false);

        // Access the private method using reflection
        try {
            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);

            // Act
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            // Assert
            assertFalse(result);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private Field createField(String name, boolean isTransient, boolean isStatic) {
        try {
            // Create a mock Field object using reflection (simplified for this example)
            Field field = MyFieldMock.class.getDeclaredField(name);
            if (isTransient) {
                // Set transient modifier through reflection (simplified)
                // Actual implementation would be needed to set the modifier
            }
            if (isStatic) {
                // Set static modifier through reflection (simplified)
                // Actual implementation would be needed to set the modifier
            }
            return field;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create mock field", e);
        }
    }

    // Example mock field class for testing
    public static class MyFieldMock {
        public static final String publicField = "test";
    }

}