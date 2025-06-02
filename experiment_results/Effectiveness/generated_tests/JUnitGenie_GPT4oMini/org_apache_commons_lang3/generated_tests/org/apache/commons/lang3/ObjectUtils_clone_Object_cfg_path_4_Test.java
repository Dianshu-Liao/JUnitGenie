package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testCloneWithNull() {
        Object obj = null; // This satisfies the condition for isArray to return false
        Object result = ObjectUtils.clone(obj);
        assertNull(result); // Expecting the result to be null since obj is null
    }

    @Test(timeout = 4000)
    public void testCloneWithCloneable() {
        CloneableObject obj = new CloneableObject();
        Object result = ObjectUtils.clone(obj);
        assertNotNull(result); // Expecting a non-null result
        assertNotSame(obj, result); // Expecting a different instance
    }

    @Test(timeout = 4000)
    public void testCloneThrowsCloneFailedException() {
        NonCloneableObject obj = new NonCloneableObject();
        try {
            ObjectUtils.clone(obj);
            fail("Expected CloneFailedException to be thrown");
        } catch (CloneFailedException e) {
            // Expected exception
        }
    }

    // Helper classes for testing
    private static class CloneableObject implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

    private static class NonCloneableObject {
        // No clone method
    }

}