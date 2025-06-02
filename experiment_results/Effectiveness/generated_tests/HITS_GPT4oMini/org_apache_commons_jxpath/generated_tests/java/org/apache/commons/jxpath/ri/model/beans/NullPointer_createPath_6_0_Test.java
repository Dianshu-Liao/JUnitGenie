package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;

public class NullPointer_createPath_6_0_Test {

    private NullPointer nullPointer;

    private JXPathContext context;

    @BeforeEach
    public void setUp() {
        QName name = new QName("testName");
        nullPointer = new NullPointer(name, null);
        context = mock(JXPathContext.class);
    }

    @Test
    public void testCreatePath_ThrowsUnsupportedOperationException_WhenParentIsNull() {
        // Arrange
        // The parent is null by default in the constructor used.
        // Act & Assert
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            nullPointer.createPath(context, new Object());
        });
        // Verify the exception message
        assertEquals("Cannot create the root object: null()", exception.getMessage());
    }

    @Test
    public void testCreatePath_ThrowsUnsupportedOperationException_WhenParentIsNotNull() {
        // Arrange
        QName childName = new QName("childName");
        NullPointer childPointer = new NullPointer(nullPointer, childName);
        Object value = new Object();
        // Act & Assert
        UnsupportedOperationException exception = assertThrows(UnsupportedOperationException.class, () -> {
            childPointer.createPath(context, value);
        });
        // Verify the exception message
        assertEquals("Cannot create the root object: " + nullPointer.asPath(), exception.getMessage());
    }
}
