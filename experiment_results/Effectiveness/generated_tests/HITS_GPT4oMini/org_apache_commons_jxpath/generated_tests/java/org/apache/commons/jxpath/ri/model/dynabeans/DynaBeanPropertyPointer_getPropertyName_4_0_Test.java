package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

public class DynaBeanPropertyPointer_getPropertyName_4_0_Test {

    private DynaBean mockDynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        mockDynaBean = Mockito.mock(DynaBean.class);
        propertyPointer = new DynaBeanPropertyPointer(null, mockDynaBean);
    }

    @Test
    public void testGetPropertyNameWhenNameIsNull() {
        DynaProperty[] properties = new DynaProperty[] { new DynaProperty("property1"), new DynaProperty("property2"), new DynaProperty("property3") };
        DynaClass mockDynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(mockDynaClass.getDynaProperties()).thenReturn(properties);
        Mockito.when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        String propertyName = propertyPointer.getPropertyName();
        assertEquals("property1", propertyName);
    }

    @Test
    public void testGetPropertyNameWithValidIndex() {
        DynaProperty[] properties = new DynaProperty[] { new DynaProperty("property1"), new DynaProperty("property2"), new DynaProperty("property3") };
        DynaClass mockDynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(mockDynaClass.getDynaProperties()).thenReturn(properties);
        Mockito.when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        // Set to the second property
        propertyPointer.setPropertyIndex(1);
        String propertyName = propertyPointer.getPropertyName();
        assertEquals("property2", propertyName);
    }

    @Test
    public void testGetPropertyNameWithInvalidIndex() {
        DynaProperty[] properties = new DynaProperty[] { new DynaProperty("property1"), new DynaProperty("property2") };
        DynaClass mockDynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(mockDynaClass.getDynaProperties()).thenReturn(properties);
        Mockito.when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        // Set to an invalid index
        propertyPointer.setPropertyIndex(5);
        String propertyName = propertyPointer.getPropertyName();
        // Expecting the wildcard for invalid index
        assertEquals("*", propertyName);
    }

    @Test
    public void testGetPropertyNameWhenAlreadySet() {
        propertyPointer.setPropertyName("property1");
        String propertyName = propertyPointer.getPropertyName();
        // Should return the set property name
        assertEquals("property1", propertyName);
    }

    @Test
    public void testGetPropertyNames() {
        DynaProperty[] properties = new DynaProperty[] { new DynaProperty("property1"), new DynaProperty("property2"), new DynaProperty("property3") };
        DynaClass mockDynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(mockDynaClass.getDynaProperties()).thenReturn(properties);
        Mockito.when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        String[] expectedNames = { "property1", "property2", "property3" };
        String[] actualNames = propertyPointer.getPropertyNames();
        assertArrayEquals(expectedNames, actualNames);
    }

    @Test
    public void testGetPropertyCount() {
        DynaProperty[] properties = new DynaProperty[] { new DynaProperty("property1"), new DynaProperty("property2") };
        DynaClass mockDynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(mockDynaClass.getDynaProperties()).thenReturn(properties);
        Mockito.when(mockDynaBean.getDynaClass()).thenReturn(mockDynaClass);
        int count = propertyPointer.getPropertyCount();
        // Expecting count of properties
        assertEquals(2, count);
    }
}
