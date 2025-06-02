package org.apache.commons.lang3;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringUtils_joinWith_String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testJoinWith() {
        String delimiter = ", ";
        Object[] array = {"apple", "banana", "cherry"};
        
        // Testing the joinWith method with valid parameters
        String result = StringUtils.joinWith(delimiter, array);
        assertEquals("apple, banana, cherry", result);
    }

    @Test(timeout = 4000)
    public void testJoinWith_NullArray() {
        String delimiter = ", ";
        Object[] array = null;

        // Testing the joinWith method with a null array to cover the exception case
        try {
            StringUtils.joinWith(delimiter, array);
        } catch (IllegalArgumentException e) {
            assertEquals("Object varargs must not be null", e.getMessage());
        }
    }

}