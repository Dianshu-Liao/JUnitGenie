package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testCloneWithNull() {
        Object obj = null; // This satisfies the condition for isArray to return false
        Object result = ObjectUtils.clone(obj);
        assertNull(result); // Expecting the result to be null since the input is null
    }

    @Test(timeout = 4000)
    public void testCloneWithNonCloneable() {
        Object obj = new Object(); // Non-cloneable object
        Object result = ObjectUtils.clone(obj);
        assertNull(result); // Expecting the result to be null since the object is not Cloneable
    }

    @Test(timeout = 4000)
    public void testCloneWithCloneable() {
        CloneableObject obj = new CloneableObject(); // A cloneable object
        Object result = ObjectUtils.clone(obj);
        assertNotNull(result); // Expecting the result to be not null
        assertNotSame(obj, result); // Expecting a new instance to be returned
    }

    // A simple cloneable class for testing
    private static class CloneableObject implements Cloneable {
        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }

}