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

public class DynaBeanPropertyPointer_isActualProperty_9_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer propertyPointer;

    @BeforeEach
    public void setUp() {
        dynaBean = Mockito.mock(DynaBean.class);
        propertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    public void testIsActualProperty_WhenPropertyExists_ReturnsTrue() {
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        DynaProperty property = new DynaProperty("existingProperty", String.class);
        Mockito.when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        Mockito.when(dynaClass.getDynaProperty("existingProperty")).thenReturn(property);
        propertyPointer.setPropertyName("existingProperty");
        boolean result = propertyPointer.isActualProperty();
        assertTrue(result, "Expected isActualProperty to return true for existing property.");
    }

    @Test
    public void testIsActualProperty_WhenPropertyDoesNotExist_ReturnsFalse() {
        DynaClass dynaClass = Mockito.mock(DynaClass.class);
        Mockito.when(dynaBean.getDynaClass()).thenReturn(dynaClass);
        Mockito.when(dynaClass.getDynaProperty("nonExistingProperty")).thenReturn(null);
        propertyPointer.setPropertyName("nonExistingProperty");
        boolean result = propertyPointer.isActualProperty();
        assertFalse(result, "Expected isActualProperty to return false for non-existing property.");
    }

    @Test
    public void testIsActualProperty_WhenPropertyNameIsNull_ReturnsFalse() {
        propertyPointer.setPropertyName(null);
        boolean result = propertyPointer.isActualProperty();
        assertFalse(result, "Expected isActualProperty to return false when property name is null.");
    }
}
