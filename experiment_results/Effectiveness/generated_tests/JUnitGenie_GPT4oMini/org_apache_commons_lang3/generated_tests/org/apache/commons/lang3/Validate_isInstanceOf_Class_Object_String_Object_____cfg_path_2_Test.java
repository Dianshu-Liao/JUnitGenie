package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;

public class Validate_isInstanceOf_Class_Object_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsInstanceOf_withValidArguments() {
        // This should not throw an exception
        Validate.isInstanceOf(String.class, "test", "Expected a String but got: %s", "test");
    }

    @Test(timeout = 4000)
    public void testIsInstanceOf_withInvalidArguments() {
        try {
            // This should throw an IllegalArgumentException
            Validate.isInstanceOf(String.class, new Integer(5), "Expected a String but got: %s", 5);
        } catch (IllegalArgumentException e) {
            // Expected exception
            assert(e.getMessage().equals("Expected a String but got: 5"));
        }
    }

}