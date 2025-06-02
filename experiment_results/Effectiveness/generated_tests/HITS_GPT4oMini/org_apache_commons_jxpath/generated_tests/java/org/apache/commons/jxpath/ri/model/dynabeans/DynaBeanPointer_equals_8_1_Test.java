package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class DynaBeanPointer_equals_8_1_Test {

    @Test
    public void testEquals_SameInstance() {
        QName name = new QName("test");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer = new DynaBeanPointer(name, dynaBean, null);
        assertTrue(pointer.equals(pointer), "Same instance should be equal");
    }

    @Test
    public void testEquals_NullObject() {
        QName name = new QName("test");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer = new DynaBeanPointer(name, dynaBean, null);
        assertFalse(pointer.equals(null), "Pointer should not be equal to null");
    }

    @Test
    public void testEquals_DifferentClass() {
        QName name = new QName("test");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer = new DynaBeanPointer(name, dynaBean, null);
        assertFalse(pointer.equals("Not a DynaBeanPointer"), "Pointer should not be equal to different class");
    }

    @Test
    public void testEquals_DifferentDynaBean() {
        QName name = new QName("test");
        DynaBean dynaBean1 = mock(DynaBean.class);
        DynaBean dynaBean2 = mock(DynaBean.class);
        DynaBeanPointer pointer1 = new DynaBeanPointer(name, dynaBean1, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name, dynaBean2, null);
        assertFalse(pointer1.equals(pointer2), "Pointers with different DynaBeans should not be equal");
    }

    @Test
    public void testEquals_DifferentQName() {
        QName name1 = new QName("test1");
        QName name2 = new QName("test2");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer1 = new DynaBeanPointer(name1, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name2, dynaBean, null);
        assertFalse(pointer1.equals(pointer2), "Pointers with different QNames should not be equal");
    }

    @Test
    public void testEquals_SameDynaBeanDifferentIndex() {
        QName name = new QName("test");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer1 = new DynaBeanPointer(name, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name, dynaBean, null);
        assertTrue(pointer1.equals(pointer2), "Pointers with same DynaBean and QName should be equal");
    }

    @Test
    public void testEquals_SameDynaBeanDifferentCollections() {
        QName name = new QName("test");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer pointer1 = new DynaBeanPointer(name, dynaBean, null);
        DynaBeanPointer pointer2 = new DynaBeanPointer(name, dynaBean, null);
        assertTrue(pointer1.equals(pointer2), "Pointers with same DynaBean and QName should be equal");
    }
}
