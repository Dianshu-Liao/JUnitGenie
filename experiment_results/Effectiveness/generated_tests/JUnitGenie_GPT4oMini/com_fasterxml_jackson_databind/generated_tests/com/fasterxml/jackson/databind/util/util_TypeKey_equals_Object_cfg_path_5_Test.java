package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class util_TypeKey_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        TypeKey typeKey = new TypeKey();
        assertFalse(typeKey.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        TypeKey typeKey = new TypeKey();
        assertTrue(typeKey.equals(typeKey));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        TypeKey typeKey = new TypeKey();
        String differentClassObject = "Not a TypeKey";
        assertFalse(typeKey.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentTypeKey() {
        TypeKey typeKey1 = new TypeKey(String.class, true);
        TypeKey typeKey2 = new TypeKey(String.class, false);
        assertFalse(typeKey1.equals(typeKey2));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameTypeKey() {
        TypeKey typeKey1 = new TypeKey(String.class, true);
        TypeKey typeKey2 = new TypeKey(String.class, true);
        assertTrue(typeKey1.equals(typeKey2));
    }

}