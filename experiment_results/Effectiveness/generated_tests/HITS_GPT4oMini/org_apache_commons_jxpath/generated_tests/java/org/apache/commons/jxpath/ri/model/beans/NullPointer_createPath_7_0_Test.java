package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class NullPointer_createPath_7_0_Test {

    @Test
    public void testCreatePath_ThrowsUnsupportedOperationException_WhenParentIsNull() {
        // Arrange
        QName qName = new QName("testName");
        NullPointer nullPointer = new NullPointer(qName, Locale.ENGLISH);
        // Act & Assert
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            nullPointer.createPath(mock(JXPathContext.class));
        });
        // Verify the exception message
        assertEquals("Cannot create the root object: null()", exception.getMessage());
    }

    @Test
    public void testCreatePath_ReturnsNodePointer_WhenParentIsNotNull() {
        // Arrange
        QName qName = new QName("testName");
        NodePointer parentNode = mock(NodePointer.class);
        NullPointer nullPointer = new NullPointer(parentNode, qName);
        JXPathContext context = mock(JXPathContext.class);
        // Act
        NodePointer result = nullPointer.createPath(context);
        // Assert
        assertNotNull(result);
    }
}
