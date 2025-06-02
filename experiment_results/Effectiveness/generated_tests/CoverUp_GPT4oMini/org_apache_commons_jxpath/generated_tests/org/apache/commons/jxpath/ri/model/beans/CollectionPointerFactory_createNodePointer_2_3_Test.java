package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Locale;

public class CollectionPointerFactory_createNodePointer_2_3_Test {

    private CollectionPointerFactory factory;

    @BeforeEach
    public void setUp() {
        factory = new CollectionPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithCollection() {
        List<String> collection = new ArrayList<>();
        QName qName = new QName("test");
        // Mock parent NodePointer
        NodePointer parent = mock(NodePointer.class);
        NodePointer result = factory.createNodePointer(parent, qName, collection);
        assertNotNull(result, "Expected a non-null NodePointer for a collection.");
    }

    @Test
    public void testCreateNodePointerWithNonCollection() {
        String nonCollection = "Not a collection";
        QName qName = new QName("test");
        // Mock parent NodePointer
        NodePointer parent = mock(NodePointer.class);
        NodePointer result = factory.createNodePointer(parent, qName, nonCollection);
        assertNull(result, "Expected a null NodePointer for a non-collection.");
    }

    @Test
    public void testCreateNodePointerWithNull() {
        QName qName = new QName("test");
        // Mock parent NodePointer
        NodePointer parent = mock(NodePointer.class);
        NodePointer result = factory.createNodePointer(parent, qName, null);
        assertNull(result, "Expected a null NodePointer for a null bean.");
    }

    // Reflection test for private methods if needed
    private Object invokePrivateMethod(String methodName, Object... args) throws Exception {
        Method method = CollectionPointerFactory.class.getDeclaredMethod(methodName, getParameterTypes(args));
        method.setAccessible(true);
        return method.invoke(factory, args);
    }

    private Class<?>[] getParameterTypes(Object... args) {
        return java.util.Arrays.stream(args).map(Object::getClass).toArray(Class<?>[]::new);
    }
}
