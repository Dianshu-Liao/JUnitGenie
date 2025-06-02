package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.*;

class SimpleBeanPropertyDefinition_getPrimaryType_16_0_Test {

    @Test
    void testGetPrimaryTypeWithNullMember() {
        // Arrange
        SimpleBeanPropertyDefinition propertyDefinition = new SimpleBeanPropertyDefinition(null, null, null, null, null);
        // Act
        JavaType result = propertyDefinition.getPrimaryType();
        // Assert
        assertSame(TypeFactory.unknownType(), result, "Expected unknown type when member is null");
    }

    @Test
    void testGetPrimaryTypeWithValidMember() {
        // Arrange
        AnnotatedMember mockMember = Mockito.mock(AnnotatedMember.class);
        when(mockMember.getType()).thenReturn(TypeFactory.defaultInstance().constructSimpleType(String.class, null));
        SimpleBeanPropertyDefinition propertyDefinition = new SimpleBeanPropertyDefinition(null, mockMember, null, null, null);
        // Act
        JavaType result = propertyDefinition.getPrimaryType();
        // Assert
        assertEquals(TypeFactory.defaultInstance().constructSimpleType(String.class, null), result, "Expected primary type to match the member type");
    }
}
