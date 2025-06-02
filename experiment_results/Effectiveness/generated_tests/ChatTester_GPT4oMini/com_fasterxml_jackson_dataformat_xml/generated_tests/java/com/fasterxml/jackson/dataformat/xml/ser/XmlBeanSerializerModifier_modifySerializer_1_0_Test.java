package com.fasterxml.jackson.dataformat.xml.ser;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.introspect.AnnotatedMember;
import com.fasterxml.jackson.databind.ser.*;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;

public class XmlBeanSerializerModifier_modifySerializer_1_0_Test {

    private final XmlBeanSerializerModifier modifier = new XmlBeanSerializerModifier();

    @Test
    public void testModifySerializer_WithNonBeanSerializer() {
        // Arrange
        SerializationConfig config = mock(SerializationConfig.class);
        BeanDescription beanDesc = mock(BeanDescription.class);
        JsonSerializer<?> nonBeanSerializer = mock(JsonSerializer.class);
        // Act
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, nonBeanSerializer);
        // Assert
        assertSame(nonBeanSerializer, result);
    }

    @Test
    public void testModifySerializer_WithBeanSerializer() {
        // Arrange
        SerializationConfig config = mock(SerializationConfig.class);
        BeanDescription beanDesc = mock(BeanDescription.class);
        BeanSerializerBase beanSerializer = mock(BeanSerializerBase.class);
        // Act
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, beanSerializer);
        // Assert
        assertNotNull(result);
        assertSame(XmlBeanSerializer.class, result.getClass());
    }
}
