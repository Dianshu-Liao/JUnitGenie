package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.beans.CollectionPointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class CollectionPointerFactory_createNodePointer_1_0_Test {

    private CollectionPointerFactory collectionPointerFactory;

    @BeforeEach
    public void setUp() {
        collectionPointerFactory = new CollectionPointerFactory();
    }

    @Test
    public void testCreateNodePointerWithCollection() {
        QName qName = new QName("testCollection");
        ArrayList<String> bean = new ArrayList<>();
        bean.add("item1");
        Locale locale = Locale.getDefault();
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(qName, bean, locale);
        assertNotNull(nodePointer, "NodePointer should not be null when bean is a collection.");
    }

    @Test
    public void testCreateNodePointerWithNull() {
        QName qName = new QName("testNull");
        Object bean = null;
        Locale locale = Locale.getDefault();
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(qName, bean, locale);
        assertNull(nodePointer, "NodePointer should be null when bean is null.");
    }

    @Test
    public void testCreateNodePointerWithNonCollection() {
        QName qName = new QName("testNonCollection");
        String bean = "not a collection";
        Locale locale = Locale.getDefault();
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(qName, bean, locale);
        assertNull(nodePointer, "NodePointer should be null when bean is not a collection.");
    }

    @Test
    public void testCreateNodePointerWithEmptyCollection() {
        QName qName = new QName("testEmptyCollection");
        ArrayList<String> bean = new ArrayList<>();
        Locale locale = Locale.getDefault();
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(qName, bean, locale);
        assertNotNull(nodePointer, "NodePointer should not be null when bean is an empty collection.");
    }

    @Test
    public void testCreateNodePointerWithImmutableCollection() {
        QName qName = new QName("testImmutableCollection");
        ArrayList<String> bean = new ArrayList<>(Collections.singletonList("item1"));
        Locale locale = Locale.getDefault();
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(qName, Collections.unmodifiableList(bean), locale);
        assertNull(nodePointer, "NodePointer should be null when bean is an immutable collection.");
    }
}
