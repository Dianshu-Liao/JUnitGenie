package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynaBeanPropertyPointer_convert_14_4_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = Mockito.mock(DynaBean.class);
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        DynaProperty dynaProperty = Mockito.mock(DynaProperty.class);
        propertyPointer = new DynaBeanPropertyPointer(Mockito.mock(NodePointer.class), dynaBean);
        Mockito.when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        Mockito.when(dynaClass.getDynaProperty(Mockito.anyString())).thenReturn(dynaProperty);
    }

    private Object invokeConvert(Object value, boolean element) throws Exception {
        Method method = DynaBeanPropertyPointer.class.getDeclaredMethod("convert", Object.class, boolean.class);
        method.setAccessible(true);
        return method.invoke(propertyPointer, value, element);
    }

    @Test
    public void testConvertWithPrimitiveType() throws Exception {
        Mockito.when(dynaBean.getDynaClass().getDynaProperty("propertyName")).thenReturn(new DynaProperty("propertyName", int.class));
        Object result = invokeConvert("123", false);
        assertEquals(123, result);
    }

    @Test
    public void testConvertWithObjectType() throws Exception {
        Mockito.when(dynaBean.getDynaClass().getDynaProperty("propertyName")).thenReturn(new DynaProperty("propertyName", String.class));
        Object result = invokeConvert("test", false);
        assertEquals("test", result);
    }

    @Test
    public void testConvertWithArrayType() throws Exception {
        Mockito.when(dynaBean.getDynaClass().getDynaProperty("propertyName")).thenReturn(new DynaProperty("propertyName", String[].class));
        Object result = invokeConvert("test", true);
        assertEquals("test", result);
    }

    @Test
    public void testConvertWithNullValue() throws Exception {
        Mockito.when(dynaBean.getDynaClass().getDynaProperty("propertyName")).thenReturn(new DynaProperty("propertyName", String.class));
        Object result = invokeConvert(null, false);
        assertNull(result);
    }
}
