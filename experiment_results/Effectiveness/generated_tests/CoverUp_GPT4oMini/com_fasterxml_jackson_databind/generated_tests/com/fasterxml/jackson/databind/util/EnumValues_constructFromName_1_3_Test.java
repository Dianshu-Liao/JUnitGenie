package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Constructor;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;

public class EnumValues_constructFromName_1_3_Test {

    private MapperConfig<?> mockConfig;

    private Class<SampleEnum> mockEnumClass;

    @BeforeEach
    public void setUp() {
        mockConfig = mock(MapperConfig.class);
        mockEnumClass = SampleEnum.class;
    }

    @Test
    public void testConstructFromName_WithLowerCaseFeatureEnabled() throws Exception {
        when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(true);
        when(mockConfig.getAnnotationIntrospector().findEnumValues(eq(mockEnumClass), any(), any())).thenReturn(new String[] { "first", "second" });
        EnumValues result = invokeConstructFromName(mockConfig, mockEnumClass);
        assertNotNull(result);
        assertEquals(mockEnumClass, result.getEnumClass());
    }

    @Test
    public void testConstructFromName_WithLowerCaseFeatureDisabled() throws Exception {
        when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        when(mockConfig.getAnnotationIntrospector().findEnumValues(eq(mockEnumClass), any(), any())).thenReturn(new String[] { "FIRST", "SECOND" });
        EnumValues result = invokeConstructFromName(mockConfig, mockEnumClass);
        assertNotNull(result);
        assertEquals(mockEnumClass, result.getEnumClass());
    }

    @Test
    public void testConstructFromName_WithNullEnumValues() throws Exception {
        when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        when(mockConfig.getAnnotationIntrospector().findEnumValues(eq(mockEnumClass), any(), any())).thenReturn(null);
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            invokeConstructFromName(mockConfig, mockEnumClass);
        });
        assertEquals("Cannot determine enum constants for Class " + mockEnumClass.getName(), thrown.getMessage());
    }

    private EnumValues invokeConstructFromName(MapperConfig<?> config, Class<SampleEnum> enumClass) throws Exception {
        Constructor<EnumValues> constructor = EnumValues.class.getDeclaredConstructor(MapperConfig.class, Class.class);
        constructor.setAccessible(true);
        return (EnumValues) constructor.newInstance(config, enumClass);
    }

    // Sample Enum for testing purposes
    private enum SampleEnum {

        FIRST, SECOND
    }
}
