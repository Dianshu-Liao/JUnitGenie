package org.apache.commons.collections4;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CollectionUtils_size_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSizeWithObjectArray() {
        Object[] objectArray = new Object[5];
        int result = CollectionUtils.size(objectArray);
        assertEquals(5, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNull() {
        int result = CollectionUtils.size(null);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithEmptyObjectArray() {
        Object[] emptyArray = new Object[0];
        int result = CollectionUtils.size(emptyArray);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testSizeWithNonArrayObject() {
        try {
            CollectionUtils.size(new Object());
        } catch (IllegalArgumentException ex) {
            assertEquals("Unsupported object type: java.lang.Object", ex.getMessage());
        }
    }

}