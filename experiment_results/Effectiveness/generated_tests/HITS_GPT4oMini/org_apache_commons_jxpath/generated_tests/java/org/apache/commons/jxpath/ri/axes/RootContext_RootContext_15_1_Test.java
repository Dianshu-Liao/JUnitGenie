package org.apache.commons.jxpath.ri.axes;

import org.apache.commons.jxpath.ri.JXPathContextReferenceImpl;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.Function;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.NodeSet;
import org.apache.commons.jxpath.ri.EvalContext;
import org.apache.commons.jxpath.ri.QName;

public class RootContext_RootContext_15_1_Test {

    private JXPathContextReferenceImpl jxpathContext;

    private NodePointer pointer;

    @BeforeEach
    public void setUp() {
        jxpathContext = mock(JXPathContextReferenceImpl.class);
        pointer = mock(NodePointer.class);
    }

    @Test
    public void testConstructorInitialization() {
        // Act
        RootContext rootContext = new RootContext(jxpathContext, pointer);
        // Assert
        assertNotNull(rootContext);
    }

    @Test
    public void testConstructorWithNullPointer() {
        // Act
        RootContext rootContext = new RootContext(jxpathContext, null);
        // Assert
        assertNotNull(rootContext);
    }

    @Test
    public void testConstructorWithNullJXPathContext() {
        // Act
        RootContext rootContext = new RootContext(null, pointer);
        // Assert
        assertNotNull(rootContext);
    }

    @Test
    public void testConstructorWithBothNulls() {
        // Act
        RootContext rootContext = new RootContext(null, null);
        // Assert
        assertNotNull(rootContext);
    }
}
