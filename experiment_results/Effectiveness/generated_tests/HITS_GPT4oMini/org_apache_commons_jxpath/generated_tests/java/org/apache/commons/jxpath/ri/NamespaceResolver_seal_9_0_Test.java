package org.apache.commons.jxpath.ri;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.Serializable;
import java.util.HashMap;
import org.apache.commons.jxpath.Pointer;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;

public class NamespaceResolver_seal_9_0_Test {

    private NamespaceResolver resolver;

    private NamespaceResolver childResolver;

    @BeforeEach
    public void setUp() {
        resolver = new NamespaceResolver();
        childResolver = new NamespaceResolver(resolver);
    }

    @Test
    public void testSealParent() {
        assertFalse(resolver.isSealed());
        resolver.seal();
        assertTrue(resolver.isSealed());
    }

    @Test
    public void testSealChild() {
        assertFalse(childResolver.isSealed());
        childResolver.seal();
        assertTrue(childResolver.isSealed());
        assertTrue(resolver.isSealed());
    }

    @Test
    public void testSealParentAndChild() {
        resolver.seal();
        assertTrue(resolver.isSealed());
        assertTrue(childResolver.isSealed());
    }
}
