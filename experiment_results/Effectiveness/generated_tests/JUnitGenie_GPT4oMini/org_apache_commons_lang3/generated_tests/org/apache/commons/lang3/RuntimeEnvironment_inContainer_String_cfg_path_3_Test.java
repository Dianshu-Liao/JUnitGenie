package org.apache.commons.lang3;
import org.apache.commons.lang3.RuntimeEnvironment;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class RuntimeEnvironment_inContainer_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testInContainerWithNonExistentPath() {
        String dirPrefix = "/non/existent/path"; // This path does not exist

        try {
            boolean result = RuntimeEnvironment.inContainer(dirPrefix);
            assertFalse(result); // We expect the result to be false since the path does not exist
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}