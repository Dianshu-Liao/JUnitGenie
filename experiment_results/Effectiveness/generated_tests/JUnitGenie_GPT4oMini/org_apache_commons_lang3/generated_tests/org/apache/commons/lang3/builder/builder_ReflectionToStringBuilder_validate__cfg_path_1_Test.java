package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.fail;

public class builder_ReflectionToStringBuilder_validate__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidateThrowsIllegalStateException() {
        // Arrange
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(new Object());
        try {
            // Set up the protected fields using reflection
            setProtectedField(builder, "includeFieldNames", new String[]{"field1", "field2"});
            setProtectedField(builder, "excludeFieldNames", new String[]{"field2", "field3"});

            // Act
            Method validateMethod = ReflectionToStringBuilder.class.getDeclaredMethod("validate");
            validateMethod.setAccessible(true);
            validateMethod.invoke(builder);

            // If no exception is thrown, fail the test
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Assert
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception: " + e.getMessage());
        }
    }

    private void setProtectedField(ReflectionToStringBuilder builder, String fieldName, Object value) {
        try {
            java.lang.reflect.Field field = ReflectionToStringBuilder.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(builder, value);
        } catch (Exception e) {
            fail("Failed to set protected field: " + e.getMessage());
        }
    }

}