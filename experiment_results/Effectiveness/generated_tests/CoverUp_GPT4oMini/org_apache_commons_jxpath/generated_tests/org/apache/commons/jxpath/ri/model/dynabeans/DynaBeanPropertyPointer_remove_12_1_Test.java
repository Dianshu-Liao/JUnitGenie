package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaClass;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.jxpath.JXPathTypeConversionException;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPropertyPointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Arrays;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.apache.commons.jxpath.util.TypeUtils;

public class DynaBeanPropertyPointer_remove_12_1_Test {

    private DynaBean dynaBean;

    private DynaBeanPropertyPointer pointer;

    @BeforeEach
    public void setUp() {
        dynaBean = mock(DynaBean.class);
        pointer = new DynaBeanPropertyPointer(null, dynaBean);
    }

    @Test
    public void testRemove_WholeCollection() {
        when(dynaBean.get("propertyName")).thenReturn(new String[] { "value1", "value2" });
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(DynaBeanPropertyPointer.WHOLE_COLLECTION);
        pointer.remove();
        verify(dynaBean).set("propertyName", null);
    }

    @Test
    public void testRemove_IndexedProperty() {
        when(dynaBean.get("propertyName")).thenReturn(new String[] { "value1", "value2" });
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(1);
        pointer.remove();
        verify(dynaBean).set("propertyName", 1, null);
    }

    @Test
    public void testRemove_Collection() {
        List<String> list = new ArrayList<>();
        list.add("value1");
        list.add("value2");
        when(dynaBean.get("propertyName")).thenReturn(list);
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(0);
        pointer.remove();
        verify(dynaBean).set("propertyName", ValueUtils.remove(list, 0));
    }

    @Test
    public void testRemove_ZeroIndex() {
        when(dynaBean.get("propertyName")).thenReturn(new String[] { "value1", "value2" });
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(0);
        pointer.remove();
        verify(dynaBean).set("propertyName", null);
    }

    @Test
    public void testRemove_IndexOutOfBounds() {
        when(dynaBean.get("propertyName")).thenReturn(new String[] { "value1" });
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(2);
        assertThrows(JXPathTypeConversionException.class, () -> pointer.remove());
    }

    @Test
    public void testRemove_NullCollection() {
        when(dynaBean.get("propertyName")).thenReturn(null);
        pointer.setPropertyName("propertyName");
        pointer.setPropertyIndex(0);
        pointer.remove();
        verify(dynaBean, never()).set(anyString(), any());
    }

    @Test
    public void testReflectionInvokePrivateMethod() throws Exception {
        Method method = DynaBeanPropertyPointer.class.getDeclaredMethod("setValue", int.class, Object.class);
        method.setAccessible(true);
        method.invoke(pointer, 0, "value");
        // Verify behavior if needed based on the method implementation
    }
}
