package org.apache.commons.jxpath.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ClassLoaderUtil_getClass_3_0_Test {

    @Test
    public void testGetClass_ValidClassName() throws ClassNotFoundException {
        // Test with a valid class name
        Class<?> clazz = ClassLoaderUtil.getClass("java.lang.String");
        assertNotNull(clazz);
        assertEquals("java.lang.String", clazz.getName());
    }

    @Test
    public void testGetClass_InvalidClassName() {
        // Test with an invalid class name
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("invalid.ClassName");
        });
    }

    @Test
    public void testGetClass_EmptyClassName() {
        // Test with an empty class name
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass("");
        });
    }

    @Test
    public void testGetClass_NullClassName() {
        // Test with a null class name
        assertThrows(ClassNotFoundException.class, () -> {
            ClassLoaderUtil.getClass(null);
        });
    }
}
