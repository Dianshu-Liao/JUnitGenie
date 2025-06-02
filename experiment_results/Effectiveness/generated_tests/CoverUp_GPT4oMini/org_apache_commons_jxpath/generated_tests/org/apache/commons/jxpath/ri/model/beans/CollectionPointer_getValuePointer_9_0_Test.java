package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.model.beans.CollectionPointer;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
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

public class CollectionPointer_getValuePointer_9_0_Test {

    private CollectionPointer collectionPointer;

    private List<String> testCollection;

    @BeforeEach
    public void setUp() {
        testCollection = new ArrayList<>();
        testCollection.add("value1");
        testCollection.add("value2");
        collectionPointer = new CollectionPointer(testCollection, Locale.ENGLISH);
    }

    @Test
    public void testGetValuePointer_WholeCollection() throws Exception {
        // Set index to WHOLE_COLLECTION
        // Assuming -1 represents WHOLE_COLLECTION
        setIndex(collectionPointer, -1);
        NodePointer valuePointer = invokeGetValuePointer(collectionPointer);
        assertSame(collectionPointer, valuePointer);
    }

    @Test
    public void testGetValuePointer_SingleValue() throws Exception {
        // Set index to 0
        setIndex(collectionPointer, 0);
        NodePointer valuePointer = invokeGetValuePointer(collectionPointer);
        assertNotNull(valuePointer);
        assertEquals("value1", ValueUtils.getValue(valuePointer.getImmediateNode()));
    }

    private NodePointer invokeGetValuePointer(CollectionPointer collectionPointer) throws Exception {
        Method method = CollectionPointer.class.getDeclaredMethod("getValuePointer");
        method.setAccessible(true);
        return (NodePointer) method.invoke(collectionPointer);
    }

    private void setIndex(CollectionPointer collectionPointer, int index) throws Exception {
        Method method = CollectionPointer.class.getDeclaredMethod("setIndex", int.class);
        method.setAccessible(true);
        method.invoke(collectionPointer, index);
    }
}
