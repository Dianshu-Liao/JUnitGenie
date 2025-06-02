package com.fasterxml.jackson.core;

import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class Version_compareTo_13_0_Test {

    private Version version1;

    private Version version2;

    private Version version3;

    private Version version4;

    private Version version5;

    @BeforeEach
    public void setUp() {
        version1 = new Version(1, 0, 0, null, "groupId1", "artifactId1");
        version2 = new Version(1, 0, 0, null, "groupId1", "artifactId1");
        version3 = new Version(1, 0, 1, null, "groupId1", "artifactId1");
        version4 = new Version(1, 1, 0, null, "groupId1", "artifactId1");
        version5 = new Version(2, 0, 0, null, "groupId1", "artifactId1");
    }

    @Test
    public void testCompareTo_SameObject() {
        assertEquals(0, version1.compareTo(version1));
    }

    @Test
    public void testCompareTo_EqualVersions() {
        assertEquals(0, version1.compareTo(version2));
    }

    @Test
    public void testCompareTo_DifferentPatchLevel() {
        // version1 < version3
        assertEquals(-1, version1.compareTo(version3));
        // version3 > version1
        assertEquals(1, version3.compareTo(version1));
    }

    @Test
    public void testCompareTo_DifferentMinorVersion() {
        // version1 < version4
        assertEquals(-1, version1.compareTo(version4));
        // version4 > version1
        assertEquals(1, version4.compareTo(version1));
    }

    @Test
    public void testCompareTo_DifferentMajorVersion() {
        // version1 < version5
        assertEquals(-1, version1.compareTo(version5));
        // version5 > version1
        assertEquals(1, version5.compareTo(version1));
    }

    @Test
    public void testCompareTo_SnapshotComparison() throws Exception {
        Method isSnapshotMethod = Version.class.getDeclaredMethod("isSnapshot");
        isSnapshotMethod.setAccessible(true);
        Version snapshotVersion = new Version(1, 0, 0, "SNAPSHOT", "groupId1", "artifactId1");
        Version releaseVersion = new Version(1, 0, 0, null, "groupId1", "artifactId1");
        // snapshotVersion < releaseVersion
        assertEquals(-1, version1.compareTo(snapshotVersion));
        assertEquals(1, snapshotVersion.compareTo(releaseVersion));
    }

    @Test
    public void testCompareTo_DifferentGroupId() {
        Version versionDifferentGroupId = new Version(1, 0, 0, null, "groupId2", "artifactId1");
        // version1 < versionDifferentGroupId
        assertEquals(-1, version1.compareTo(versionDifferentGroupId));
        // versionDifferentGroupId > version1
        assertEquals(1, versionDifferentGroupId.compareTo(version1));
    }

    @Test
    public void testCompareTo_DifferentArtifactId() {
        Version versionDifferentArtifactId = new Version(1, 0, 0, null, "groupId1", "artifactId2");
        // version1 < versionDifferentArtifactId
        assertEquals(-1, version1.compareTo(versionDifferentArtifactId));
        // versionDifferentArtifactId > version1
        assertEquals(1, versionDifferentArtifactId.compareTo(version1));
    }
}
