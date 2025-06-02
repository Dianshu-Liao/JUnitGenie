package org.apache.commons.jxpath.ri.model.dynabeans;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynaBeanPropertyPointer_isActualProperty_9_1_Test {

    private DynaBeanPropertyPointer dynaBeanPropertyPointer;

    private DynaBean mockDynaBean;

    private DynaClass mockDynaClass;

    private DynaProperty mockDynaProperty;

    private NodePointer mockParent;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        mockDynaBean = mock(DynaBean.class);
        mockDynaClass = mock(DynaClass.class);
        dynaBeanPropertyPointer = new DynaBeanPropertyPointer(mockParent, mockDynaBean);
    }

    @Test
    public void testIsActualProperty_WhenPropertyExists_ReturnsTrue() throws Exception {
        String propertyName = "existingProperty";
        when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        when(mockDynaClass.getDynaProperty(propertyName)).thenReturn(mockDynaProperty);
        // Using reflection to set the property name
        setPrivateField(dynaBeanPropertyPointer, "name", propertyName);
        boolean result = invokePrivateMethod(dynaBeanPropertyPointer, "isActualProperty");
        assertTrue(result);
    }

    @Test
    public void testIsActualProperty_WhenPropertyDoesNotExist_ReturnsFalse() throws Exception {
        String propertyName = "nonExistingProperty";
        when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        when(mockDynaClass.getDynaProperty(propertyName)).thenReturn(null);
        // Using reflection to set the property name
        setPrivateField(dynaBeanPropertyPointer, "name", propertyName);
        boolean result = invokePrivateMethod(dynaBeanPropertyPointer, "isActualProperty");
        assertFalse(result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    private boolean invokePrivateMethod(Object obj, String methodName) throws Exception {
        java.lang.reflect.Method method = obj.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (boolean) method.invoke(obj);
    }
}
