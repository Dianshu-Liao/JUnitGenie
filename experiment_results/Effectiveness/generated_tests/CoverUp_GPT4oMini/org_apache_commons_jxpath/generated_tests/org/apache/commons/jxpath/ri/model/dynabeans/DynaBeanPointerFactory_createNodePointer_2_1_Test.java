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

public class DynaBeanPointerFactory_createNodePointer_2_1_Test {

    private DynaBeanPointerFactory factory;

    private NodePointer parent;

    private QName name;

    private DynaBean dynaBean;

    @BeforeEach
    public void setUp() {
        factory = new DynaBeanPointerFactory();
        parent = mock(NodePointer.class);
        name = new QName("testName");
        dynaBean = mock(DynaBean.class);
    }

    @Test
    public void testCreateNodePointer_withDynaBean() {
        NodePointer result = factory.createNodePointer(parent, name, dynaBean);
        assertNotNull(result, "Expected a non-null NodePointer when a DynaBean is provided.");
    }

    @Test
    public void testCreateNodePointer_withNonDynaBean() {
        Object nonDynaBean = new Object();
        NodePointer result = factory.createNodePointer(parent, name, nonDynaBean);
        assertNull(result, "Expected a null NodePointer when a non-DynaBean is provided.");
    }

    @Test
    public void testCreateNodePointer_withNullBean() {
        NodePointer result = factory.createNodePointer(parent, name, null);
        assertNull(result, "Expected a null NodePointer when a null bean is provided.");
    }
}
