package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class builder_ReflectionToStringBuilder_validate__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidate_noIntersection() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        try {
            // Set up the protected fields using reflection
            setProtectedField(builder, "includeFieldNames", new String[]{"field1", "field2"});
            setProtectedField(builder, "excludeFieldNames", new String[]{"field3", "field4"});

            // Invoke the private method validate
            invokePrivateValidate(builder);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidate_withIntersection() {
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        try {
            // Set up the protected fields using reflection
            setProtectedField(builder, "includeFieldNames", new String[]{"field1", "field2"});
            setProtectedField(builder, "excludeFieldNames", new String[]{"field2", "field4"});

            // Invoke the private method validate
            invokePrivateValidate(builder);
            fail("Expected IllegalStateException was not thrown");
        } catch (IllegalStateException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception thrown: " + e.getMessage());
        }
    }

    private void invokePrivateValidate(ReflectionToStringBuilder builder) throws Exception {
        Method method = ReflectionToStringBuilder.class.getDeclaredMethod("validate");
        method.setAccessible(true);
        method.invoke(builder);
    }

    private void setProtectedField(ReflectionToStringBuilder builder, String fieldName, String[] value) throws Exception {
        java.lang.reflect.Field field = ReflectionToStringBuilder.class.getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(builder, value);
    }

}