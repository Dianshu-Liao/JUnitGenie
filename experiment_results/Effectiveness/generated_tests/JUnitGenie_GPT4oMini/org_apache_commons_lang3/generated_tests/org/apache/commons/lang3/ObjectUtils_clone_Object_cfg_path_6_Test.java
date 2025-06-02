package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCloneWithArray() {
        // Given an array of Integer
        Integer[] inputArray = {1, 2, 3};
        
        // When cloning the array
        Integer[] clonedArray = null;
        try {
            clonedArray = (Integer[]) ObjectUtils.clone(inputArray);
        } catch (Exception e) {
            fail("Cloning failed with an exception: " + e.getMessage());
        }
        
        // Then the cloned array should not be null and should have the same values
        assertNotNull(clonedArray);
        assertArrayEquals(inputArray, clonedArray);
    }

    @Test(timeout = 4000)
    public void testCloneWithPrimitiveArray() {
        // Given a primitive array of int
        int[] inputArray = {1, 2, 3};
        
        // When cloning the primitive array
        int[] clonedArray = null;
        try {
            clonedArray = (int[]) ObjectUtils.clone(inputArray);
        } catch (Exception e) {
            fail("Cloning failed with an exception: " + e.getMessage());
        }
        
        // Then the cloned array should not be null and should have the same values
        assertNotNull(clonedArray);
        assertArrayEquals(inputArray, clonedArray);
    }

    @Test(timeout = 4000)
    public void testCloneWithCloneableObject() {
        // Given a Cloneable object
        CloneableObject original = new CloneableObject("clone me");
        
        // When cloning the object
        CloneableObject clonedObject = null;
        try {
            clonedObject = (CloneableObject) ObjectUtils.clone(original);
        } catch (Exception e) {
            fail("Cloning failed with an exception: " + e.getMessage());
        }
        
        // Then the cloned object should not be null and should have the same state
        assertNotNull(clonedObject);
        assertEquals(original.getValue(), clonedObject.getValue());
    }

    @Test(timeout = 4000)
    public void testCloneWithNonCloneableObject() {
        // Given a non-cloneable object (String is not Cloneable)
        String nonCloneable = "I cannot be cloned";
        
        // When cloning the object
        Object clonedObject = ObjectUtils.clone(nonCloneable);
        
        // Then the cloned object should be null
        assertNull(clonedObject);
    }

    private static class CloneableObject implements Cloneable {
        private String value;

        public CloneableObject(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}