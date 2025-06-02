package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class SystemUtils_isOsVersionMatch_String_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsOsVersionMatchWithEmptyOsVersion() {
        String osVersion = null; // This will trigger the isEmpty check
        String osVersionPrefix = "10.1";

        try {
            boolean result = SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            assertFalse(result);
        } catch (Exception e) {
            // Handle the exception if necessary
        }
    }

}