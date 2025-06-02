package com.fasterxml.jackson.core;

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

    private Version version6;

    @BeforeEach
    public void setUp() {
        version1 = new Version(1, 0, 0, null, "groupId1", "artifactId1");
        version2 = new Version(1, 0, 0, null, "groupId1", "artifactId1");
        version3 = new Version(1, 0, 1, null, "groupId1", "artifactId1");
        version4 = new Version(1, 0, 0, "SNAPSHOT", "groupId1", "artifactId1");
        version5 = new Version(1, 0, 0, null, "groupId1", "artifactId2");
        version6 = new Version(1, 0, 0, null, "groupId2", "artifactId1");
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
        assertEquals(-1, version1.compareTo(version3));
        assertEquals(1, version3.compareTo(version1));
    }

    @Test
    public void testCompareTo_SnapshotVsNonSnapshot() {
        // Snapshot is less than non-snapshot
        assertEquals(-1, version4.compareTo(version1));
        // Non-snapshot is greater than snapshot
        assertEquals(1, version1.compareTo(version4));
    }

    @Test
    public void testCompareTo_DifferentArtifactId() {
        // artifactId1 < artifactId2
        assertEquals(-1, version1.compareTo(version5));
        // artifactId2 > artifactId1
        assertEquals(1, version5.compareTo(version1));
    }

    @Test
    public void testCompareTo_DifferentGroupId() {
        // groupId1 < groupId2
        assertEquals(-1, version1.compareTo(version6));
        // groupId2 > groupId1
        assertEquals(1, version6.compareTo(version1));
    }

    @Test
    public void testCompareTo_MultipleDifferences() {
        Version version7 = new Version(2, 0, 0, null, "groupId1", "artifactId1");
        // major version difference
        assertEquals(-1, version1.compareTo(version7));
        // major version difference
        assertEquals(1, version7.compareTo(version1));
    }
}
