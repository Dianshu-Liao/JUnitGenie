package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testAcceptWithTransientField() {
        try {
            // Create an instance of ReflectionDiffBuilder using reflection
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructors()[0].newInstance(new Object[]{}, new Object[]{});

            // Create a transient field
            Field transientField = TestClass.class.getDeclaredField("transientField");

            // Invoke the private method accept using reflection
            boolean result = (boolean) ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class)
                    .invoke(builder, transientField);

            // Assert that the result is false
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptWithStaticField() {
        try {
            // Create an instance of ReflectionDiffBuilder using reflection
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructors()[0].newInstance(new Object[]{}, new Object[]{});

            // Create a static field
            Field staticField = TestClass.class.getDeclaredField("staticField");

            // Invoke the private method accept using reflection
            boolean result = (boolean) ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class)
                    .invoke(builder, staticField);

            // Assert that the result is false
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test class with fields for testing
    public static class TestClass {
        public static int staticField;
        public transient int transientField;
    }

}