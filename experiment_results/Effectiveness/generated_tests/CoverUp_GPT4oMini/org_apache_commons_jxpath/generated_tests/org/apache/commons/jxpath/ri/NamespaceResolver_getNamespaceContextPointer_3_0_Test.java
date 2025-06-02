package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class NamespaceResolver_getNamespaceContextPointer_3_0_Test {

    private NamespaceResolver rootResolver;

    private NamespaceResolver childResolver;

    private NodePointer mockNodePointer;

    @BeforeEach
    void setUp() {
        // root resolver with no parent
        rootResolver = new NamespaceResolver();
        // child resolver with root as parent
        childResolver = new NamespaceResolver(rootResolver);
        // mock NodePointer for testing
        mockNodePointer = mock(NodePointer.class);
    }

    @Test
    void testGetNamespaceContextPointer_WhenPointerIsNullAndParentIsNotNull() {
        Pointer result = childResolver.getNamespaceContextPointer();
        assertSame(rootResolver.getNamespaceContextPointer(), result, "Should return parent's pointer when child pointer is null.");
    }

    @Test
    void testGetNamespaceContextPointer_WhenPointerIsNotNull() {
        childResolver.setNamespaceContextPointer(mockNodePointer);
        Pointer result = childResolver.getNamespaceContextPointer();
        assertSame(mockNodePointer, result, "Should return the set pointer when it is not null.");
    }

    @Test
    void testGetNamespaceContextPointer_WhenPointerIsNullAndParentIsNull() {
        // No parent
        NamespaceResolver resolverWithoutParent = new NamespaceResolver();
        Pointer result = resolverWithoutParent.getNamespaceContextPointer();
        assertNull(result, "Should return null when both pointer and parent are null.");
    }
}
