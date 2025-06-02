package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class util_TypeKey_equals_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        TypeKey key = new TypeKey();
        assertFalse(key.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        TypeKey key = new TypeKey();
        assertTrue(key.equals(key));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        TypeKey key = new TypeKey();
        String differentClassObject = "Not a TypeKey";
        assertFalse(key.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentTypedKeys() {
        TypeKey key1 = new TypeKey(String.class, true);
        TypeKey key2 = new TypeKey(Integer.class, false);
        assertFalse(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameTypedKeys() {
        TypeKey key1 = new TypeKey(String.class, true);
        TypeKey key2 = new TypeKey(String.class, true);
        assertTrue(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameTypedKeysDifferentClassField() {
        TypeKey key1 = new TypeKey(String.class, true);
        TypeKey key2 = new TypeKey(String.class, true);
        key1._class = null; // Simulating _class being null
        key2._class = null; // Simulating _class being null
        assertTrue(key1.equals(key2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentTypedKeysNullClassField() {
        TypeKey key1 = new TypeKey(String.class, true);
        TypeKey key2 = new TypeKey(String.class, true);
        key1._class = null; // Simulating _class being null
        assertFalse(key1.equals(key2));
    }

}