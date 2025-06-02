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

public class DynaBeanPointer_equals_8_0_Test {

    @Test
    public void testEquals_SameInstance() {
        QName qName = new QName("testName");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(qName, dynaBean, null);
        assertTrue(dynaBeanPointer.equals(dynaBeanPointer), "The instance should be equal to itself.");
    }

    @Test
    public void testEquals_Null() {
        QName qName = new QName("testName");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(qName, dynaBean, null);
        assertFalse(dynaBeanPointer.equals(null), "The instance should not be equal to null.");
    }

    @Test
    public void testEquals_DifferentClass() {
        QName qName = new QName("testName");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer dynaBeanPointer = new DynaBeanPointer(qName, dynaBean, null);
        assertFalse(dynaBeanPointer.equals("Not a DynaBeanPointer"), "The instance should not be equal to a different class.");
    }

    @Test
    public void testEquals_DifferentDynaBeans() {
        QName qName1 = new QName("testName1");
        QName qName2 = new QName("testName2");
        DynaBean dynaBean1 = mock(DynaBean.class);
        DynaBean dynaBean2 = mock(DynaBean.class);
        DynaBeanPointer dynaBeanPointer1 = new DynaBeanPointer(qName1, dynaBean1, null);
        DynaBeanPointer dynaBeanPointer2 = new DynaBeanPointer(qName2, dynaBean2, null);
        assertFalse(dynaBeanPointer1.equals(dynaBeanPointer2), "Different DynaBeanPointers should not be equal.");
    }

    @Test
    public void testEquals_SameDynaBeansDifferentQNames() {
        QName qName1 = new QName("testName1");
        QName qName2 = new QName("testName1");
        DynaBean dynaBean = mock(DynaBean.class);
        DynaBeanPointer dynaBeanPointer1 = new DynaBeanPointer(qName1, dynaBean, null);
        DynaBeanPointer dynaBeanPointer2 = new DynaBeanPointer(qName2, dynaBean, null);
        assertTrue(dynaBeanPointer1.equals(dynaBeanPointer2), "Same DynaBeans with different QNames should be equal.");
    }
}
