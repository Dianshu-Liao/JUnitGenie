package org.apache.commons.jxpath.ri.model.dynabeans;

import java.lang.reflect.Field;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.ArrayList;
import java.util.Arrays;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;
import org.apache.commons.jxpath.util.ValueUtils;

class DynaBeanPropertyPointer_remove_12_0_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer dynaBeanPropertyPointer;

    @BeforeEach
    void setUp() {
        dynaBean = mock(DynaBean.class);
        dynaBeanPropertyPointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    void testRemove_WholeCollection() throws Exception {
        // Set up the scenario for WHOLE_COLLECTION
        setPrivateField(dynaBeanPropertyPointer, "index", DynaBeanPropertyPointer.WHOLE_COLLECTION);
        dynaBeanPropertyPointer.remove();
        verify(dynaBean).set(anyString(), isNull());
    }

    @Test
    void testRemove_IndexedProperty() throws Exception {
        // Set up the scenario for indexed property
        setPrivateField(dynaBeanPropertyPointer, "index", 1);
        when(dynaBeanPropertyPointer.isIndexedProperty()).thenReturn(true);
        dynaBeanPropertyPointer.remove();
        verify(dynaBean).set(anyString(), eq(1), isNull());
    }

    @Test
    void testRemove_Collection() throws Exception {
        // Set up the scenario for a collection
        setPrivateField(dynaBeanPropertyPointer, "index", 0);
        when(dynaBeanPropertyPointer.isCollection()).thenReturn(true);
        when(ValueUtils.remove(any(), eq(0))).thenReturn(new Object());
        dynaBeanPropertyPointer.remove();
        verify(dynaBean).set(anyString(), any());
    }

    @Test
    void testRemove_IndexZero() throws Exception {
        // Set up the scenario for index 0
        setPrivateField(dynaBeanPropertyPointer, "index", 0);
        dynaBeanPropertyPointer.remove();
        verify(dynaBean).set(anyString(), isNull());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
