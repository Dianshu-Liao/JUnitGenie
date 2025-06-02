package org.apache.commons.lang3;
import org.apache.commons.lang3.Validate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

public class Validate_validIndex_Collection_int_String_Object_____cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testValidIndex() {
        Collection<String> collection = new ArrayList<>();
        collection.add("item1");
        collection.add("item2");
        
        // Test valid index
        int index = 1;
        String message = "Index is out of bounds";
        Object[] values = {};
        
        Collection<String> result = Validate.validIndex(collection, index, message, values);
        assertEquals(collection, result);
    }

    @Test(timeout = 4000)
    public void testValidIndexThrowsExceptionForNegativeIndex() {
        Collection<String> collection = new ArrayList<>();
        collection.add("item1");
        
        int index = -1;
        String message = "Index is out of bounds";
        Object[] values = {};
        
        try {
            Validate.validIndex(collection, index, message, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index is out of bounds", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testValidIndexThrowsExceptionForIndexGreaterThanSize() {
        Collection<String> collection = new ArrayList<>();
        collection.add("item1");
        
        int index = 1; // index is greater than the size of the collection
        String message = "Index is out of bounds";
        Object[] values = {};
        
        try {
            Validate.validIndex(collection, index, message, values);
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Index is out of bounds", e.getMessage());
        }
    }

}