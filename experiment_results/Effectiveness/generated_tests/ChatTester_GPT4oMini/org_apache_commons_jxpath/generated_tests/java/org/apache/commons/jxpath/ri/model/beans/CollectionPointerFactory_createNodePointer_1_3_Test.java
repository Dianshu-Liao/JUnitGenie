package org.apache.commons.jxpath.ri.model.beans;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;
import org.apache.commons.jxpath.util.ValueUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CollectionPointerFactory_createNodePointer_1_3_Test {

    private CollectionPointerFactory collectionPointerFactory;

    @BeforeEach
    public void setUp() {
        collectionPointerFactory = new CollectionPointerFactory();
    }

    @Test
    public void testCreateNodePointer_WithCollection() {
        QName name = new QName("http://example.com", "test");
        Object bean = Arrays.asList("item1", "item2", "item3");
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(name, bean, locale);
        assertNotNull(nodePointer, "NodePointer should not be null for a collection bean.");
    }

    @Test
    public void testCreateNodePointer_WithEmptyCollection() {
        QName name = new QName("http://example.com", "test");
        Object bean = Collections.emptyList();
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(name, bean, locale);
        assertNotNull(nodePointer, "NodePointer should not be null for an empty collection bean.");
    }

    @Test
    public void testCreateNodePointer_WithNonCollection() {
        QName name = new QName("http://example.com", "test");
        Object bean = "not a collection";
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(name, bean, locale);
        assertNull(nodePointer, "NodePointer should be null for a non-collection bean.");
    }

    @Test
    public void testCreateNodePointer_WithNullBean() {
        QName name = new QName("http://example.com", "test");
        Object bean = null;
        Locale locale = Locale.ENGLISH;
        NodePointer nodePointer = collectionPointerFactory.createNodePointer(name, bean, locale);
        assertNull(nodePointer, "NodePointer should be null for a null bean.");
    }
}
