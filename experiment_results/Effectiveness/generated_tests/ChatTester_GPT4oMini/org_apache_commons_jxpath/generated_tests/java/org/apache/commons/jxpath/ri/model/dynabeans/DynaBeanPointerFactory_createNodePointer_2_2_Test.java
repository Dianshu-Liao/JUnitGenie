package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;

public class DynaBeanPointerFactory_createNodePointer_2_2_Test {

    private DynaBeanPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new DynaBeanPointerFactory();
    }

    @Test
    public void testCreateNodePointer_WithDynaBean_ReturnsDynaBeanPointer() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        DynaBean bean = Mockito.mock(DynaBean.class);
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNotNull(result);
        assertTrue(result instanceof DynaBeanPointer);
    }

    @Test
    public void testCreateNodePointer_WithNullBean_ReturnsNull() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        Object bean = null;
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_WithNonDynaBean_ReturnsNull() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // Not a DynaBean
        Object bean = new Object();
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }
}
