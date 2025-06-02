package org.apache.commons.lang3.reflect;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.junit.Test;
import java.lang.reflect.Field;
import static org.junit.Assert.*;

public class reflect_FieldUtils_readField_Field_Object_boolean_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testReadFieldWithForceAccessFalse() {
        try {
            // Setup
            Field field = MyClass.class.getDeclaredField("myField");
            MyClass target = new MyClass();
            boolean forceAccess = false;

            // Execute
            Object result = FieldUtils.readField(field, target, forceAccess);

            // Verify
            assertNotNull(result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    // A simple class for testing purposes
    private static class MyClass {
        private String myField = "testValue";
    }

}