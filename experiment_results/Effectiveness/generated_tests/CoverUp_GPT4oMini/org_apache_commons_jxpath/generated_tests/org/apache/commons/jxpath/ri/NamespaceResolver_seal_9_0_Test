package org.apache.commons.jxpath.ri;

import org.apache.commons.jxpath.ri.NamespaceResolver;
import org.apache.commons.jxpath.ri.model.NodePointer;
import java.lang.reflect.Field;
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

public class NamespaceResolver_seal_9_0_Test {

    private NamespaceResolver resolver;

    private NamespaceResolver parentResolver;

    @BeforeEach
    public void setUp() {
        parentResolver = new NamespaceResolver();
        resolver = new NamespaceResolver(parentResolver);
    }

    @Test
    public void testSeal() throws Exception {
        // Ensure the resolver is not sealed initially
        assertFalse(getSealed(resolver));
        assertFalse(getSealed(parentResolver));
        // Call the seal method
        resolver.seal();
        // Check that the resolver is sealed
        assertTrue(getSealed(resolver));
        assertTrue(getSealed(parentResolver));
    }

    private boolean getSealed(NamespaceResolver resolver) throws Exception {
        Field sealedField = NamespaceResolver.class.getDeclaredField("sealed");
        sealedField.setAccessible(true);
        return sealedField.getBoolean(resolver);
    }
}
