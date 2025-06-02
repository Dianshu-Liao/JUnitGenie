package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_readField_Field_Object_boolean_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testReadFieldWithForceAccess() {
        try {
            // Prepare a test class with a private field
            class TestClass {
                private String secret = "hidden";
            }

            TestClass target = new TestClass();
            Field field = TestClass.class.getDeclaredField("secret");
            boolean forceAccess = true;

            // Call the focal method
            Object result = FieldUtils.readField(field, target, forceAccess);

            // Assert the result
            assertEquals("hidden", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadFieldWithoutForceAccess() {
        try {
            // Prepare a test class with a private field
            class TestClass {
                private String secret = "hidden";
            }

            TestClass target = new TestClass();
            Field field = TestClass.class.getDeclaredField("secret");
            boolean forceAccess = false;

            // Call the focal method
            Object result = FieldUtils.readField(field, target, forceAccess);

            // Assert the result
            assertEquals("hidden", result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testReadFieldWithNullField() {
        try {
            FieldUtils.readField(null, new Object(), true);
            fail("Expected IllegalArgumentException for null field");
        } catch (IllegalArgumentException e) {
            // Expected exception
        } catch (Exception e) {
            fail("Unexpected exception type: " + e.getClass().getName());
        }
    }

    @Test(timeout = 4000)
    public void testReadFieldWithNullTarget() {
        try {
            class TestClass {
                private String secret = "hidden";
            }

            Field field = TestClass.class.getDeclaredField("secret");
            // Specify the type of the method to avoid ambiguity
            Object result = FieldUtils.readField(field, (Object) null, true);
            assertNull(result);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}