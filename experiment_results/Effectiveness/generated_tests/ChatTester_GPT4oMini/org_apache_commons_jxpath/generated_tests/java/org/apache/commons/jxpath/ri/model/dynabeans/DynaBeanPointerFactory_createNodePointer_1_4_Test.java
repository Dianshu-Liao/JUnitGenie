package org.apache.commons.jxpath.ri.model.dynabeans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.beanutils.DynaBean;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class DynaBeanPointerFactory_createNodePointer_1_4_Test {

    private DynaBeanPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new DynaBeanPointerFactory();
    }

    @Test
    public void testCreateNodePointer_withDynaBean() {
        QName name = new QName("http://example.com", "test");
        DynaBean dynaBean = Mockito.mock(DynaBean.class);
        Locale locale = Locale.ENGLISH;
        NodePointer result = factory.createNodePointer(name, dynaBean, locale);
        assertNotNull(result);
        assertTrue(result instanceof DynaBeanPointer);
    }

    @Test
    public void testCreateNodePointer_withNonDynaBean() {
        QName name = new QName("http://example.com", "test");
        Object nonDynaBean = new Object();
        Locale locale = Locale.ENGLISH;
        NodePointer result = factory.createNodePointer(name, nonDynaBean, locale);
        assertNull(result);
    }

    @Test
    public void testCreateNodePointer_withNullBean() {
        QName name = new QName("http://example.com", "test");
        Locale locale = Locale.ENGLISH;
        NodePointer result = factory.createNodePointer(name, null, locale);
        assertNull(result);
    }
}
