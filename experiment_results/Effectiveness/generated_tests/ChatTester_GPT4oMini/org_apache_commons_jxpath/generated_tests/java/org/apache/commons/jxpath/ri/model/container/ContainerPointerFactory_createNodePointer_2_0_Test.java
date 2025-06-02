package org.apache.commons.jxpath.ri.model.container;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.Container;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class ContainerPointerFactory_createNodePointer_2_0_Test {

    private ContainerPointerFactory containerPointerFactory;

    private NodePointer parentNodePointer;

    private QName qName;

    @BeforeEach
    public void setUp() {
        containerPointerFactory = new ContainerPointerFactory();
        parentNodePointer = Mockito.mock(NodePointer.class);
        qName = Mockito.mock(QName.class);
    }

    @Test
    public void testCreateNodePointer_withContainer() {
        Container container = Mockito.mock(Container.class);
        NodePointer result = containerPointerFactory.createNodePointer(parentNodePointer, qName, container);
        assertNotNull(result);
    }

    @Test
    public void testCreateNodePointer_withNonContainer() {
        Object nonContainerBean = new Object();
        NodePointer result = containerPointerFactory.createNodePointer(parentNodePointer, qName, nonContainerBean);
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_withNullBean() {
        NodePointer result = containerPointerFactory.createNodePointer(parentNodePointer, qName, null);
        assertNull(result);
    }
}
