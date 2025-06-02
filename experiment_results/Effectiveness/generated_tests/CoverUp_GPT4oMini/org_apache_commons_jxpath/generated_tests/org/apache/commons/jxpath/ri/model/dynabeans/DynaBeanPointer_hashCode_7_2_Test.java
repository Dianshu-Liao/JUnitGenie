package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

@ExtendWith(MockitoExtension.class)
class DynaBeanPointer_hashCode_7_2_Test {

    private DynaBeanPointer dynaBeanPointerWithNullName;

    private DynaBeanPointer dynaBeanPointerWithValidName;

    private DynaBeanPointer dynaBeanPointerWithEmptyName;

    @BeforeEach
    void setUp() {
        // Test with null QName
        dynaBeanPointerWithNullName = new DynaBeanPointer(null, mock(DynaBean.class), null);
        // Test with valid QName
        QName validQName = new QName("prefix", "localName");
        dynaBeanPointerWithValidName = new DynaBeanPointer(validQName, mock(DynaBean.class), null);
        // Test with empty qualified name
        QName emptyQName = new QName("");
        dynaBeanPointerWithEmptyName = new DynaBeanPointer(emptyQName, mock(DynaBean.class), null);
    }

    @Test
    void testHashCodeWithNullName() {
        assertEquals(0, dynaBeanPointerWithNullName.hashCode());
    }

    @Test
    void testHashCodeWithValidName() {
        assertEquals(dynaBeanPointerWithValidName.getName().hashCode(), dynaBeanPointerWithValidName.hashCode());
    }

    @Test
    void testHashCodeWithEmptyName() {
        assertEquals(dynaBeanPointerWithEmptyName.getName().hashCode(), dynaBeanPointerWithEmptyName.hashCode());
    }
}
