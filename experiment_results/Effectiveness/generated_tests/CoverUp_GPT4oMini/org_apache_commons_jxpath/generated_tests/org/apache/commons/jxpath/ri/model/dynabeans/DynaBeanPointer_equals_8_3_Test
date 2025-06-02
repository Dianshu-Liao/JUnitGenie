package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointer;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class DynaBeanPointer_equals_8_3_Test {

    private DynaBean dynaBean1;

    private DynaBean dynaBean2;

    private QName qName1;

    private QName qName2;

    private DynaBeanPointer pointer1;

    private DynaBeanPointer pointer2;

    private DynaBeanPointer pointer3;

    @BeforeEach
    void setUp() {
        dynaBean1 = mock(DynaBean.class);
        dynaBean2 = mock(DynaBean.class);
        qName1 = new QName("namespace1", "localName1");
        qName2 = new QName("namespace2", "localName2");
        pointer1 = new DynaBeanPointer(qName1, dynaBean1, Locale.ENGLISH);
        pointer2 = new DynaBeanPointer(qName1, dynaBean1, Locale.ENGLISH);
        pointer3 = new DynaBeanPointer(qName2, dynaBean2, Locale.ENGLISH);
    }

    @Test
    void testEquals_SameObject() {
        assertTrue(pointer1.equals(pointer1));
    }

    @Test
    void testEquals_NullObject() {
        assertFalse(pointer1.equals(null));
    }

    @Test
    void testEquals_DifferentClass() {
        assertFalse(pointer1.equals("Not a DynaBeanPointer"));
    }

    @Test
    void testEquals_EqualPointers() {
        assertTrue(pointer1.equals(pointer2));
    }

    @Test
    void testEquals_DifferentDynaBeans() {
        assertFalse(pointer1.equals(pointer3));
    }

    @Test
    void testEquals_DifferentQNames() {
        DynaBeanPointer pointer4 = new DynaBeanPointer(qName2, dynaBean1, Locale.ENGLISH);
        assertFalse(pointer1.equals(pointer4));
    }

    @Test
    void testEquals_DifferentIndexes() throws Exception {
        setPrivateField(pointer1, "index", 1);
        setPrivateField(pointer3, "index", 2);
        assertFalse(pointer1.equals(pointer3));
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
