package com.fasterxml.jackson.core;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Objects;

public class Version_compareTo_13_0_Test {

    @Test
    public void testCompareTo_SameVersion() {
        Version v1 = new Version(1, 0, 0, null, "group", "artifact");
        Version v2 = new Version(1, 0, 0, null, "group", "artifact");
        assertEquals(0, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_DifferentGroupId() {
        Version v1 = new Version(1, 0, 0, null, "groupA", "artifact");
        Version v2 = new Version(1, 0, 0, null, "groupB", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_DifferentArtifactId() {
        Version v1 = new Version(1, 0, 0, null, "group", "artifactA");
        Version v2 = new Version(1, 0, 0, null, "group", "artifactB");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_DifferentMajorVersion() {
        Version v1 = new Version(1, 0, 0, null, "group", "artifact");
        Version v2 = new Version(2, 0, 0, null, "group", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_DifferentMinorVersion() {
        Version v1 = new Version(1, 1, 0, null, "group", "artifact");
        Version v2 = new Version(1, 2, 0, null, "group", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_DifferentPatchLevel() {
        Version v1 = new Version(1, 0, 1, null, "group", "artifact");
        Version v2 = new Version(1, 0, 2, null, "group", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_SnapshotVsRelease() {
        Version v1 = new Version(1, 0, 0, "SNAPSHOT", "group", "artifact");
        Version v2 = new Version(1, 0, 0, null, "group", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_SnapshotVsSnapshot() {
        Version v1 = new Version(1, 0, 0, "alpha", "group", "artifact");
        Version v2 = new Version(1, 0, 0, "beta", "group", "artifact");
        assertEquals(-1, v1.compareTo(v2));
    }

    @Test
    public void testCompareTo_ReleaseVsSnapshot() {
        Version v1 = new Version(1, 0, 0, null, "group", "artifact");
        Version v2 = new Version(1, 0, 0, "alpha", "group", "artifact");
        assertEquals(1, v1.compareTo(v2));
    }
}
