package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerModifier;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializer;
import java.lang.reflect.Method;
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
        config = mock(SerializationConfig.class);
        beanDesc = mock(BeanDescription.class);
        serializer = mock(BeanSerializerBase.class);
    }

    @Test
    public void testModifySerializer_WithBeanSerializerBase() {
        // Given a valid BeanSerializerBase
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, serializer);
        // Then it should return an instance of XmlBeanSerializer
        assertNotNull(result);
        assertEquals(XmlBeanSerializer.class, result.getClass());
    }

    @Test
    public void testModifySerializer_WithNonBeanSerializer() {
        // Given a non-BeanSerializerBase serializer
        JsonSerializer<?> nonBeanSerializer = mock(JsonSerializer.class);
        // When modifySerializer is called
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, nonBeanSerializer);
        // Then it should return the same non-BeanSerializer instance
        assertEquals(nonBeanSerializer, result);
    }

    @Test
    public void testModifySerializer_WithNullSerializer() {
        // Given a null serializer
        JsonSerializer<?> result = modifier.modifySerializer(config, beanDesc, null);
        // Then it should return null
        assertEquals(null, result);
    }

    // Reflection test for private methods (if any)
    private void invokePrivateMethod(String methodName, Class<?>... parameterTypes) throws Exception {
        Method method = XmlBeanSerializerModifier.class.getDeclaredMethod(methodName, parameterTypes);
        method.setAccessible(true);
        method.invoke(modifier);
    }
}
