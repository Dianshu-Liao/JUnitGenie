package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_TypeKey_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        TypeKey key = new TypeKey();
        assertTrue(key.equals(key)); // Test same instance
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        TypeKey key = new TypeKey();
        assertFalse(key.equals(null)); // Test with null
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        TypeKey key = new TypeKey();
        String differentClassObject = "I'm a string";
        assertFalse(key.equals(differentClassObject)); // Test with different class
    }

    @Test(timeout = 4000)
    public void testEquals_EqualTypedKeys() {
        TypeKey key1 = new TypeKey(String.class, true); // Create first TypeKey
        TypeKey key2 = new TypeKey(String.class, true); // Create second TypeKey with same class and isTyped value
        assertTrue(key1.equals(key2)); // Test equality of two TypeKeys
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentTypedKeys() {
        TypeKey key1 = new TypeKey(String.class, true); // Create TypeKey with isTyped = true
        TypeKey key2 = new TypeKey(Integer.class, true); // Create TypeKey with different class
        assertFalse(key1.equals(key2)); // Test inequality
    }

    @Test(timeout = 4000)
    public void testEquals_NullClassField() {
        TypeKey key1 = new TypeKey((Class<?>) null, true); // Create TypeKey with _class = null
        TypeKey key2 = new TypeKey((Class<?>) null, true); // Create another TypeKey with _class = null
        assertTrue(key1.equals(key2)); // Test equality where both _class fields are null
    }


}