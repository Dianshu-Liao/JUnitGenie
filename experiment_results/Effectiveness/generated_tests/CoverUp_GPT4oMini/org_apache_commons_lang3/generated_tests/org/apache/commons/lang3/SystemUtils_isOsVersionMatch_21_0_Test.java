package org.apache.commons.lang3;

import org.apache.commons.lang3.StringUtils;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

class SystemUtils_isOsVersionMatch_21_0_Test {

    @Test
    void testIsOsVersionMatch_NullOsVersion() throws Exception {
        assertFalse(invokeIsOsVersionMatch(null, "10.0"));
    }

    @Test
    void testIsOsVersionMatch_EmptyOsVersion() throws Exception {
        assertFalse(invokeIsOsVersionMatch(StringUtils.EMPTY, "10.0"));
    }

    @Test
    void testIsOsVersionMatch_VersionMatches() throws Exception {
        assertTrue(invokeIsOsVersionMatch("10.0.1", "10.0"));
    }

    @Test
    void testIsOsVersionMatch_VersionDoesNotMatch() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.1", "10.0"));
    }

    @Test
    void testIsOsVersionMatch_VersionWithDifferentLength() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.0.1.1", "10.0"));
    }

    @Test
    void testIsOsVersionMatch_VersionPrefixLongerThanVersion() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.0", "10.0.1"));
    }

    @Test
    void testIsOsVersionMatch_VersionPrefixMatchesExactly() throws Exception {
        assertTrue(invokeIsOsVersionMatch("10.0", "10.0"));
    }

    private boolean invokeIsOsVersionMatch(String osVersion, String osVersionPrefix) throws Exception {
        Method method = SystemUtils.class.getDeclaredMethod("isOsVersionMatch", String.class, String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, osVersion, osVersionPrefix);
    }
}
