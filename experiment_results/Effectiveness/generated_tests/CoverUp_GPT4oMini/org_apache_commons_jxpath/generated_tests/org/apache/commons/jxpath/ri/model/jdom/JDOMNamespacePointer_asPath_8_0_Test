package org.apache.commons.jxpath.ri.model.jdom;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class JDOMNamespacePointer_asPath_8_0_Test {

    private NodePointer mockParent;

    private JDOMNamespacePointer jdomNamespacePointer;

    @BeforeEach
    public void setUp() {
        mockParent = mock(NodePointer.class);
        jdomNamespacePointer = new JDOMNamespacePointer(mockParent, "testPrefix");
    }

    @Test
    public void testAsPathWithParent() throws Exception {
        // Arrange
        when(mockParent.asPath()).thenReturn("parentPath");
        // Act
        String result = invokeAsPath(jdomNamespacePointer);
        // Assert
        assertEquals("parentPath/namespace::testPrefix", result);
    }

    @Test
    public void testAsPathWithoutParent() throws Exception {
        // Arrange
        jdomNamespacePointer = new JDOMNamespacePointer(null, "testPrefix");
        // Act
        String result = invokeAsPath(jdomNamespacePointer);
        // Assert
        assertEquals("namespace::testPrefix", result);
    }

    private String invokeAsPath(JDOMNamespacePointer pointer) throws Exception {
        Method method = JDOMNamespacePointer.class.getDeclaredMethod("asPath");
        method.setAccessible(true);
        return (String) method.invoke(pointer);
    }
}
