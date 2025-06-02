package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.exception.CloneFailedException;
import org.junit.Test;
import static org.junit.Assert.*;

public class ObjectUtils_clone_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCloneWithNull() {
        Object obj = null; // This satisfies the constraint that parameter0 must be null
        Object result = ObjectUtils.clone(obj);
        assertNull(result); // Expecting the result to be null when input is null
    }

    @Test(timeout = 4000)
    public void testCloneThrowsCloneFailedException() {
        // Create an object that is Cloneable but throws an exception on clone
        Cloneable obj = new Cloneable() {
            @Override
            protected Object clone() throws CloneNotSupportedException {
                throw new CloneNotSupportedException("Clone not supported");
            }
        };

        try {
            ObjectUtils.clone(obj);
            fail("Expected CloneFailedException to be thrown");
        } catch (CloneFailedException e) {
            assertEquals("Exception cloning Cloneable type java.lang.Object", e.getMessage());
            assertNotNull(e.getCause());
            assertTrue(e.getCause() instanceof CloneNotSupportedException);
        }
    }

}