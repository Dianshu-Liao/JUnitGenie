package org.apache.commons.jxpath.ri;

import java.lang.reflect.Method;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NamespaceResolver_getNamespaceContextPointer_3_0_Test {

    private NamespaceResolver resolver;

    private NamespaceResolver parentResolver;

    @BeforeEach
    public void setUp() {
        parentResolver = new NamespaceResolver();
        resolver = new NamespaceResolver(parentResolver);
    }

    @Test
    public void testGetNamespaceContextPointer_WhenPointerIsNullAndParentIsNotNull() throws Exception {
        // Arrange
        Pointer expectedPointer = mock(Pointer.class);
        setPrivateField(parentResolver, "pointer", expectedPointer);
        // Act
        Pointer result = resolver.getNamespaceContextPointer();
        // Assert
        assertEquals(expectedPointer, result);
    }

    @Test
    public void testGetNamespaceContextPointer_WhenPointerIsNotNull() throws Exception {
        // Arrange
        Pointer expectedPointer = mock(Pointer.class);
        setPrivateField(resolver, "pointer", expectedPointer);
        // Act
        Pointer result = resolver.getNamespaceContextPointer();
        // Assert
        assertEquals(expectedPointer, result);
    }

    @Test
    public void testGetNamespaceContextPointer_WhenPointerIsNullAndParentIsNull() throws Exception {
        // Arrange
        NamespaceResolver resolverWithoutParent = new NamespaceResolver();
        // Act
        Pointer result = resolverWithoutParent.getNamespaceContextPointer();
        // Assert
        assertNull(result);
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
