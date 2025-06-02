package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.dynabeans.DynaBeanPointerFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynaBeanPointerFactory_createNodePointer_2_4_Test {

    @Test
    public void testCreateNodePointer_withDynaBean() {
        // Arrange
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        // Mocking DynaBean
        DynaBean dynaBean = mock(DynaBean.class);
        // Act
        NodePointer result = factory.createNodePointer(parent, name, dynaBean);
        // Assert
        // Expecting a non-null result when a DynaBean is passed
        assertNotNull(result);
    }

    @Test
    public void testCreateNodePointer_withNonDynaBean() {
        // Arrange
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        // Non-DynaBean object
        Object nonDynaBean = new Object();
        // Act
        NodePointer result = factory.createNodePointer(parent, name, nonDynaBean);
        // Assert
        // Expecting a null result when a non-DynaBean is passed
        assertNull(result);
    }

    @Test
    public void testGetOrder() {
        // Arrange
        DynaBeanPointerFactory factory = new DynaBeanPointerFactory();
        // Act
        int order = factory.getOrder();
        // Assert
        assertEquals(DynaBeanPointerFactory.DYNA_BEAN_POINTER_FACTORY_ORDER, order);
    }
}
