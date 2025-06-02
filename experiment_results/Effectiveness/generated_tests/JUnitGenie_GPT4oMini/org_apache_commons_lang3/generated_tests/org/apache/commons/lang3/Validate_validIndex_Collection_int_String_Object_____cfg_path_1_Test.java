package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.fail;

public class Validate_validIndex_Collection_int_String_Object_____cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testValidIndexThrowsIndexOutOfBoundsException() {
        Collection<Object> collection = new ArrayList<>();
        int index = 1; // Index out of bounds since collection is empty
        String message = "Index out of bounds";
        Object[] values = null; // Values can be null as per constraints

        try {
            Validate.validIndex(collection, index, message, values);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected, test passes
        }
    }

}