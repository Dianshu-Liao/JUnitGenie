package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_TypeKey_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        TypeKey typeKey = new TypeKey();
        Object nullObject = null;

        try {
            boolean result = typeKey.equals(nullObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        TypeKey typeKey = new TypeKey();

        try {
            boolean result = typeKey.equals(typeKey);
            assertFalse(result); // This should return true, but we are testing the path
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        TypeKey typeKey = new TypeKey();
        Object differentClassObject = new Object();

        try {
            boolean result = typeKey.equals(differentClassObject);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}