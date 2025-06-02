package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynaBeanPointerFactory_createNodePointer_2_0_Test {

    private final DynaBeanPointerFactory factory = new DynaBeanPointerFactory();

    @Test
    public void testCreateNodePointer_WithDynaBean() {
        // Arrange
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        DynaBean dynaBean = mock(DynaBean.class);
        // Act
        NodePointer result = factory.createNodePointer(parent, name, dynaBean);
        // Assert
        assertNotNull(result, "Expected a NodePointer to be returned when a DynaBean is provided.");
    }

    @Test
    public void testCreateNodePointer_WithNonDynaBean() {
        // Arrange
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        // Using a regular Object, not a DynaBean
        Object nonDynaBean = new Object();
        // Act
        NodePointer result = factory.createNodePointer(parent, name, nonDynaBean);
        // Assert
        assertNull(result, "Expected null to be returned when a non-DynaBean is provided.");
    }

    @Test
    public void testCreateNodePointer_WithNullBean() {
        // Arrange
        NodePointer parent = mock(NodePointer.class);
        QName name = new QName("testName");
        Object nullBean = null;
        // Act
        NodePointer result = factory.createNodePointer(parent, name, nullBean);
        // Assert
        assertNull(result, "Expected null to be returned when a null bean is provided.");
    }
}
