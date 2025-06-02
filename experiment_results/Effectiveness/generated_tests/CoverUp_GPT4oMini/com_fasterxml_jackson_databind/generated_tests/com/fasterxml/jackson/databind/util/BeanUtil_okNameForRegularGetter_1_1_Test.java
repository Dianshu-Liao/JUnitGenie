package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;
import java.lang.reflect.Method;
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

public class BeanUtil_okNameForRegularGetter_1_1_Test {

    private AnnotatedMethod annotatedMethodMock;

    @BeforeEach
    public void setUp() throws Exception {
        // Using reflection to create a private constructor
        Method method = AnnotatedMethod.class.getDeclaredMethod("create", Class.class, Method.class, Object.class, Object.class);
        method.setAccessible(true);
        annotatedMethodMock = (AnnotatedMethod) method.invoke(null, Object.class, Object.class.getMethod("toString"), null, null);
    }

    @Test
    public void testOkNameForRegularGetter_GetCallbacks() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "getCallbacks", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_GetMetaClass() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "getMetaClass", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_StdNaming() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "getName", true);
        assertEquals("name", result);
    }

    @Test
    public void testOkNameForRegularGetter_LegacyNaming() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "getName", false);
        assertEquals("Name", result);
    }

    @Test
    public void testOkNameForRegularGetter_InvalidName() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "invalidName", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_EmptyName() throws Exception {
        String result = BeanUtil.okNameForRegularGetter(annotatedMethodMock, "", true);
        assertNull(result);
    }
}
