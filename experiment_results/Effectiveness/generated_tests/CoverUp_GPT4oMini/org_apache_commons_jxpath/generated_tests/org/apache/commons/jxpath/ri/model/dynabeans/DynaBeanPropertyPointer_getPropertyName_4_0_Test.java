package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

class DynaBeanPropertyPointer_getPropertyName_4_0_Test {

    private DynaBeanPropertyPointer propertyPointer;

    private DynaBean mockDynaBean;

    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        mockDynaBean = mock(DynaBean.class);
        mockNodePointer = mock(NodePointer.class);
        propertyPointer = new DynaBeanPropertyPointer(mockNodePointer, mockDynaBean);
    }

    @Test
    void testGetPropertyNameWhenNameIsNull() throws Exception {
        // Arrange
        DynaProperty mockProperty1 = mock(DynaProperty.class);
        DynaProperty mockProperty2 = mock(DynaProperty.class);
        when(mockProperty1.getName()).thenReturn("property1");
        when(mockProperty2.getName()).thenReturn("property2");
        when(mockDynaBean.getDynaClass()).thenReturn(mock(DynaClass.class));
        when(mockDynaBean.getDynaClass().getDynaProperties()).thenReturn(new DynaProperty[] { mockProperty1, mockProperty2 });
        // Act
        String propertyName = propertyPointer.getPropertyName();
        // Assert
        // Default case when propertyIndex is not set
        assertEquals("*", propertyName);
    }

    @Test
    void testGetPropertyNameWhenPropertyIndexIsValid() throws Exception {
        // Arrange
        DynaProperty mockProperty1 = mock(DynaProperty.class);
        DynaProperty mockProperty2 = mock(DynaProperty.class);
        when(mockProperty1.getName()).thenReturn("property1");
        when(mockProperty2.getName()).thenReturn("property2");
        when(mockDynaBean.getDynaClass()).thenReturn(mock(DynaClass.class));
        when(mockDynaBean.getDynaClass().getDynaProperties()).thenReturn(new DynaProperty[] { mockProperty1, mockProperty2 });
        // Set the propertyIndex to 0
        setPrivateField(propertyPointer, "propertyIndex", 0);
        // Act
        String propertyName = propertyPointer.getPropertyName();
        // Assert
        // Expecting the first property name
        assertEquals("property1", propertyName);
    }

    @Test
    void testGetPropertyNameWhenPropertyIndexIsOutOfBounds() throws Exception {
        // Arrange
        DynaProperty mockProperty1 = mock(DynaProperty.class);
        DynaProperty mockProperty2 = mock(DynaProperty.class);
        when(mockProperty1.getName()).thenReturn("property1");
        when(mockProperty2.getName()).thenReturn("property2");
        when(mockDynaBean.getDynaClass()).thenReturn(mock(DynaClass.class));
        when(mockDynaBean.getDynaClass().getDynaProperties()).thenReturn(new DynaProperty[] { mockProperty1, mockProperty2 });
        // Set the propertyIndex to an invalid index
        setPrivateField(propertyPointer, "propertyIndex", 2);
        // Act
        String propertyName = propertyPointer.getPropertyName();
        // Assert
        // Expecting "*" when index is out of bounds
        assertEquals("*", propertyName);
    }

    private void setPrivateField(Object obj, String fieldName, int value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.setInt(obj, value);
    }
}
