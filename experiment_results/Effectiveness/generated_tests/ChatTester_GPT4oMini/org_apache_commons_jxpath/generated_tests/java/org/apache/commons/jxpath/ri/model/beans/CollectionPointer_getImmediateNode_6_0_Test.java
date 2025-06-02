package org.apache.commons.jxpath.ri.model.beans;

import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.JXPathContext;
import org.apache.commons.jxpath.JXPathIntrospector;
import org.apache.commons.jxpath.ri.Compiler;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.compiler.NodeNameTest;
import org.apache.commons.jxpath.ri.compiler.NodeTest;
import org.apache.commons.jxpath.ri.compiler.NodeTypeTest;
import org.apache.commons.jxpath.ri.model.NodeIterator;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;

public class CollectionPointer_getImmediateNode_6_0_Test {

    private CollectionPointer collectionPointer;

    private Object mockCollection;

    // Assuming WHOLE_COLLECTION is defined as -1
    private static final int WHOLE_COLLECTION = -1;

    @BeforeEach
    public void setUp() {
        mockCollection = mock(Object.class);
        collectionPointer = new CollectionPointer(mockCollection, Locale.ENGLISH);
    }

    @Test
    public void testGetImmediateNode_WholeCollection() throws Exception {
        // Mocking the static method ValueUtils.getValue(Object)
        ValueUtils valueUtilsMock = mock(ValueUtils.class);
        when(valueUtilsMock.getValue(mockCollection)).thenReturn("Whole Collection Value");
        // Using reflection to set the index to WHOLE_COLLECTION
        setPrivateField(collectionPointer, "index", WHOLE_COLLECTION);
        Object result = collectionPointer.getImmediateNode();
        assertEquals("Whole Collection Value", result);
    }

    @Test
    public void testGetImmediateNode_WithIndex() throws Exception {
        // Mocking the static method ValueUtils.getValue(Object, int)
        ValueUtils valueUtilsMock = mock(ValueUtils.class);
        when(valueUtilsMock.getValue(mockCollection, 1)).thenReturn("Indexed Value");
        // Using reflection to set the index to a specific value
        setPrivateField(collectionPointer, "index", 1);
        Object result = collectionPointer.getImmediateNode();
        assertEquals("Indexed Value", result);
    }

    private void setPrivateField(Object target, String fieldName, Object value) throws Exception {
        java.lang.reflect.Field field = target.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(target, value);
    }
}
