package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.jxpath.ri.QName;
import java.util.Locale;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.beans.PropertyOwnerPointer;
import org.apache.commons.jxpath.ri.model.beans.PropertyPointer;

public class DynaBeanPointer_hashCode_7_0_Test {

    private DynaBeanPointer dynaBeanPointerWithNullName;

    private DynaBeanPointer dynaBeanPointerWithEmptyName;

    private DynaBeanPointer dynaBeanPointerWithName;

    private NodePointer mockNodePointer;

    private DynaBean mockDynaBean;

    @BeforeEach
    public void setUp() {
        mockNodePointer = Mockito.mock(NodePointer.class);
        mockDynaBean = Mockito.mock(DynaBean.class);
        // Test case with null QName
        dynaBeanPointerWithNullName = new DynaBeanPointer(mockNodePointer, null, mockDynaBean);
        // Test case with empty QName
        dynaBeanPointerWithEmptyName = new DynaBeanPointer(mockNodePointer, new QName(""), mockDynaBean);
        // Test case with a valid QName
        dynaBeanPointerWithName = new DynaBeanPointer(mockNodePointer, new QName("prefix", "localName"), mockDynaBean);
    }

    @Test
    public void testHashCodeWithNullName() {
        // Expecting hashCode to return 0 when name is null
        assertEquals(0, dynaBeanPointerWithNullName.hashCode());
    }

    @Test
    public void testHashCodeWithEmptyName() {
        // Expecting hashCode to return hashCode of empty string
        assertEquals(new QName("").hashCode(), dynaBeanPointerWithEmptyName.hashCode());
    }

    @Test
    public void testHashCodeWithValidName() {
        // Expecting hashCode to return hashCode of the QName's name
        assertEquals(new QName("prefix", "localName").hashCode(), dynaBeanPointerWithName.hashCode());
    }
}
