package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.*;

public class JsonPointer_equals_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        JsonPointer pointer = new JsonPointer();
        assertFalse("Equals should return false when compared to null", pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentType() {
        JsonPointer pointer = new JsonPointer();
        assertFalse("Equals should return false when compared to an object of a different type", pointer.equals(new Object()));
    }

    @Test(timeout = 4000)
    public void testEqualsWithSameInstance() {
        JsonPointer pointer = new JsonPointer();
        assertTrue("Equals should return true when comparing the same instance", pointer.equals(pointer));
    }

}