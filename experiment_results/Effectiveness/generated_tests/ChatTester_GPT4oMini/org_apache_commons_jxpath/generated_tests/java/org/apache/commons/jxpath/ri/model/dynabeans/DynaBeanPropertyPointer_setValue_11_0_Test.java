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

public class DynaBeanPropertyPointer_setValue_11_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    private final int index = 0;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        DynaClass dynaClass = mock(DynaClass.class);
        DynaProperty dynaProperty = mock(DynaProperty.class);
        when(dynaProperty.getName()).thenReturn("testProperty");
        when(dynaClass.getDynaProperties()).thenReturn(new DynaProperty[] { dynaProperty });
        when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        propertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
        propertyPointer.setPropertyIndex(index);
        propertyPointer.setPropertyName("testProperty");
    }

    @Test
    public void testSetValue() {
        Object valueToSet = "newValue";
        // Mock the behavior of DynaBean's set method
        doNothing().when(dynaBean).set("testProperty", index, valueToSet);
        // Invoke the focal method
        propertyPointer.setValue(valueToSet);
        // Verify that the set method was called with the correct parameters
        verify(dynaBean).set("testProperty", index, valueToSet);
    }

    @Test
    public void testSetValueWholeCollection() {
        propertyPointer.setPropertyIndex(DynaBeanPropertyPointer.WHOLE_COLLECTION);
        Object valueToSet = "wholeCollectionValue";
        // Mock the behavior of DynaBean's set method for whole collection
        doNothing().when(dynaBean).set("testProperty", valueToSet);
        // Invoke the focal method
        propertyPointer.setValue(valueToSet);
        // Verify that the set method was called with the correct parameters
        verify(dynaBean).set("testProperty", valueToSet);
    }

    @Test
    public void testSetValueWithNull() {
        Object valueToSet = null;
        // Mock the behavior of DynaBean's set method
        doNothing().when(dynaBean).set("testProperty", index, valueToSet);
        // Invoke the focal method
        propertyPointer.setValue(valueToSet);
        // Verify that the set method was called with the correct parameters
        verify(dynaBean).set("testProperty", index, valueToSet);
    }
}
