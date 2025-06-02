package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCloneWithCloneableObject() {
        // Arrange
        CloneableObject original = new CloneableObject("Test");
        
        // Act
        Object cloned = ObjectUtils.clone(original);
        
        // Assert
        assertNotNull(cloned);
        assertNotSame(original, cloned);
        assertEquals(original.getName(), ((CloneableObject) cloned).getName());
    }

    @Test(timeout = 4000)
    public void testCloneWithArray() {
        // Arrange
        String[] originalArray = {"A", "B", "C"};
        
        // Act
        Object clonedArray = ObjectUtils.clone(originalArray);
        
        // Assert
        assertNotNull(clonedArray);
        assertArrayEquals(originalArray, (String[]) clonedArray);
    }

    @Test(timeout = 4000)
    public void testCloneWithNonCloneableObject() {
        // Arrange
        NonCloneableObject nonCloneable = new NonCloneableObject("Test");
        
        // Act
        Object cloned = ObjectUtils.clone(nonCloneable);
        
        // Assert
        assertNull(cloned);
    }

    @Test(timeout = 4000)
    public void testCloneThrowsCloneFailedException() {
        // Arrange
        ThrowingCloneableObject throwingCloneable = new ThrowingCloneableObject("Test");
        
        // Act
        try {
            ObjectUtils.clone(throwingCloneable);
            fail("Expected CloneFailedException to be thrown");
        } catch (CloneFailedException e) {
            // Assert
            assertNotNull(e);
            assertEquals("Exception cloning Cloneable type " + throwingCloneable.getClass().getName(), e.getMessage());
            assertNotNull(e.getCause());
        }
    }

    // Helper classes for testing
    private static class CloneableObject implements Cloneable {
        private String name;

        public CloneableObject(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        protected Object clone() {
            return new CloneableObject(name);
        }
    }

    private static class NonCloneableObject {
        private String name;

        public NonCloneableObject(String name) {
            this.name = name;
        }
    }

    private static class ThrowingCloneableObject implements Cloneable {
        private String name;

        public ThrowingCloneableObject(String name) {
            this.name = name;
        }

        @Override
        protected Object clone() throws CloneFailedException {
            throw new CloneFailedException("Clone failed", new Exception("Reflection error"));
        }
    }

}