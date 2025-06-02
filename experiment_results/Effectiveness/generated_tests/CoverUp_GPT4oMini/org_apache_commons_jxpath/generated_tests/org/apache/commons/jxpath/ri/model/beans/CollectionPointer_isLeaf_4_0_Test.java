package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathIntrospector;
import org.mockito.junit.jupiter.MockitoExtension;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;

@ExtendWith(MockitoExtension.class)
public class CollectionPointer_isLeaf_4_0_Test {

    private CollectionPointer collectionPointer;

    @BeforeEach
    public void setUp() {
        // Initialize CollectionPointer with an empty collection
        collectionPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault());
    }

    @Test
    public void testIsLeafWithNullValue() throws Exception {
        // Set up a scenario where the node is null
        CollectionPointer mockPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault()) {

            @Override
            public Object getNode() {
                // Simulate null node
                return null;
            }
        };
        // Invoke isLeaf and verify it returns true
        assertTrue(mockPointer.isLeaf());
    }

    @Test
    public void testIsLeafWithAtomicValue() throws Exception {
        // Set up a scenario where the value is atomic
        Object atomicValue = "Atomic String";
        CollectionPointer mockPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault()) {

            @Override
            public Object getNode() {
                // Simulate atomic value
                return atomicValue;
            }
        };
        // Mocking the JXPathIntrospector behavior for atomic check
        JXPathIntrospector mockIntrospector = mock(JXPathIntrospector.class);
        when(mockIntrospector.getBeanInfo(atomicValue.getClass()).isAtomic()).thenReturn(true);
        // Use reflection to set the static field
        Method setIntrospectorMethod = JXPathIntrospector.class.getDeclaredMethod("setIntrospector", JXPathIntrospector.class);
        setIntrospectorMethod.setAccessible(true);
        setIntrospectorMethod.invoke(null, mockIntrospector);
        // Invoke isLeaf and verify it returns true
        assertTrue(mockPointer.isLeaf());
    }

    @Test
    public void testIsLeafWithNonAtomicValue() throws Exception {
        // Set up a scenario where the value is non-atomic
        HashMap<String, String> nonAtomicValue = new HashMap<>();
        nonAtomicValue.put("key", "value");
        collectionPointer = new CollectionPointer(nonAtomicValue, Locale.getDefault());
        // Invoke isLeaf and verify it returns false
        assertFalse(collectionPointer.isLeaf());
    }
}
