package com.fasterxml.jackson.databind.util;
import com.fasterxml.jackson.databind.util.RawValue;
import com.fasterxml.jackson.core.SerializableString;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class util_RawValue_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        RawValue rawValue = new RawValue("test");
        assertTrue(rawValue.equals(rawValue));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        RawValue rawValue = new RawValue("test");
        String differentType = "test";
        assertFalse(rawValue.equals(differentType));
    }

    @Test(timeout = 4000)
    public void testEquals_NullValue() {
        RawValue rawValue = new RawValue("test");
        assertFalse(rawValue.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualValues() {
        RawValue rawValue1 = new RawValue("test");
        RawValue rawValue2 = new RawValue("test");
        assertTrue(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentValues() {
        RawValue rawValue1 = new RawValue("test1");
        RawValue rawValue2 = new RawValue("test2");
        assertFalse(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullField() {
        // Specify the type explicitly to avoid ambiguity
        RawValue rawValue1 = new RawValue((SerializableString) null);
        RawValue rawValue2 = new RawValue((SerializableString) null);
        assertTrue(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_NullAndNonNullField() {
        // Specify the type explicitly to avoid ambiguity
        RawValue rawValue1 = new RawValue((SerializableString) null);
        RawValue rawValue2 = new RawValue("test");
        assertFalse(rawValue1.equals(rawValue2));
    }

}