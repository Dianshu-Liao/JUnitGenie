package org.apache.commons.jxpath.ri.model.dynabeans;

import java.util.Locale;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

@ExtendWith(MockitoExtension.class)
public class DynaBeanPointerFactory_createNodePointer_1_0_Test {

    private DynaBeanPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new DynaBeanPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithDynaBean() {
        QName qName = new QName("testPrefix", "testName");
        DynaBean dynaBean = createMockDynaBean();
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = factory.createNodePointer(qName, dynaBean, locale);
        assertNotNull(nodePointer, "NodePointer should not be null for DynaBean.");
    }

    @Test
    public void testCreateNodePointerWithNonDynaBean() {
        QName qName = new QName("testPrefix", "testName");
        String nonDynaBean = "Not a DynaBean";
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = factory.createNodePointer(qName, nonDynaBean, locale);
        assertNull(nodePointer, "NodePointer should be null for non-DynaBean objects.");
    }

    // Mock DynaBean creation method
    private DynaBean createMockDynaBean() {
        return mock(DynaBean.class);
    }
}
