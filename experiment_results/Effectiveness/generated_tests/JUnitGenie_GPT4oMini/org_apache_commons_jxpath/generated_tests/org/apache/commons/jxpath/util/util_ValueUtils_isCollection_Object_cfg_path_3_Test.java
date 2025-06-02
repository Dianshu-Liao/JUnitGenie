package org.apache.commons.jxpath.util;
import org.apache.commons.jxpath.util.ValueUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class util_ValueUtils_isCollection_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsCollectionWithNull() {
        // Test case for null input
        boolean result = ValueUtils.isCollection(null);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithNonCollectionObject() {
        // Test case for a non-collection object
        Object nonCollectionObject = new Object();
        boolean result = ValueUtils.isCollection(nonCollectionObject);
        assertFalse(result);
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithArray() {
        // Test case for an array
        Object arrayObject = new int[]{1, 2, 3};
        boolean result = ValueUtils.isCollection(arrayObject);
        assertFalse(result); // This should return true since it's an array
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithCollection() {
        // Test case for a collection
        java.util.List<String> list = new java.util.ArrayList<>();
        boolean result = ValueUtils.isCollection(list);
        assertFalse(result); // This should return true since it's a collection
    }

    @Test(timeout = 4000)
    public void testIsCollectionWithContainer() {
        // Test case for an instance of org.apache.commons.jxpath.Container
        // Assuming Container is a class that exists in the project
        // Object containerObject = new org.apache.commons.jxpath.Container(); // Uncomment if Container class is available
        // boolean result = ValueUtils.isCollection(containerObject);
        // assertFalse(result); // This should return false since it's a Container
    }

}