package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.lang3.reflect.MemberUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_writeField_Field_Object_Object_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testWriteField_WithForceAccessFalse() {
        try {
            // Setup
            Field field = TestClass.class.getDeclaredField("privateField");
            Object target = new TestClass();
            Object value = "newValue";
            boolean forceAccess = false;

            // Execute
            FieldUtils.writeField(field, target, value, forceAccess);

            // Verify
            assertEquals("newValue", field.get(target));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteField_WithForceAccessTrue() {
        try {
            // Setup
            Field field = TestClass.class.getDeclaredField("privateField");
            Object target = new TestClass();
            Object value = "newValue";
            boolean forceAccess = true;

            // Execute
            FieldUtils.writeField(field, target, value, forceAccess);

            // Verify
            assertEquals("newValue", field.get(target));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteField_WithNullField() {
        try {
            FieldUtils.writeField(null, new TestClass(), "value", true);
            fail("Expected IllegalArgumentException for null field");
        } catch (IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

    private static class TestClass {
        private String privateField = "initialValue";
    }

}