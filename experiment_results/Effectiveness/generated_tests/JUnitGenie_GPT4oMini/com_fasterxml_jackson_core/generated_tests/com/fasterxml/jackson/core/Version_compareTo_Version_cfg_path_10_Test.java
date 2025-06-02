package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Version_compareTo_Version_cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testCompareTo_SameInstance() {
        Version version = new Version(1, 0, 0, null);
        int result = version.compareTo(version);
        assertEquals(0, result);
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentInstances() {
        Version version1 = new Version(1, 0, 0, null);
        Version version2 = new Version(1, 0, 0, null);
        int result = version1.compareTo(version2);
        assertEquals(0, result);
    }

}