// Test method
package com.fasterxml.jackson.dataformat.xml.ser;

// Fixed import
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.lang.reflect.Method;
import com.fasterxml.jackson.dataformat.xml.util.XmlInfo;
import java.util.BitSet;
import java.util.Set;
import javax.xml.namespace.QName;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.impl.ObjectIdWriter;
import com.fasterxml.jackson.databind.ser.impl.WritableObjectId;
import com.fasterxml.jackson.databind.ser.std.BeanSerializerBase;
import com.fasterxml.jackson.databind.util.NameTransformer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.ser.BeanPropertyWriter;
import com.fasterxml.jackson.databind.ser.PropertyFilter;

public class XmlBeanSerializerBase__isCData_5_4_Test {

    private XmlBeanSerializerBase serializerBase;

    @BeforeEach
    public void setUp() {
        // Create a mock of the XmlBeanSerializerBase since it's abstract
        serializerBase = mock(XmlBeanSerializerBase.class, withSettings().useConstructor().defaultAnswer(CALLS_REAL_METHODS));
    }

    @Test
    public void testIsCData_WhenInfoIsNull_ShouldReturnFalse() throws Exception {
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(null);
        Method method = XmlBeanSerializerBase.class.getDeclaredMethod("_isCData", BeanPropertyWriter.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(serializerBase, bpw);
        assertFalse(result);
    }

    @Test
    public void testIsCData_WhenInfoIsNotNullAndIsCData_ShouldReturnTrue() throws Exception {
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        XmlInfo xmlInfo = mock(XmlInfo.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(xmlInfo);
        when(xmlInfo.isCData()).thenReturn(true);
        Method method = XmlBeanSerializerBase.class.getDeclaredMethod("_isCData", BeanPropertyWriter.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(serializerBase, bpw);
        assertTrue(result);
    }

    @Test
    public void testIsCData_WhenInfoIsNotNullAndIsNotCData_ShouldReturnFalse() throws Exception {
        BeanPropertyWriter bpw = mock(BeanPropertyWriter.class);
        XmlInfo xmlInfo = mock(XmlInfo.class);
        when(bpw.getInternalSetting(XmlBeanSerializerBase.KEY_XML_INFO)).thenReturn(xmlInfo);
        when(xmlInfo.isCData()).thenReturn(false);
        Method method = XmlBeanSerializerBase.class.getDeclaredMethod("_isCData", BeanPropertyWriter.class);
        method.setAccessible(true);
        boolean result = (boolean) method.invoke(serializerBase, bpw);
        assertFalse(result);
    }
}
