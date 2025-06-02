package com.fasterxml.jackson.databind.util;

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
import com.fasterxml.jackson.databind.introspect.AnnotatedMethod;

public class BeanUtil_okNameForRegularGetter_1_0_Test {

    private BeanUtil beanUtil;

    @BeforeEach
    public void setUp() {
        beanUtil = new BeanUtil();
    }

    @Test
    public void testOkNameForRegularGetter_WithGetCallbacks() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "getCallbacks", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_WithGetMetaClass() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "getMetaClass", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_WithStandardNaming() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "getName", true);
        assertEquals("name", result);
    }

    @Test
    public void testOkNameForRegularGetter_WithLegacyNaming() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "getAge", false);
        assertEquals("age", result);
    }

    @Test
    public void testOkNameForRegularGetter_WithNonGetter() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "setName", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_WithEmptyString() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, "", true);
        assertNull(result);
    }

    @Test
    public void testOkNameForRegularGetter_WithNullName() throws Exception {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = invokeOkNameForRegularGetter(am, null, true);
        assertNull(result);
    }

    private String invokeOkNameForRegularGetter(AnnotatedMethod am, String name, boolean stdNaming) throws Exception {
        Method method = BeanUtil.class.getDeclaredMethod("okNameForRegularGetter", AnnotatedMethod.class, String.class, boolean.class);
        method.setAccessible(true);
        return (String) method.invoke(null, am, name, stdNaming);
    }
}
