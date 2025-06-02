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

public class BeanUtil_okNameForRegularGetter_1_0_Test {

    @Test
    public void testOkNameForRegularGetter_WithGetCallbacks() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) Object[].class);
        String result = BeanUtil.okNameForRegularGetter(am, "getCallbacks", true);
        assertNull(result, "Expected null for getCallbacks method.");
    }

    @Test
    public void testOkNameForRegularGetter_WithGetMetaClass() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) Object.class);
        String result = BeanUtil.okNameForRegularGetter(am, "getMetaClass", true);
        assertNull(result, "Expected null for getMetaClass method.");
    }

    @Test
    public void testOkNameForRegularGetter_WithValidGetterAndStdNaming() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) String.class);
        String result = BeanUtil.okNameForRegularGetter(am, "getName", true);
        assertEquals("name", result, "Expected name for getter getName with stdNaming true.");
    }

    @Test
    public void testOkNameForRegularGetter_WithValidGetterAndLegacyNaming() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) String.class);
        String result = BeanUtil.okNameForRegularGetter(am, "getName", false);
        assertEquals("name", result, "Expected name for getter getName with stdNaming false.");
    }

    @Test
    public void testOkNameForRegularGetter_WithNonGetterMethod() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        Mockito.when(am.getRawType()).thenReturn((Class) Object.class);
        String result = BeanUtil.okNameForRegularGetter(am, "setName", true);
        assertNull(result, "Expected null for non-getter method setName.");
    }

    @Test
    public void testOkNameForRegularGetter_WithEmptyName() {
        AnnotatedMethod am = Mockito.mock(AnnotatedMethod.class);
        String result = BeanUtil.okNameForRegularGetter(am, "", true);
        assertNull(result, "Expected null for empty name.");
    }
}
