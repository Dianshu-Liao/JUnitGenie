package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCloneWithCloneableObject() {
        // Arrange
        CloneableObject original = new CloneableObject("Test");
        
        // Act
        Object cloned = ObjectUtils.clone(original);
        
        // Assert
        assertNotNull(cloned);
        assertNotSame(original, cloned);
        assertEquals(original.getValue(), ((CloneableObject) cloned).getValue());
    }

    @Test(timeout = 4000)
    public void testCloneWithNonCloneableObject() {
        // Arrange
        NonCloneableObject original = new NonCloneableObject("Test");
        
        // Act
        Object cloned = ObjectUtils.clone(original);
        
        // Assert
        assertNull(cloned);
    }

    @Test(timeout = 4000)
    public void testCloneWhenReflectiveOperationExceptionThrown() {
        // Arrange
        ThrowingCloneableObject original = new ThrowingCloneableObject("Test");
        
        try {
            // Act
            ObjectUtils.clone(original);
            fail("Expected CloneFailedException to be thrown");
        } catch (CloneFailedException e) {
            // Assert
            assertTrue(e.getMessage().contains("Exception cloning Cloneable type"));
        }
    }

    // Custom CloneableObject to test clone method
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

    // NonCloneableObject that is not cloneable
    private static class NonCloneableObject {
        private String value;

        public NonCloneableObject(String value) {
            this.value = value;
        }
    }

    // ThrowingCloneableObject to test exception throwing
    private static class ThrowingCloneableObject extends CloneableObject {
        public ThrowingCloneableObject(String value) {
            super(value);
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException("Clone not supported");
        }
    }

}