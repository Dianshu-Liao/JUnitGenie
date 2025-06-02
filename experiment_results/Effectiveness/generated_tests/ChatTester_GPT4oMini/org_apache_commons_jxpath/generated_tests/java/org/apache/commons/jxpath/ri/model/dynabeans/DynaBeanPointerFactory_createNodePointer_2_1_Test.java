package org.apache.commons.jxpath.ri.model.dynabeans;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynaBeanPointerFactory_createNodePointer_2_1_Test {

    private DynaBeanPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new DynaBeanPointerFactory();
    }

    @Test
    public void testCreateNodePointer_withDynaBean() {
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
    public void testCreateNodePointer_withNonDynaBean() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // Non-DynaBean object
        Object bean = new Object();
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_withNullBean() {
        // Arrange
        NodePointer parent = Mockito.mock(NodePointer.class);
        QName name = new QName("namespace", "localPart");
        // Null object
        Object bean = null;
        // Act
        NodePointer result = factory.createNodePointer(parent, name, bean);
        // Assert
        assertNull(result);
    }
}
