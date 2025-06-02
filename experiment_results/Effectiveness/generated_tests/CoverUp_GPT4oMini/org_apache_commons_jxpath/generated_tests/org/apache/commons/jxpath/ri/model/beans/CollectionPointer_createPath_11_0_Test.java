package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;

class CollectionPointer_createPath_11_0_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    @BeforeEach
    void setUp() {
        context = mock(JXPathContext.class);
        collectionPointer = new CollectionPointer(new ArrayList<>(), Locale.getDefault());
    }

    @Test
    void testCreatePathWithValue() {
        Object value = "Test Value";
        NodePointer result = collectionPointer.createPath(context, value);
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Expecting length to be 1 after adding a value
        assertEquals(1, collectionPointer.getLength());
    }

    @Test
    void testCreatePathWithNullValue() {
        Object value = null;
        NodePointer result = collectionPointer.createPath(context, value);
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Expecting length to be 1 after adding a null value
        assertEquals(1, collectionPointer.getLength());
    }

    @Test
    void testCreatePathWithMultipleValues() {
        Object value1 = "First Value";
        Object value2 = "Second Value";
        collectionPointer.createPath(context, value1);
        collectionPointer.createPath(context, value2);
        // Expecting length to be 2 after adding two values
        assertEquals(2, collectionPointer.getLength());
    }

    @Test
    void testCreatePathWithEmptyCollection() {
        NodePointer result = collectionPointer.createPath(context, "New Value");
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Expecting length to be 1 after adding a value to an empty collection
        assertEquals(1, collectionPointer.getLength());
    }

    @Test
    void testCreatePathWithIndex() {
        collectionPointer.setIndex(0);
        NodePointer result = collectionPointer.createPath(context, "Indexed Value");
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Expecting length to be 1 after adding a value at index 0
        assertEquals(1, collectionPointer.getLength());
    }

    // Reflection test for private methods can be added here if needed
    // Example: using reflection to test setValue method
    @Test
    void testSetValueUsingReflection() throws Exception {
        // Access private method setValue via reflection
        java.lang.reflect.Method setValueMethod = CollectionPointer.class.getDeclaredMethod("setValue", Object.class);
        setValueMethod.setAccessible(true);
        setValueMethod.invoke(collectionPointer, "Reflected Value");
        // Expecting length to be 1 after setting a value
        assertEquals(1, collectionPointer.getLength());
    }
}
