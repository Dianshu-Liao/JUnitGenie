package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_writeField_Field_Object_Object_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testWriteFieldWithForceAccess() {
        try {
            // Prepare the test data
            Field field = TestClass.class.getDeclaredField("privateField");
            TestClass target = new TestClass();
            Object value = "New Value";
            boolean forceAccess = true;

            // Call the focal method
            FieldUtils.writeField(field, target, value, forceAccess);

            // Verify the result
            assertEquals("New Value", target.getPrivateField());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWriteFieldWithoutForceAccess() {
        try {
            // Prepare the test data
            Field field = TestClass.class.getDeclaredField("privateField");
            TestClass target = new TestClass();
            Object value = "Another Value";
            boolean forceAccess = false;

            // Call the focal method
            FieldUtils.writeField(field, target, value, forceAccess);

            // Verify the result
            assertEquals("Another Value", target.getPrivateField());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    // Test class with a private field for testing purposes
    private static class TestClass {
        private String privateField;

        public String getPrivateField() {
            return privateField;
        }
    }

}