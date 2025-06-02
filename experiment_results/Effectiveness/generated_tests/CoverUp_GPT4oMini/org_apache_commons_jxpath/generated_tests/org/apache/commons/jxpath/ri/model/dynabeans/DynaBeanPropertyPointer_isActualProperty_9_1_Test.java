package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
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

public class DynaBeanPropertyPointer_isActualProperty_9_1_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = Mockito.mock(DynaBean.class);
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        propertyPointer = new DynaBeanPropertyPointer(Mockito.mock(NodePointer.class), dynaBean);
        Mockito.when(dynaBean.getDynaClass()).thenReturn(dynaClass);
    }

    @Test
    public void testIsActualProperty_WhenPropertyExists() throws Exception {
        String propertyName = "existingProperty";
        DynaProperty dynaProperty = new DynaProperty(propertyName);
        Mockito.when(dynaBean.getDynaClass().getDynaProperty(propertyName)).thenReturn(dynaProperty);
        invokeIsActualProperty(propertyName);
        assertTrue(getIsActualPropertyResult());
    }

    @Test
    public void testIsActualProperty_WhenPropertyDoesNotExist() throws Exception {
        String propertyName = "nonExistingProperty";
        Mockito.when(dynaBean.getDynaClass().getDynaProperty(propertyName)).thenReturn(null);
        invokeIsActualProperty(propertyName);
        assertFalse(getIsActualPropertyResult());
    }

    private void invokeIsActualProperty(String propertyName) throws Exception {
        Method setPropertyNameMethod = DynaBeanPropertyPointer.class.getDeclaredMethod("setPropertyName", String.class);
        setPropertyNameMethod.setAccessible(true);
        setPropertyNameMethod.invoke(propertyPointer, propertyName);
    }

    private boolean getIsActualPropertyResult() throws Exception {
        Method isActualPropertyMethod = DynaBeanPropertyPointer.class.getDeclaredMethod("isActualProperty");
        isActualPropertyMethod.setAccessible(true);
        return (boolean) isActualPropertyMethod.invoke(propertyPointer);
    }
}
