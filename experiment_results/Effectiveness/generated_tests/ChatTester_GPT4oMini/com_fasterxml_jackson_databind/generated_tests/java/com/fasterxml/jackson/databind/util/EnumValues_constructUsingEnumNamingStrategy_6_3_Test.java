package com.fasterxml.jackson.databind.util;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.core.SerializableString;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.EnumFeature;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.AnnotatedClass;

class EnumValues_constructUsingEnumNamingStrategy_6_3_Test {

    private EnumValues enumValues;

    private MapperConfig<?> mockConfig;

    private Class<Enum<?>> mockEnumClass;

    private EnumNamingStrategy mockNamingStrategy;

    @BeforeEach
    void setUp() {
        mockConfig = mock(MapperConfig.class);
        mockEnumClass = mock(Class.class);
        mockNamingStrategy = mock(EnumNamingStrategy.class);
    }

    @Test
    void testConstructUsingEnumNamingStrategy_ValidEnum() {
        // Arrange
        Enum<?> mockEnum = mock(Enum.class);
        when(mockEnum.name()).thenReturn("TEST");
        when(mockEnumClass.getEnumConstants()).thenReturn(new Enum<?>[] { mockEnum });
        when(mockNamingStrategy.convertEnumToExternalName("TEST")).thenReturn("test_external");
        // Act
        EnumValues result = EnumValues.constructUsingEnumNamingStrategy(mockConfig, mockEnumClass, mockNamingStrategy);
        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on the expected state of `result`
    }

    @Test
    void testConstructUsingEnumNamingStrategy_EnumConstantsNull() {
        // Arrange
        when(mockEnumClass.getEnumConstants()).thenReturn(null);
        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> EnumValues.constructUsingEnumNamingStrategy(mockConfig, mockEnumClass, mockNamingStrategy));
        assertEquals("Cannot determine enum constants for Class " + mockEnumClass.getName(), exception.getMessage());
    }

    @Test
    void testConstructUsingEnumNamingStrategy_EmptyEnum() {
        // Arrange
        when(mockEnumClass.getEnumConstants()).thenReturn(new Enum<?>[] {});
        // Act
        EnumValues result = EnumValues.constructUsingEnumNamingStrategy(mockConfig, mockEnumClass, mockNamingStrategy);
        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on the expected state of `result`
    }

    @Test
    void testConstructUsingEnumNamingStrategy_MultipleEnums() {
        // Arrange
        Enum<?> mockEnum1 = mock(Enum.class);
        Enum<?> mockEnum2 = mock(Enum.class);
        when(mockEnum1.name()).thenReturn("FIRST");
        when(mockEnum2.name()).thenReturn("SECOND");
        when(mockEnumClass.getEnumConstants()).thenReturn(new Enum<?>[] { mockEnum1, mockEnum2 });
        when(mockNamingStrategy.convertEnumToExternalName("FIRST")).thenReturn("first_external");
        when(mockNamingStrategy.convertEnumToExternalName("SECOND")).thenReturn("second_external");
        // Act
        EnumValues result = EnumValues.constructUsingEnumNamingStrategy(mockConfig, mockEnumClass, mockNamingStrategy);
        // Assert
        assertNotNull(result);
        // Additional assertions can be added based on the expected state of `result`
    }
}
