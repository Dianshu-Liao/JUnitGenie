package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_writeField_Field_Object_Object_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testWriteField_WithAccessibleField() {
        try {
            // Arrange
            Field field = TestClass.class.getDeclaredField("accessibleField");
            TestClass target = new TestClass();
            Object value = "New Value";
            boolean forceAccess = false;

            // Act
            FieldUtils.writeField(field, target, value, forceAccess);

            // Assert
            assertEquals("New Value", target.accessibleField);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteField_WithInaccessibleField_ForceAccess() {
        try {
            // Arrange
            Field field = TestClass.class.getDeclaredField("inaccessibleField");
            TestClass target = new TestClass();
            Object value = "New Value";
            boolean forceAccess = true;

            // Act
            FieldUtils.writeField(field, target, value, forceAccess);

            // Assert
            assertEquals("New Value", target.getInaccessibleField());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteField_NullField() {
        try {
            // Arrange
            Field field = null;
            TestClass target = new TestClass();
            Object value = "New Value";
            boolean forceAccess = false;

            // Act
            FieldUtils.writeField(field, target, value, forceAccess);
            fail("Expected IllegalArgumentException for null field");
        } catch (IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    private static class TestClass {
        public String accessibleField;
        private String inaccessibleField;

        public String getInaccessibleField() {
            return inaccessibleField;
        }
    }

}