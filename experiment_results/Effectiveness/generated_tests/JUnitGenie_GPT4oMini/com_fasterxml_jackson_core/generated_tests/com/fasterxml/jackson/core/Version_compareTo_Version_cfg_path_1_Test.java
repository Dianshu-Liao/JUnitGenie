package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Version_compareTo_Version_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdArtifactIdMajorMinorPatch() {
        Version version1 = new Version(1, 0, 0, null);
        Version version2 = new Version(1, 0, 0, null);
        assertEquals(0, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentGroupId() {
        Version version1 = new Version(1, 0, 0, "groupA");
        Version version2 = new Version(1, 0, 0, "groupB");
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentArtifactId() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(1, 0, 0, "artifactB");
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentMajorVersion() {
        Version version1 = new Version(1, 0, 0, "group", "artifact", "snapshot");
        Version version2 = new Version(2, 0, 0, "group", "artifact", "snapshot");
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentMinorVersion() {
        Version version1 = new Version(1, 0, 0, "group", "artifact", "snapshot");
        Version version2 = new Version(1, 1, 0, "group", "artifact", "snapshot");
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentPatchLevel() {
        Version version1 = new Version(1, 0, 0, "group", "artifact", "snapshot");
        Version version2 = new Version(1, 0, 1, "group", "artifact", "snapshot");
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_SnapshotVsRelease() {
        Version version1 = new Version(1, 0, 0, "group", "artifact", "snapshot");
        Version version2 = new Version(1, 0, 0, "group", "artifact", null);
        assertEquals(-1, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_ReleaseVsSnapshot() {
        Version version1 = new Version(1, 0, 0, "group", "artifact", null);
        Version version2 = new Version(1, 0, 0, "group", "artifact", "snapshot");
        assertEquals(1, version1.compareTo(version2));
    }

}