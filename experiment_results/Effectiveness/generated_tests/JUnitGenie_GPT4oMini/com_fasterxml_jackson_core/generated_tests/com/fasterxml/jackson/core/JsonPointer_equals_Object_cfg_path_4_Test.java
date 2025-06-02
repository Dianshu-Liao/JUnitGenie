package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class JsonPointer_equals_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testEquals_SameInstance() {
        JsonPointer pointer = new JsonPointer();
        assertTrue(pointer.equals(pointer));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        JsonPointer pointer = new JsonPointer();
        assertFalse(pointer.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentType() {
        JsonPointer pointer = new JsonPointer();
        assertFalse(pointer.equals("Not a JsonPointer"));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualPointers() {
        try {
            JsonPointer pointer1 = new JsonPointer("path", 0, "string", null);
            JsonPointer pointer2 = new JsonPointer("path", 0, "string", null);
            assertTrue(pointer1.equals(pointer2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}