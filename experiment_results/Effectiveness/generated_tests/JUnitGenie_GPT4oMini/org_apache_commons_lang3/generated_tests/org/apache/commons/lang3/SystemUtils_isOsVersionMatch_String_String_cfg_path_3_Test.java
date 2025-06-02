package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class SystemUtils_isOsVersionMatch_String_String_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsOsVersionMatchWithNullOsVersion() {
        String osVersion = null; // This satisfies the constraint for parameter0
        String osVersionPrefix = "10.1"; // This can be any valid string

        try {
            boolean result = SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}