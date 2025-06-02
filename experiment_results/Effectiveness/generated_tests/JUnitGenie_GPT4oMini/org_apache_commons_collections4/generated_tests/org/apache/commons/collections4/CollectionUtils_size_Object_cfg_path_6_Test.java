package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_size_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testSizeWithIterator() {
        // Create an Iterator for testing
        Iterator<String> iterator = Arrays.asList("one", "two", "three").iterator();
        
        // Call the focal method
        int result = CollectionUtils.size(iterator);
        
        // Verify the result
        assertEquals(3, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        // Call the focal method with null
        int result = CollectionUtils.size(null);
        
        // Verify the result
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyIterator() {
        // Create an empty Iterator for testing
        Iterator<String> emptyIterator = Arrays.asList(new String[0]).iterator();
        
        // Call the focal method
        int result = CollectionUtils.size(emptyIterator);
        
        // Verify the result
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithUnsupportedType() {
        // Create an object of an unsupported type
        Object unsupportedObject = new Object();
        
        // Call the focal method and handle the exception
        try {
            CollectionUtils.size(unsupportedObject);
        } catch (IllegalArgumentException ex) {
            // Verify the exception message
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }


}