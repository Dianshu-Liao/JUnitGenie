package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.QName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;

public class NullPointer_createPath_7_2_Test {

    private NullPointer nullPointer;

    @Mock
    private JXPathContext context;

    @Mock
    private NodePointer parent;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        nullPointer = new NullPointer(parent, new QName("test", "namespace"));
    }

    @Test
    public void testCreatePathWithParent() {
        // Arrange
        NodePointer childNodePointer = mock(NodePointer.class);
        when(parent.createPath(context)).thenReturn(childNodePointer);
        when(childNodePointer.getValuePointer()).thenReturn(childNodePointer);
        // Act
        NodePointer result = nullPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(childNodePointer, result);
        verify(parent).createPath(context);
        verify(childNodePointer).getValuePointer();
    }

    @Test
    public void testCreatePathWithoutParent() {
        // Arrange
        nullPointer = new NullPointer(null, new QName("test", "namespace"));
        // Act & Assert
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            nullPointer.createPath(context);
        });
        assertEquals("Cannot create the root object: null", exception.getMessage());
    }
}
