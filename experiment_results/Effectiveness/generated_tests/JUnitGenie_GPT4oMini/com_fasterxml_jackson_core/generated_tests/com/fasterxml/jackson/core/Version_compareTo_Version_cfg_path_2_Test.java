package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Version_compareTo_Version_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCompareTo() {
        // Create two Version instances for comparison
        Version version1 = new Version(1, 0, 0, null); // _snapshotInfo is null
        Version version2 = new Version(1, 0, 0, "snapshot"); // _snapshotInfo is "snapshot"

        // Execute the compareTo method
        int result = version1.compareTo(version2);

        // Verify the result
        assertEquals(-1, result); // version1 is a non-snapshot and should be less than version2
    }

}