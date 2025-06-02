package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ObjectUtils_clone_Object_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testClone_NonCloneableObject() {
        Object nonCloneableObject = new Object(); // A non-cloneable object
        Object result = null;
        try {
            result = ObjectUtils.clone(nonCloneableObject);
        } catch (Exception e) {
            // Handle exception if necessary
        }
        assertNull(result); // Expecting null since the object is not Cloneable
    }

}