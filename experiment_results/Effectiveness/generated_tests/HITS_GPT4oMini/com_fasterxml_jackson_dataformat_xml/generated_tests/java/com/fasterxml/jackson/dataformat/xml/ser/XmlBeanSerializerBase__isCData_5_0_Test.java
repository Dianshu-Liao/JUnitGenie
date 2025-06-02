package com.fasterxml.jackson.dataformat.xml.ser;

import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
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

class XmlBeanSerializerBase__isCData_5_0_Test {

    private BeanPropertyWriter mockBeanPropertyWriter;

    private XmlInfo mockXmlInfo;

    @BeforeEach
    void setUp() {
        mockBeanPropertyWriter = mock(BeanPropertyWriter.class);
    }

    @Test
    void testIsCData_WhenXmlInfoIsNull_ReturnsFalse() {
        // Arrange
        when(mockBeanPropertyWriter.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(null);
        // Act
        boolean result = XmlBeanSerializerBase._isCData(mockBeanPropertyWriter);
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsCData_WhenXmlInfoIsNotCData_ReturnsFalse() {
        // Arrange
        mockXmlInfo = new XmlInfo(false, null, null, false);
        when(mockBeanPropertyWriter.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(mockXmlInfo);
        // Act
        boolean result = XmlBeanSerializerBase._isCData(mockBeanPropertyWriter);
        // Assert
        assertFalse(result);
    }

    @Test
    void testIsCData_WhenXmlInfoIsCData_ReturnsTrue() {
        // Arrange
        mockXmlInfo = new XmlInfo(false, null, null, true);
        when(mockBeanPropertyWriter.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(mockXmlInfo);
        // Act
        boolean result = XmlBeanSerializerBase._isCData(mockBeanPropertyWriter);
        // Assert
        assertTrue(result);
    }
}
