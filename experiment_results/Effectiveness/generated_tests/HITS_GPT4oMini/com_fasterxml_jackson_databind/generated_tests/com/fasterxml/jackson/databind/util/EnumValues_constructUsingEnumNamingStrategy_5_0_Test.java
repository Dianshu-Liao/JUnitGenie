package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;

public class EnumValues_constructUsingEnumNamingStrategy_5_0_Test {

    enum TestEnum {

        VALUE_ONE, VALUE_TWO
    }

    @Test
    public void testConstructUsingEnumNamingStrategy() {
        // Mock the dependencies
        MapperConfig<?> config = mock(MapperConfig.class);
        AnnotatedClass annotatedClass = mock(AnnotatedClass.class);
        EnumNamingStrategy namingStrategy = mock(EnumNamingStrategy.class);
        AnnotationIntrospector ai = mock(AnnotationIntrospector.class);
        // Setup the mock behavior
        when(config.getAnnotationIntrospector()).thenReturn(ai);
        when(config.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        when(annotatedClass.getRawType()).thenReturn((Class) TestEnum.class);
        when(namingStrategy.convertEnumToExternalName(anyString())).thenAnswer(invocation -> invocation.getArgument(0));
        // Call the method under test
        EnumValues enumValues = EnumValues.constructUsingEnumNamingStrategy(config, annotatedClass, namingStrategy);
        // Assertions
        assertNotNull(enumValues);
        assertNotNull(enumValues.getEnumClass());
        assertEquals(TestEnum.class, enumValues.getEnumClass());
        // Accessing the private field _values using reflection to validate
        try {
            java.lang.reflect.Field valuesField = EnumValues.class.getDeclaredField("_values");
            valuesField.setAccessible(true);
            Enum<?>[] values = (Enum<?>[]) valuesField.get(enumValues);
            assertEquals(2, values.length);
            assertEquals(TestEnum.VALUE_ONE, values[0]);
            assertEquals(TestEnum.VALUE_TWO, values[1]);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Could not access _values field: " + e.getMessage());
        }
    }
}
