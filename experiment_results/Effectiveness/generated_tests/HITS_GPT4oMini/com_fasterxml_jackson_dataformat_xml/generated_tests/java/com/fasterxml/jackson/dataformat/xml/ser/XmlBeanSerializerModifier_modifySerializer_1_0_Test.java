package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
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
import com.fasterxml.jackson.dataformat.xml.util.AnnotationUtil;
import com.fasterxml.jackson.dataformat.xml.util.TypeUtil;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;

public class XmlBeanSerializerModifier_modifySerializer_1_0_Test {

    private XmlBeanSerializerModifier modifier;

    private SerializationConfig config;

    private BeanDescription beanDesc;

    private JsonSerializer<?> serializer;

    @BeforeEach
    public void setUp() {
        modifier = new XmlBeanSerializerModifier();
        config = Mockito.mock(SerializationConfig.class);
        beanDesc = Mockito.mock(BeanDescription.class);
        serializer = Mockito.mock(BeanSerializerBase.class);
    }

    @Test
    public void testModifySerializer_WithBeanSerializerBase() {
        // Arrange
        JsonSerializer<?> expectedSerializer = new XmlBeanSerializer((BeanSerializerBase) serializer);
        // Act
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, serializer);
        // Assert
        assertNotNull(result);
        assertSame(expectedSerializer.getClass(), result.getClass());
    }

    @Test
    public void testModifySerializer_WithNonBeanSerializer() {
        // Arrange
        JsonSerializer<?> nonBeanSerializer = Mockito.mock(JsonSerializer.class);
        // Act
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, nonBeanSerializer);
        // Assert
        assertNotNull(result);
        assertSame(nonBeanSerializer, result);
    }

    @Test
    public void testModifySerializer_WithNullSerializer() {
        // Act
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, null);
        // Assert
        assertNotNull(result);
        assertSame(null, result);
    }
}
