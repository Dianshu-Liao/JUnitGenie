package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionDiffBuilder;
import org.junit.Test;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import static org.junit.Assert.assertFalse;

public class builder_ReflectionDiffBuilder_accept_Field_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testAccept_WithFieldNotInExcludeFieldNames() {
        try {
            // Create an instance of ReflectionDiffBuilder using reflection
            ReflectionDiffBuilder builder = 
                (ReflectionDiffBuilder) ReflectionDiffBuilder.class.getDeclaredConstructor(Object.class, Object.class, org.apache.commons.lang3.builder.ToStringStyle.class)
                .newInstance(new Object(), new Object(), null);

            // Prepare a test Field instance
            Field field = SampleClass.class.getDeclaredField("nonExcludedField");
            field.setAccessible(true);
            
            // Call the private method 'accept'
            Method acceptMethod = ReflectionDiffBuilder.class.getDeclaredMethod("accept", Field.class);
            acceptMethod.setAccessible(true); // Make the method accessible
            boolean result = (boolean) acceptMethod.invoke(builder, field);
            
            // Validate the outcome
            assertFalse("The field should be accepted.", result);
        } catch (Exception e) {
            e.printStackTrace(); // Handle exception
        }
    }

    // A sample class to simulate fields
    private static class SampleClass {
        private String nonExcludedField;

        private transient String transientField;

        private static String staticField;
    }

}