package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynaBeanPropertyPointer_setValue_11_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        propertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    public void testSetValueWholeCollection() {
        Object value = "testValue";
        propertyPointer.setPropertyName("propertyName");
        propertyPointer.setValue(value);
        verify(dynaBean).set("propertyName", value);
    }

    @Test
    public void testSetValueIndexedProperty() {
        Object value = "indexedValue";
        propertyPointer.setPropertyName("indexedProperty");
        propertyPointer.setPropertyIndex(0);
        propertyPointer.setValue(value);
        verify(dynaBean).set("indexedProperty", 0, value);
    }

    @Test
    public void testSetValueNonIndexedProperty() {
        Object baseValue = new Object();
        propertyPointer.setPropertyName("nonIndexedProperty");
        when(dynaBean.get("nonIndexedProperty")).thenReturn(baseValue);
        Object value = "newValue";
        propertyPointer.setValue(value);
        verify(dynaBean).set("nonIndexedProperty", 0, value);
    }

    @Test
    public void testSetValueWithInvalidIndex() {
        propertyPointer.setPropertyName("invalidProperty");
        propertyPointer.setPropertyIndex(-1);
        Object value = "value";
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            propertyPointer.setValue(value);
        });
    }

    @Test
    public void testSetValueWithConversionException() {
        propertyPointer.setPropertyName("convertProperty");
        Object value = "invalidConversionValue";
        doThrow(new JXPathTypeConversionException("Conversion failed")).when(dynaBean).set("convertProperty", value);
        assertThrows(JXPathTypeConversionException.class, () -> {
            propertyPointer.setValue(value);
        });
    }
}
