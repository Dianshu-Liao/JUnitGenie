package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import com.fasterxml.jackson.databind.util.RawValue;
import org.junit.Test;
import com.fasterxml.jackson.databind.JsonSerializable;

public class util_RawValue_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_WithSameReference() {
        RawValue rawValue = new RawValue("example");
        assertTrue(rawValue.equals(rawValue));
    }

    @Test(timeout = 4000)
    public void testEquals_WithDifferentType() {
        RawValue rawValue = new RawValue("example");
        String differentTypeObj = "example";
        assertFalse(rawValue.equals(differentTypeObj));
    }

    @Test(timeout = 4000)
    public void testEquals_WithDifferentValues() {
        RawValue rawValue1 = new RawValue("example1");
        RawValue rawValue2 = new RawValue("example2");
        assertFalse(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_WithSameValue() {
        RawValue rawValue1 = new RawValue("example");
        RawValue rawValue2 = new RawValue("example");
        assertTrue(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_WithNullValue() {
        RawValue rawValue = new RawValue((String) null); // Cast to String to resolve ambiguity
        RawValue rawValue2 = new RawValue((String) null); // Cast to String to resolve ambiguity
        assertTrue(rawValue.equals(rawValue2));
    }
    
    @Test(timeout = 4000)
    public void testEquals_WithProtectedValue() {
        RawValue rawValue1 = new RawValue((JsonSerializable) null); // Use a valid constructor
        RawValue rawValue2 = new RawValue((JsonSerializable) null); // Use a valid constructor
        assertTrue(rawValue1.equals(rawValue2)); // Adjusted to check equality with null
    }

}