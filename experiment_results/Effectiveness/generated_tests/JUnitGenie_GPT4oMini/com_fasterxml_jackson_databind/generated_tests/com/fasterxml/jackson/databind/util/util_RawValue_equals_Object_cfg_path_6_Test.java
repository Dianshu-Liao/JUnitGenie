package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_RawValue_equals_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testEqualsWithDifferentObject() {
        RawValue rawValue1 = new RawValue("value1");
        RawValue rawValue2 = new RawValue("value2");
        
        // This will cover the path where o is not the same instance as this
        assertFalse(rawValue1.equals(rawValue2));
    }

}