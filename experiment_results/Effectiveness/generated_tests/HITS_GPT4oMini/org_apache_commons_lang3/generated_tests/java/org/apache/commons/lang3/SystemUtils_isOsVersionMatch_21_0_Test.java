package org.apache.commons.lang3;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SystemUtils_isOsVersionMatch_21_0_Test {

    @Test
    public void testIsOsVersionMatch_NullOsVersion() {
        assertFalse(SystemUtils.isOsVersionMatch(null, "10.0"));
    }

    @Test
    public void testIsOsVersionMatch_EmptyOsVersion() {
        assertFalse(SystemUtils.isOsVersionMatch("", "10.0"));
    }

    @Test
    public void testIsOsVersionMatch_NullOsVersionPrefix() {
        assertFalse(SystemUtils.isOsVersionMatch("10.0", null));
    }

    @Test
    public void testIsOsVersionMatch_EmptyOsVersionPrefix() {
        assertFalse(SystemUtils.isOsVersionMatch("10.0", ""));
    }

    @Test
    public void testIsOsVersionMatch_VersionMatch() {
        assertTrue(SystemUtils.isOsVersionMatch("10.0", "10.0"));
    }

    @Test
    public void testIsOsVersionMatch_VersionPrefixMatch() {
        assertTrue(SystemUtils.isOsVersionMatch("10.1.5", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_VersionMismatch() {
        assertFalse(SystemUtils.isOsVersionMatch("10.1", "10.2"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithDifferentLength() {
        assertFalse(SystemUtils.isOsVersionMatch("10.1.5", "10"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithLeadingZeros() {
        assertTrue(SystemUtils.isOsVersionMatch("10.0.0", "10.0"));
        assertFalse(SystemUtils.isOsVersionMatch("10.0.1", "10.0"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithMultipleParts() {
        assertTrue(SystemUtils.isOsVersionMatch("10.0.1.2", "10.0.1"));
        assertFalse(SystemUtils.isOsVersionMatch("10.0.1.2", "10.0.2"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithDifferentFormat() {
        assertTrue(SystemUtils.isOsVersionMatch("10.0.0-beta", "10.0"));
        assertFalse(SystemUtils.isOsVersionMatch("10.0.0-beta", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithNonNumericCharacters() {
        assertTrue(SystemUtils.isOsVersionMatch("10.0-alpha", "10.0"));
        assertFalse(SystemUtils.isOsVersionMatch("10.0-alpha", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_VersionWithSinglePart() {
        assertTrue(SystemUtils.isOsVersionMatch("10", "10"));
        assertFalse(SystemUtils.isOsVersionMatch("10", "11"));
    }
}
