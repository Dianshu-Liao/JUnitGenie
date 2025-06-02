package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class DynaBeanPropertyPointer_setValue_13_0_Test {

    private DynaBean dynaBean;

    private DynaClass dynaClass;

    private DynaProperty dynaProperty;

    private DynaBeanPropertyPointer pointer;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        dynaClass = mock(DynaClass.class);
        dynaProperty = mock(DynaProperty.class);
        NodePointer parent = mock(NodePointer.class);
        pointer = new DynaBeanPropertyPointer(parent, dynaBean);
        when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        when(dynaClass.getDynaProperty("propertyName")).thenReturn(dynaProperty);
    }

    @Test
    public void testSetValue_WholeCollection() {
        Object valueToSet = new Object();
        when(dynaProperty.getType()).thenReturn((Class) Object.class);
        pointer.setPropertyName("propertyName");
        pointer.setValue(valueToSet);
        verify(dynaBean).set("propertyName", valueToSet);
    }

    @Test
    public void testSetValue_ConvertValue() {
        Object valueToSet = new Object();
        when(dynaProperty.getType()).thenReturn((Class) Object.class);
        pointer.setPropertyName("propertyName");
        pointer.setValue(valueToSet);
        verify(dynaBean).set("propertyName", valueToSet);
    }

    @Test
    public void testSetValue_ConvertThrowsException() {
        Object valueToSet = new Object();
        when(dynaProperty.getType()).thenThrow(new JXPathTypeConversionException("Conversion Error"));
        pointer.setPropertyName("propertyName");
        assertThrows(JXPathTypeConversionException.class, () -> {
            pointer.setValue(valueToSet);
        });
    }
}
