package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class SystemUtils_isOsVersionMatch_String_String_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testIsOsVersionMatchWithNullOsVersion() {
        String osVersion = null; // This will satisfy the constraint for isEmpty
        String osVersionPrefix = "10.1";

        try {
            boolean result = SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsOsVersionMatchWithEmptyOsVersion() {
        String osVersion = ""; // This will satisfy the constraint for isEmpty
        String osVersionPrefix = "10.1";

        try {
            boolean result = SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsOsVersionMatchWithValidOsVersion() {
        String osVersion = "10.1.5"; // Valid version
        String osVersionPrefix = "10.1";

        try {
            boolean result = SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            assertFalse(result); // Should return false since versions do not match completely
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}