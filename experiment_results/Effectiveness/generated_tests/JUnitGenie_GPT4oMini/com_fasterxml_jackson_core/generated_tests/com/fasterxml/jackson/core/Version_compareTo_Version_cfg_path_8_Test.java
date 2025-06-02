package com.fasterxml.jackson.core;
import com.fasterxml.jackson.core.Version;
import org.junit.Test;
import static org.junit.Assert.*;

public class Version_compareTo_Version_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testCompareTo_SameGroupIdAndArtifactId() {
        Version version1 = new Version(1, 0, 0, "snapshot");
        Version version2 = new Version(1, 0, 0, "snapshot");

        assertEquals(0, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentGroupId() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(2, 0, 0, "artifactA");

        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentArtifactId() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(1, 0, 0, "artifactB");

        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentMajorVersion() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(2, 0, 0, "artifactA");

        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentMinorVersion() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(1, 1, 0, "artifactA");

        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentPatchLevel() {
        Version version1 = new Version(1, 0, 0, "artifactA");
        Version version2 = new Version(1, 0, 1, "artifactA");

        assertTrue(version1.compareTo(version2) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_SnapshotVsRelease() {
        Version snapshotVersion = new Version(1, 0, 0, "snapshot");
        Version releaseVersion = new Version(1, 0, 0, null);

        assertTrue(snapshotVersion.compareTo(releaseVersion) < 0);
    }

    @Test(timeout = 4000)
    public void testCompareTo_EqualSnapshots() {
        Version version1 = new Version(1, 0, 0, "snapshot", "20230101", "01");
        Version version2 = new Version(1, 0, 0, "snapshot", "20230101", "01");

        assertEquals(0, version1.compareTo(version2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentSnapshots() {
        Version version1 = new Version(1, 0, 0, "snapshot", "20230101", "01");
        Version version2 = new Version(1, 0, 0, "snapshot", "20230102", "01");

        assertTrue(version1.compareTo(version2) < 0);
    }


}