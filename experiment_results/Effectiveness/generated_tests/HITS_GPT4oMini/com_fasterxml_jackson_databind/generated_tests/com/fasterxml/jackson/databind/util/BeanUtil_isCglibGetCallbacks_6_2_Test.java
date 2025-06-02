// Adjust this package name as necessary
package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

public class BeanUtil_isCglibGetCallbacks_6_2_Test {

    // Mock classes to represent CGLIB callbacks
    interface CglibCallback {
    }

    interface HibernateCglibCallback {
    }

    interface SpringCglibCallback {
    }

    @Test
    public void testIsCglibGetCallbacks_WithCglibArrayType_ReturnsTrue() {
        // Mock an AnnotatedMethod that returns an array type of CGLIB Callback
        Class<?> cglibCallbackArrayType = CglibCallback[].class;
        AnnotatedMethod am = mock(AnnotatedMethod.class);
        when(am.getRawType()).thenReturn((Class) cglibCallbackArrayType);
        // Call the method under test
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert the result
        assertTrue(result, "Expected true for CGLIB Callback array type");
    }

    @Test
    public void testIsCglibGetCallbacks_WithHibernateCglibArrayType_ReturnsTrue() {
        // Mock an AnnotatedMethod that returns an array type of Hibernate CGLIB Callback
        Class<?> hibernateCglibCallbackArrayType = HibernateCglibCallback[].class;
        AnnotatedMethod am = mock(AnnotatedMethod.class);
        when(am.getRawType()).thenReturn((Class) hibernateCglibCallbackArrayType);
        // Call the method under test
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert the result
        assertTrue(result, "Expected true for Hibernate CGLIB Callback array type");
    }

    @Test
    public void testIsCglibGetCallbacks_WithSpringCglibArrayType_ReturnsTrue() {
        // Mock an AnnotatedMethod that returns an array type of Spring CGLIB Callback
        Class<?> springCglibCallbackArrayType = SpringCglibCallback[].class;
        AnnotatedMethod am = mock(AnnotatedMethod.class);
        when(am.getRawType()).thenReturn((Class) springCglibCallbackArrayType);
        // Call the method under test
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert the result
        assertTrue(result, "Expected true for Spring CGLIB Callback array type");
    }

    @Test
    public void testIsCglibGetCallbacks_WithNonCglibArrayType_ReturnsFalse() {
        // Mock an AnnotatedMethod that returns a non-CGLIB array type
        Class<?> nonCglibArrayType = String[].class;
        AnnotatedMethod am = mock(AnnotatedMethod.class);
        when(am.getRawType()).thenReturn((Class) nonCglibArrayType);
        // Call the method under test
        boolean result = BeanUtil.isCglibGetCallbacks(am);
        // Assert the result
        assertFalse(result, "Expected false for non-CGLIB array type");
    }
}
