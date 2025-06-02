package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.dataformat.xml.ser.XmlBeanSerializerBase;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.util.BitSet;
import java.util.Set;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.PropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;

class XmlBeanSerializerBase__isCData_5_1_Test {

    @Test
    void testIsCDataWhenInfoIsNull() throws Exception {
        // Arrange
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(null);
        // Act
        boolean result = invokeIsCData(bpw);
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsCDataWhenInfoIsNotCData() throws Exception {
        // Arrange
        XmlInfo xmlInfo = new XmlInfo(false, null, null, false);
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(xmlInfo);
        // Act
        boolean result = invokeIsCData(bpw);
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsCDataWhenInfoIsCData() throws Exception {
        // Arrange
        XmlInfo xmlInfo = new XmlInfo(false, null, null, true);
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(xmlInfo);
        // Act
        boolean result = invokeIsCData(bpw);
        // Assert
        assertTrue(result);
    }

    private boolean invokeIsCData(BeanPropertyWriter bpw) throws Exception {
        Method method = XmlBeanSerializerBase.class.getDeclaredMethod("_isCData", BeanPropertyWriter.class);
        method.setAccessible(true);
        return (boolean) method.invoke(null, bpw);
    }
}
