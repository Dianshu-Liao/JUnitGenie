package org.apache.commons.jxpath.ri;

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
import org.apache.commons.jxpath.ri.model.NodePointer;

public class NamespaceResolver_seal_9_0_Test {

    private NamespaceResolver resolver;

    private NamespaceResolver parentResolver;

    @BeforeEach
    public void setUp() {
        parentResolver = new NamespaceResolver();
        resolver = new NamespaceResolver(parentResolver);
    }

    @Test
    public void testSeal_WhenCalled_SetsSealedToTrue() throws Exception {
        // Act
        resolver.seal();
        // Assert
        assertTrue(isSealed(resolver));
    }

    @Test
    public void testSeal_WhenCalled_SealsParent() throws Exception {
        // Act
        resolver.seal();
        // Assert
        assertTrue(isSealed(parentResolver));
    }

    @Test
    public void testSeal_WhenCalledOnAlreadySealed_DoesNotChangeState() throws Exception {
        // Arrange
        // Seal the resolver first
        resolver.seal();
        boolean initialState = isSealed(resolver);
        // Act
        resolver.seal();
        // Assert
        assertTrue(initialState);
        assertTrue(isSealed(resolver));
    }

    private boolean isSealed(NamespaceResolver resolver) throws Exception {
        Field sealedField = NamespaceResolver.class.getDeclaredField("sealed");
        sealedField.setAccessible(true);
        return sealedField.getBoolean(resolver);
    }
}
