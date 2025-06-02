package com.fasterxml.jackson.databind.util;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import com.fasterxml.jackson.databind.util.RawValue;

public class util_RawValue_equals_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        RawValue rawValue = new RawValue("test");
        assertTrue(rawValue.equals(rawValue));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        RawValue rawValue = new RawValue("test");
        assertFalse(rawValue.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        RawValue rawValue = new RawValue("test");
        assertFalse(rawValue.equals("test"));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualRawValue() {
        RawValue rawValue1 = new RawValue("test");
        RawValue rawValue2 = new RawValue("test");
        assertTrue(rawValue1.equals(rawValue2));
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualRawValue() {
        RawValue rawValue1 = new RawValue("test1");
        RawValue rawValue2 = new RawValue("test2");
        assertFalse(rawValue1.equals(rawValue2));
    }

}