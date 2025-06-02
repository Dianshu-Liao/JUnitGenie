package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.TypeUtils;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class DynaBeanPropertyPointer_convert_14_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = Mockito.mock(DynaBean.class);
        propertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    public void testConvert_WithNullValueAndElementFalse() {
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        DynaProperty property = Mockito.mock(DynaProperty.class);
        when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        when(dynaClass.getDynaProperty("testProperty")).thenReturn(property);
        when(property.getType()).thenReturn((Class) String.class);
        propertyPointer.setPropertyName("testProperty");
        when(dynaBean.get("testProperty")).thenReturn(null);
        Object result = propertyPointer.getBaseValue();
        assertNull(result);
    }

    @Test
    public void testConvert_WithValidValueAndElementFalse() {
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        DynaProperty property = Mockito.mock(DynaProperty.class);
        when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        when(dynaClass.getDynaProperty("testProperty")).thenReturn(property);
        when(property.getType()).thenReturn((Class) Integer.class);
        propertyPointer.setPropertyName("testProperty");
        when(dynaBean.get("testProperty")).thenReturn("123");
        // Simulating the conversion
        when(TypeUtils.convert(any(), eq(Integer.class))).thenReturn(123);
        Object result = propertyPointer.getBaseValue();
        assertEquals(123, result);
    }
}
