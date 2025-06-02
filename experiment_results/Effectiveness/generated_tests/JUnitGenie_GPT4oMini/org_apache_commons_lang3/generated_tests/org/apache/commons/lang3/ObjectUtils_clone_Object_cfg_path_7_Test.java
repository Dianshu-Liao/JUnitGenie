package org.apache.commons.lang3;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class ObjectUtils_clone_Object_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testCloneWithNullParameter() {
        try {
            Object result = ObjectUtils.clone(null);
            assertNull("Clone of null should return null", result);
        } catch (Exception e) {
            // Handle the exception if needed
            e.printStackTrace();
        }
    }

}