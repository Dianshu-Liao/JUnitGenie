package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.fail;

public class Validate_validIndex_Collection_int_String_Object_____cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testValidIndexThrowsExceptionWhenIndexIsNegative() {
        Collection<String> collection = new ArrayList<>();
        int index = -1;
        String message = "Index must be non-negative";

        try {
            Validate.validIndex(collection, index, message);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }

    @Test(timeout = 4000)
    public void testValidIndexThrowsExceptionWhenIndexIsGreaterThanSize() {
        Collection<String> collection = new ArrayList<>();
        collection.add("item1");
        int index = 1; // index is equal to size
        String message = "Index must be less than size";

        try {
            Validate.validIndex(collection, index, message);
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            // Exception is expected
        }
    }

    @Test(timeout = 4000)
    public void testValidIndexReturnsCollectionWhenIndexIsValid() {
        Collection<String> collection = new ArrayList<>();
        collection.add("item1");
        int index = 0; // valid index
        String message = "Index is valid";

        Collection<?> result = Validate.validIndex(collection, index, message);
        assert(result == collection); // Check that the returned collection is the same
    }

}