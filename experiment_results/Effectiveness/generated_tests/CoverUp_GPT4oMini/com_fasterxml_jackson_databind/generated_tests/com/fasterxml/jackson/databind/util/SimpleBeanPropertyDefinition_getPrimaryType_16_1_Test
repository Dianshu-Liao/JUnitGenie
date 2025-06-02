package com.fasterxml.jackson.databind.util;

import com.fasterxml.jackson.databind.type.TypeFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import com.fasterxml.jackson.databind.introspect.*;

@ExtendWith(MockitoExtension.class)
class SimpleBeanPropertyDefinition_getPrimaryType_16_1_Test {

    private SimpleBeanPropertyDefinition propertyDefinition;

    private AnnotatedMember mockedMember;

    @BeforeEach
    void setUp() {
        mockedMember = mock(AnnotatedMember.class);
    }

    @Test
    void testGetPrimaryTypeWhenMemberIsNull() {
        propertyDefinition = new SimpleBeanPropertyDefinition(null, null, null, null, null);
        JavaType result = propertyDefinition.getPrimaryType();
        assertSame(TypeFactory.unknownType(), result);
    }

    @Test
    void testGetPrimaryTypeWhenMemberIsNotNull() {
        JavaType mockType = mock(JavaType.class);
        when(mockedMember.getType()).thenReturn(mockType);
        propertyDefinition = new SimpleBeanPropertyDefinition(null, mockedMember, null, null, null);
        JavaType result = propertyDefinition.getPrimaryType();
        assertSame(mockType, result);
    }
}
