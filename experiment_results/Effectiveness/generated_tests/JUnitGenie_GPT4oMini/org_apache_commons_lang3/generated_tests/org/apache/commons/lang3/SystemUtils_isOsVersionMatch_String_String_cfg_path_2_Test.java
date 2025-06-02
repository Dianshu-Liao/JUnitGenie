package org.apache.commons.lang3;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.JavaVersion;
import org.junit.Test;
import static org.junit.Assert.*;

public class SystemUtils_isOsVersionMatch_String_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsOsVersionMatch() {
        // Test case where osVersion and osVersionPrefix match
        String osVersion = "10.1";
        String osVersionPrefix = "10.1";
        assertTrue(SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix));

        // Test case where osVersion does not match osVersionPrefix
        osVersion = "10.10";
        osVersionPrefix = "10.1";
        assertFalse(SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix));

        // Test case where osVersion is empty
        osVersion = "";
        osVersionPrefix = "10.1";
        assertFalse(SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix));

        // Test case where osVersion is null
        osVersion = null;
        osVersionPrefix = "10.1";
        try {
            SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix);
            fail("Expected an exception to be thrown");
        } catch (NullPointerException e) {
            // Expected exception
        }

        // Test case where osVersionPrefix is empty
        osVersion = "10.1";
        osVersionPrefix = "";
        assertFalse(SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix));

        // Test case where both osVersion and osVersionPrefix are empty
        osVersion = "";
        osVersionPrefix = "";
        assertFalse(SystemUtils.isOsVersionMatch(osVersion, osVersionPrefix));
    }

}