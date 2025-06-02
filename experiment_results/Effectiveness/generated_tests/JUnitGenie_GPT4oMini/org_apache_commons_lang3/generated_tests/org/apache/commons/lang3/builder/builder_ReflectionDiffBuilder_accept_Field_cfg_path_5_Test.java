package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testAcceptWithValidField() {
        try {
            // Create an instance of ReflectionDiffBuilder using reflection
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                    .newInstance(new Object(), new Object(), null);

            // Create a field for testing
            Field field = TestClass.class.getDeclaredField("validField");
            field.setAccessible(true);

            // Call the private method accept using reflection
            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            // Assert the expected result
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptWithTransientField() {
        try {
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                    .newInstance(new Object(), new Object(), null);

            Field field = TestClass.class.getDeclaredField("transientField");
            field.setAccessible(true);

            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptWithStaticField() {
        try {
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                    .newInstance(new Object(), new Object(), null);

            Field field = TestClass.class.getDeclaredField("staticField");
            field.setAccessible(true);

            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptWithExcludedField() {
        try {
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                    .newInstance(new Object(), new Object(), null);

            // Set the excludeFieldNames to include "excludedField"
            Field excludeFieldNamesField = ReflectionDiffBuilder.class.getDeclaredField("excludeFieldNames");
            excludeFieldNamesField.setAccessible(true);
            excludeFieldNamesField.set(builder, new String[]{"excludedField"});

            Field field = TestClass.class.getDeclaredField("excludedField");
            field.setAccessible(true);

            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testAcceptWithAnnotatedField() {
        try {
            ReflectionDiffBuilder builder = (ReflectionDiffBuilder) ReflectionDiffBuilder.class
                    .getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                    .newInstance(new Object(), new Object(), null);

            Field field = TestClass.class.getDeclaredField("annotatedField");
            field.setAccessible(true);

            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true);
            boolean result = (boolean) acceptMethod.invoke(builder, field);

            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Test class with various field types
    public static class TestClass {
        public String validField;
        public transient String transientField;
        public static String staticField;
        @DiffExclude
        public String annotatedField;
        public String excludedField;
    }

}