package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathInvalidAccessException;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.AbstractFactory;
import org.apache.commons.jxpath.JXPathAbstractFactoryException;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class NullPropertyPointer_setValue_10_1_Test {

    private NullPropertyPointer nullPropertyPointer;

    private NodePointer parent;

    @BeforeEach
    public void setUp() {
        parent = Mockito.mock(NodePointer.class);
        nullPropertyPointer = new NullPropertyPointer(parent);
    }

    @Test
    public void testSetValue_ParentIsNull() {
        // Arrange
        nullPropertyPointer = new NullPropertyPointer(null);
        Object value = new Object();
        // Act & Assert
        assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue(value);
        }, "Cannot set property " + nullPropertyPointer.asPath() + ", the target object is null");
    }

    @Test
    public void testSetValue_ParentIsContainer() {
        // Arrange
        Mockito.when(parent.isContainer()).thenReturn(true);
        Object value = new Object();
        // Act & Assert
        assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue(value);
        }, "Cannot set property " + nullPropertyPointer.asPath() + ", the target object is null");
    }

    @Test
    public void testSetValue_ParentIsNotContainerAndNotNull() {
        // Arrange
        Mockito.when(parent.isContainer()).thenReturn(false);
        Object value = new Object();
        // Act & Assert
        assertThrows(JXPathInvalidAccessException.class, () -> {
            nullPropertyPointer.setValue(value);
        }, "Cannot set property " + nullPropertyPointer.asPath() + ", path does not match a changeable location");
    }
}
