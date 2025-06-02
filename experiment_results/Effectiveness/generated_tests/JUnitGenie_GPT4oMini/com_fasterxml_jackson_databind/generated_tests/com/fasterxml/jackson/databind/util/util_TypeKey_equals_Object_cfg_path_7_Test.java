package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.TypeKey;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_TypeKey_equals_Object_cfg_path_7_Test {

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

}