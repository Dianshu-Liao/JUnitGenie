package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.Arrays;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class DynaBeanPropertyPointer_setValue_11_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        DynaClass dynaClass = mock(DynaClass.class);
        DynaProperty dynaProperty = mock(DynaProperty.class);
        when(dynaProperty.getName()).thenReturn("testProperty");
        when(dynaClass.getDynaProperties()).thenReturn(new DynaProperty[] { dynaProperty });
        when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        propertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    public void testSetValueWholeCollection() {
        propertyPointer.setPropertyName("testProperty");
        Object valueToSet = "someValue";
        propertyPointer.setValue(valueToSet);
        // Capture the value set in the DynaBean
        ArgumentCaptor<Object> valueCaptor = ArgumentCaptor.forClass(Object.class);
        verify(dynaBean).set(eq("testProperty"), valueCaptor.capture());
        assertEquals(valueToSet, valueCaptor.getValue());
    }

    @Test
    public void testSetValueIndexedProperty() {
        propertyPointer.setPropertyName("testProperty");
        propertyPointer.setPropertyIndex(0);
        Object valueToSet = "indexedValue";
        propertyPointer.setValue(valueToSet);
        // Capture the value set in the DynaBean
        ArgumentCaptor<Object> valueCaptor = ArgumentCaptor.forClass(Object.class);
        verify(dynaBean).set(eq("testProperty"), eq(0), valueCaptor.capture());
        assertEquals(valueToSet, valueCaptor.getValue());
    }

    @Test
    public void testSetValueBaseValue() {
        propertyPointer.setPropertyName("testProperty");
        propertyPointer.setPropertyIndex(1);
        Object baseValue = new Object();
        when(dynaBean.get("testProperty")).thenReturn(baseValue);
        Object valueToSet = "baseValue";
        propertyPointer.setValue(valueToSet);
        // Verify that ValueUtils.setValue is called
        verify(dynaBean).get("testProperty");
        verify(dynaBean, times(1)).set(eq("testProperty"), anyInt(), eq(valueToSet));
    }

    @Test
    public void testGetPropertyNames() {
        propertyPointer.getPropertyNames();
        String[] expectedNames = { "testProperty" };
        assertEquals(Arrays.asList(expectedNames), Arrays.asList(propertyPointer.getPropertyNames()));
    }
}
