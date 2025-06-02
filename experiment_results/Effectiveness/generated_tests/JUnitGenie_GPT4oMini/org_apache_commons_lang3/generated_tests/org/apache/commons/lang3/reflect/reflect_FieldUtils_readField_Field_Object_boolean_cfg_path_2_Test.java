package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_readField_Field_Object_boolean_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadFieldWithForceAccess() {
        try {
            // Prepare a test class with a private field
            class TestClass {
                private String secret = "hidden";
            }

            // Create an instance of the test class
            TestClass testInstance = new TestClass();
            // Get the private field
            Field field = TestClass.class.getDeclaredField("secret");

            // Call the focal method with forceAccess set to true
            Object result = FieldUtils.readField(field, testInstance, true);
            assertEquals("hidden", result);
        } catch (IllegalAccessException e) {
            fail("Should not have thrown IllegalAccessException");
        } catch (NoSuchFieldException e) {
            fail("Field not found");
        }
    }

    @Test(timeout = 4000)
    public void testReadFieldWithoutForceAccess() {
        try {
            // Prepare a test class with a private field
            class TestClass {
                private String secret = "hidden";
            }

            // Create an instance of the test class
            TestClass testInstance = new TestClass();
            // Get the private field
            Field field = TestClass.class.getDeclaredField("secret");

            // Call the focal method with forceAccess set to false
            Object result = FieldUtils.readField(field, testInstance, false);
            assertEquals("hidden", result);
        } catch (IllegalAccessException e) {
            fail("Should not have thrown IllegalAccessException");
        } catch (NoSuchFieldException e) {
            fail("Field not found");
        }
    }

    @Test(timeout = 4000)
    public void testReadFieldWithNullField() {
        try {
            FieldUtils.readField(null, new Object(), true);
            fail("Should have thrown NullPointerException");
        } catch (IllegalAccessException e) {
            fail("Should not have thrown IllegalAccessException");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }

}