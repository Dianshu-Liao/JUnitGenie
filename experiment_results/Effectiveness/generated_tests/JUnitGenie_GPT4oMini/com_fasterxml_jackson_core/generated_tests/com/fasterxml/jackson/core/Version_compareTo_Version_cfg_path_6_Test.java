package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Version_compareTo_Version_cfg_path_6_Test {

    @Test(timeout = 4000)
    public void testCompareTo() {
        // Create instances of Version for testing
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(1, 0, 0, "beta");

        // Test comparison of two versions with the same groupId and artifactId but different snapshot info
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 is less than version2

        // Create another version with different major version
        Version version3 = new Version(2, 0, 0, "alpha");
        result = version1.compareTo(version3);
        assertEquals(-1, result); // version1 is less than version3

        // Create another version with different minor version
        Version version4 = new Version(1, 1, 0, "alpha");
        result = version1.compareTo(version4);
        assertEquals(-1, result); // version1 is less than version4

        // Create another version with different patch level
        Version version5 = new Version(1, 0, 1, "alpha");
        result = version1.compareTo(version5);
        assertEquals(-1, result); // version1 is less than version5

        // Create another version that is a snapshot
        Version version6 = new Version(1, 0, 0, "snapshot");
        result = version1.compareTo(version6);
        assertEquals(1, result); // version1 is greater than version6
    }

}