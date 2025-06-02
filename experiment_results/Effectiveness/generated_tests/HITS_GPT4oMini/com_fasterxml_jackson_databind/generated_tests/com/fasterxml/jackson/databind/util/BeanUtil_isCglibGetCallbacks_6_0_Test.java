package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

public class BeanUtil_isCglibGetCallbacks_6_0_Test {

    @Test
    public void testIsCglibGetCallbacks_withArrayTypeCglib() {
        // Arrange
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) net.sf.cglib.proxy.Callback[].class);
        // Act
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert
        assertTrue(result, "Expected true for array type of CGLIB Callback");
    }

    @Test
    public void testIsCglibGetCallbacks_withArrayTypeHibernateCglib() {
        // Arrange
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) net.sf.cglib.proxy.Callback[].class);
        // Act
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert
        assertTrue(result, "Expected true for array type of Hibernate CGLIB Callback");
    }

    @Test
    public void testIsCglibGetCallbacks_withArrayTypeSpringCglib() {
        // Arrange
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) net.sf.cglib.proxy.Callback[].class);
        // Act
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert
        assertTrue(result, "Expected true for array type of Spring CGLIB Callback");
    }

    @Test
    public void testIsCglibGetCallbacks_withNonArrayType() {
        // Arrange
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) String.class);
        // Act
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert
        assertFalse(result, "Expected false for non-array type");
    }
}
