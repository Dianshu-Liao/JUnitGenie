package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.JsonPointer;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class JsonPointer_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
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
    public void testEquals_EqualJsonPointers() {
        try {
            JsonPointer pointer1 = new JsonPointer("path", 0, "string", null);
            JsonPointer pointer2 = new JsonPointer("path", 0, "string", null);
            assertTrue(pointer1.equals(pointer2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

    @Test(timeout = 4000)
    public void testEquals_NonEqualJsonPointers() {
        try {
            JsonPointer pointer1 = new JsonPointer("path1", 0, "string1", null);
            JsonPointer pointer2 = new JsonPointer("path2", 1, "string2", null);
            assertFalse(pointer1.equals(pointer2));
        } catch (Exception e) {
            // Handle exception if necessary
        }
    }

}