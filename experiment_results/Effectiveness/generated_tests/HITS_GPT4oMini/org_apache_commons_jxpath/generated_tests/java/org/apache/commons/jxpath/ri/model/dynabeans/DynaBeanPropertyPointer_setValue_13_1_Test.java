package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.ArrayList;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynaBeanPropertyPointer_setValue_13_1_Test {

    private DynaBean mockDynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        mockDynaBean = mock(DynaBean.class);
        NodePointer mockNodePointer = mock(NodePointer.class);
        propertyPointer = new DynaBeanPropertyPointer(mockNodePointer, mockDynaBean);
    }

    @Test
    public void testSetValueWholeCollection() {
        Object value = new ArrayList<>();
        when(mockDynaBean.get(propertyPointer.getPropertyName())).thenReturn(value);
        propertyPointer.setPropertyIndex(DynaBeanPropertyPointer.WHOLE_COLLECTION);
        propertyPointer.setValue(value);
        verify(mockDynaBean).set(propertyPointer.getPropertyName(), value);
    }

    @Test
    public void testSetValueIndexedProperty() {
        Object value = "Test Value";
        when(propertyPointer.isIndexedProperty()).thenReturn(true);
        propertyPointer.setPropertyIndex(0);
        propertyPointer.setValue(value);
        verify(mockDynaBean).set(propertyPointer.getPropertyName(), 0, value);
    }

    @Test
    public void testSetValueNonIndexedProperty() {
        Object baseValue = new ArrayList<>();
        when(mockDynaBean.get(propertyPointer.getPropertyName())).thenReturn(baseValue);
        propertyPointer.setPropertyIndex(0);
        propertyPointer.setValue("Test Value");
        verify(mockDynaBean).get(propertyPointer.getPropertyName());
        assertEquals(baseValue, propertyPointer.getBaseValue());
    }

    @Test
    public void testSetValueThrowsExceptionOnConversionError() {
        Object invalidValue = new Object();
        when(mockDynaBean.get(propertyPointer.getPropertyName())).thenThrow(new JXPathTypeConversionException("Conversion error"));
        propertyPointer.setPropertyIndex(0);
        Exception exception = assertThrows(JXPathTypeConversionException.class, () -> {
            propertyPointer.setValue(invalidValue);
        });
        assertEquals("Conversion error", exception.getMessage());
    }

    @Test
    public void testSetValueWithNullValue() {
        propertyPointer.setPropertyIndex(0);
        propertyPointer.setValue(null);
        verify(mockDynaBean).set(propertyPointer.getPropertyName(), 0, null);
    }
}
