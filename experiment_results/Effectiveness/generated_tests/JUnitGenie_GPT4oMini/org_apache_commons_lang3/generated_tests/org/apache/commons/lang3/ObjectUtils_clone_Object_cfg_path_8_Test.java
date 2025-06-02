package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testCloneArray() {
        // Arrange: Prepare a test array that is cloneable and non-null
        int[] originalArray = {1, 2, 3};

        // Act: Call the clone method
        int[] clonedArray = (int[]) ObjectUtils.clone(originalArray);

        // Assert: Verify that the original and cloned arrays are equal but not the same reference
        assertArrayEquals(originalArray, clonedArray);
        assertNotSame(originalArray, clonedArray);
    }

    @Test(timeout = 4000)
    public void testCloneObject() {
        // Arrange: Create a cloneable object
        CloneableObject originalObject = new CloneableObject("Test");

        // Act: Call the clone method
        CloneableObject clonedObject = (CloneableObject) ObjectUtils.clone(originalObject);

        // Assert: Verify that the original and cloned objects are not the same reference
        assertNotNull(clonedObject);
        assertNotSame(originalObject, clonedObject);
        assertEquals(originalObject.getValue(), clonedObject.getValue());
    }

    @Test(timeout = 4000)
    public void testCloneNull() {
        // Act: Call the clone method with null
        Object result = ObjectUtils.clone(null);

        // Assert: Verify that the result is null
        assertNull(result);
    }

    @Test(timeout = 4000)
    public void testCloneNonCloneable() {
        // Arrange: Prepare a non-cloneable object
        NonCloneableObject nonCloneableObject = new NonCloneableObject();

        // Act: Call the clone method
        Object result = ObjectUtils.clone(nonCloneableObject);

        // Assert: Verify that the result is null (since the object is not Cloneable)
        assertNull(result);
    }

    private static class CloneableObject implements Cloneable {
        private String value;

        public CloneableObject(String value) {
            this.value = value;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }

        public String getValue() {
            return value;
        }
    }

    private static class NonCloneableObject {
        // A non-cloneable object with no methods for cloning
    }

}