package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.QName;
// Added import for NamespaceResolver
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class RootContext_RootContext_15_3_Test {

    private JXPathContextReferenceImpl jxpathContext;

    private NodePointer pointer;

    private RootContext rootContext;

    @BeforeEach
    void setUp() {
        // Mocking JXPathContextReferenceImpl and NodePointer
        jxpathContext = mock(JXPathContextReferenceImpl.class);
        pointer = mock(NodePointer.class);
        when(jxpathContext.getNamespaceResolver()).thenReturn(mock(NamespaceResolver.class));
    }

    @Test
    void testRootContextConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to invoke the private constructor
        Constructor<RootContext> constructor = RootContext.class.getDeclaredConstructor(JXPathContextReferenceImpl.class, NodePointer.class);
        constructor.setAccessible(true);
        rootContext = constructor.newInstance(jxpathContext, pointer);
        assertNotNull(rootContext);
        assertEquals(jxpathContext, rootContext.getJXPathContext());
        assertEquals(pointer, rootContext.getCurrentNodePointer());
    }

    @Test
    void testSetRegisteredValue() throws Exception {
        rootContext = new RootContext(jxpathContext, pointer);
        int registerIndex = rootContext.setRegisteredValue("TestValue");
        assertEquals(0, registerIndex);
        assertEquals("TestValue", rootContext.getValue());
    }

    @Test
    void testSetRegisteredValueExceedMax() throws Exception {
        rootContext = new RootContext(jxpathContext, pointer);
        for (int i = 0; i < 4; i++) {
            rootContext.setRegisteredValue("Value" + i);
        }
        int registerIndex = rootContext.setRegisteredValue("ExceedValue");
        assertEquals(-1, registerIndex);
    }

    @Test
    void testSetRegisteredValueWithNullPointer() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // Use reflection to invoke the private constructor with null pointer
        Constructor<RootContext> constructor = RootContext.class.getDeclaredConstructor(JXPathContextReferenceImpl.class, NodePointer.class);
        constructor.setAccessible(true);
        rootContext = constructor.newInstance(jxpathContext, null);
        assertNotNull(rootContext);
        assertEquals(jxpathContext, rootContext.getJXPathContext());
        assertNull(rootContext.getCurrentNodePointer());
    }
}
