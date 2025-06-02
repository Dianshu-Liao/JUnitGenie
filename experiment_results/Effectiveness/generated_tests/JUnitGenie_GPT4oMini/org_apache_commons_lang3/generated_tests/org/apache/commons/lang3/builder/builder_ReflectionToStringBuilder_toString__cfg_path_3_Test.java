package org.apache.commons.lang3.builder;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import static org.junit.Assert.*;

public class builder_ReflectionToStringBuilder_toString__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToStringWithValidObject() {
        // Arrange
        MyClass myObject = new MyClass();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(myObject);

        // Act
        String result = builder.toString();

        // Assert
        assertNotNull(result);
        assertFalse(result.isEmpty());
    }

    @Test(timeout = 4000)
    public void testToStringWithNullObject() {
        // Arrange
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(null);

        // Act
        String result = builder.toString();

        // Assert
        assertNotNull(result);
        assertEquals("null", result); // Assuming getStyle().getNullText() returns "null"
    }

    @Test(timeout = 4000)
    public void testToStringWithSuperclassFields() {
        // Arrange
        SubClass myObject = new SubClass();
        ReflectionToStringBuilder builder = new ReflectionToStringBuilder(myObject);

        // Act
        String result = builder.toString();

        // Assert
        assertNotNull(result);
        assertTrue(result.contains("subField")); // Assuming subField is a field in SubClass
        assertTrue(result.contains("superField")); // Assuming superField is a field in SuperClass
    }

    // Custom classes for testing
    private class MyClass {
        private String field1 = "value1";
        private int field2 = 10;

        // Getters and Setters
    }

    private class SuperClass {
        private String superField = "superValue";
    }

    private class SubClass extends SuperClass {
        private String subField = "subValue";
    }

}