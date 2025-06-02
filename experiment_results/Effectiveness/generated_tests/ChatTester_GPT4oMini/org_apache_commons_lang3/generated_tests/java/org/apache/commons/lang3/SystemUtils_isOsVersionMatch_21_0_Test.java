package org.apache.commons.lang3;

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

public class SystemUtils_isOsVersionMatch_21_0_Test {

    @Test
    public void testIsOsVersionMatch_ExactMatch() throws Exception {
        assertTrue(invokeIsOsVersionMatch("10.0", "10.0"));
    }

    @Test
    public void testIsOsVersionMatch_PrefixMatch() throws Exception {
        assertTrue(invokeIsOsVersionMatch("10.1.2", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_NoMatch() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.2", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_EmptyOsVersion() throws Exception {
        assertFalse(invokeIsOsVersionMatch("", "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_EmptyOsVersionPrefix() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.1", ""));
    }

    @Test
    public void testIsOsVersionMatch_NullOsVersion() throws Exception {
        assertFalse(invokeIsOsVersionMatch(null, "10.1"));
    }

    @Test
    public void testIsOsVersionMatch_NullOsVersionPrefix() throws Exception {
        assertFalse(invokeIsOsVersionMatch("10.1", null));
    }

    private boolean invokeIsOsVersionMatch(String osVersion, String osVersionPrefix) throws Exception {
        Method method = SystemUtils.class.getDeclaredMethod("isOsVersionMatch", String.class, String.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, osVersion, osVersionPrefix);
    }
}
