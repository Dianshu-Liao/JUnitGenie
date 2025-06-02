package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;

public class EnumValues_constructFromName_1_0_Test {

    private MapperConfig<?> mockConfig;

    @BeforeEach
    public void setUp() {
        mockConfig = Mockito.mock(MapperConfig.class);
    }

    @Test
    public void testConstructFromName_EnumClassFound() {
        Mockito.when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        Class<Enum<?>> enumClass = (Class<Enum<?>>) (Class<?>) EnumTest.class;
        EnumValues result = EnumValues.constructFromName(mockConfig, enumClass);
        assertNotNull(result);
        assertEquals(enumClass, result.getEnumClass());
    }

    @Test
    public void testConstructFromName_EnumClassWithLowercase() {
        Mockito.when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(true);
        Class<Enum<?>> enumClass = (Class<Enum<?>>) (Class<?>) EnumTest.class;
        EnumValues result = EnumValues.constructFromName(mockConfig, enumClass);
        assertNotNull(result);
        assertEquals(enumClass, result.getEnumClass());
        assertEquals("value_one", getTextual(result)[0].getValue());
        assertEquals("value_two", getTextual(result)[1].getValue());
    }

    @Test
    public void testConstructFromName_EnumClassNotFound() {
        Mockito.when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        Class<Enum<?>> invalidEnumClass = (Class<Enum<?>>) (Class<?>) Object.class;
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            EnumValues.constructFromName(mockConfig, invalidEnumClass);
        });
        assertEquals("Cannot determine enum constants for Class java.lang.Object", thrown.getMessage());
    }

    @Test
    public void testConstructFromName_EnumClassWithNullValues() {
        Mockito.when(mockConfig.isEnabled(EnumFeature.WRITE_ENUMS_TO_LOWERCASE)).thenReturn(false);
        Class<Enum<?>> enumClass = (Class<Enum<?>>) (Class<?>) EnumTestWithNullValues.class;
        EnumValues result = EnumValues.constructFromName(mockConfig, enumClass);
        assertNotNull(result);
        assertEquals(enumClass, result.getEnumClass());
        assertEquals(3, getTextual(result).length);
    }

    private SerializableString[] getTextual(EnumValues enumValues) {
        try {
            Field field = EnumValues.class.getDeclaredField("_textual");
            field.setAccessible(true);
            return (SerializableString[]) field.get(enumValues);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private enum EnumTest {

        VALUE_ONE, VALUE_TWO
    }

    private enum EnumTestWithNullValues {

        VALUE_ONE, VALUE_TWO, VALUE_THREE
    }
}
