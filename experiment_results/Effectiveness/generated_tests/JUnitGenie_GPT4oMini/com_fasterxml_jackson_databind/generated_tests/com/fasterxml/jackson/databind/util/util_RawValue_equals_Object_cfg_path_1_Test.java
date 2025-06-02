package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.*;
import org.junit.Test;
import com.fasterxml.jackson.databind.util.RawValue;

public class util_RawValue_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        RawValue value = new RawValue("example");
        assertTrue(value.equals(value));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentTypes() {
        RawValue value = new RawValue("example");
        String differentType = "example";
        assertFalse(value.equals(differentType));
    }

    @Test(timeout = 4000)
    public void testEquals_Null() {
        RawValue value = new RawValue("example");
        assertFalse(value.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentRawValue() {
        RawValue value1 = new RawValue("example1");
        RawValue value2 = new RawValue("example2");
        assertFalse(value1.equals(value2));
    }

    @Test(timeout = 4000)
    public void testEquals_SameValue() {
        RawValue value1 = new RawValue("example");
        RawValue value2 = new RawValue("example");
        assertTrue(value1.equals(value2));
    }

    @Test(timeout = 4000)
    public void testEquals_ProtectedFieldDifference() {
        RawValue value1 = new RawValue("example");
        RawValue value2 = new RawValue("differentValue"); // Changed to a valid String

        // Accessing the protected field _value through reflection
        try {
            java.lang.reflect.Field field = RawValue.class.getDeclaredField("_value");
            field.setAccessible(true);
            field.set(value1, "example");
            // Removed the line that attempted to set a non-String value
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection access failed: " + e.getMessage());
        }

        assertFalse(value1.equals(value2));
    }


}