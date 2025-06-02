package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.JXPathContext;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.Locale;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionPointer_createPath_10_4_Test {

    private CollectionPointer collectionPointer;

    private JXPathContext context;

    @BeforeEach
    public void setUp() {
        // Initialize necessary objects for testing
        context = Mockito.mock(JXPathContext.class);
        collectionPointer = new CollectionPointer(new Object(), Locale.getDefault());
    }

    @Test
    public void testCreatePathWhenIndexIsLessThanLength() throws Exception {
        // Arrange
        setPrivateField(collectionPointer, "index", 0);
        Object baseValueMock = new Object();
        // Simulating length greater than index
        when(ValueUtils.getLength(collectionPointer.getBaseValue())).thenReturn(1);
        // Act
        NodePointer result = collectionPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Additional verifications can be done here
    }

    @Test
    public void testCreatePathWhenIndexIsEqualToLength() throws Exception {
        // Arrange
        setPrivateField(collectionPointer, "index", 1);
        Object baseValueMock = new Object();
        // Simulating length equal to index
        when(ValueUtils.getLength(collectionPointer.getBaseValue())).thenReturn(1);
        Object expandedCollection = new Object();
        when(ValueUtils.expandCollection(collectionPointer.getBaseValue(), 2)).thenReturn(expandedCollection);
        // Act
        NodePointer result = collectionPointer.createPath(context);
        // Assert
        assertNotNull(result);
        assertEquals(collectionPointer, result);
        // Verify that the collection has been expanded
        assertEquals(expandedCollection, collectionPointer.getBaseValue());
    }

    private void setPrivateField(Object obj, String fieldName, Object value) throws Exception {
        // Repairing the buggy line
        java.lang.reflect.Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }
}
