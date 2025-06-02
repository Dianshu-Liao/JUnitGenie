package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Version_compareTo_Version_cfg_path_9_Test {

    @Test(timeout = 4000)
    public void testCompareTo_DifferentGroupId() {
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(2, 0, 0, "beta");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 should be less than version2
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdDifferentArtifactId() {
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(1, 1, 0, "beta");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 should be less than version2
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdSameArtifactIdDifferentMajorVersion() {
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(1, 0, 1, "alpha");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 should be less than version2
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdSameArtifactIdSameMajorVersionDifferentMinorVersion() {
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(1, 1, 0, "alpha");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 should be less than version2
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdSameArtifactIdSameMajorMinorVersionDifferentPatchLevel() {
        Version version1 = new Version(1, 0, 0, "alpha");
        Version version2 = new Version(1, 0, 1, "alpha");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // version1 should be less than version2
    }

    @Test(timeout = 4000)
    public void testCompareTo_SnapshotComparison() {
        Version version1 = new Version(1, 0, 0, "alpha-SNAPSHOT");
        Version version2 = new Version(1, 0, 0, "alpha");
        
        int result = version1.compareTo(version2);
        assertEquals(-1, result); // snapshot should be less than non-snapshot
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameSnapshot() {
        Version version1 = new Version(1, 0, 0, "alpha-SNAPSHOT");
        Version version2 = new Version(1, 0, 0, "alpha-SNAPSHOT");
        
        int result = version1.compareTo(version2);
        assertEquals(0, result); // same snapshots should be equal
    }

}