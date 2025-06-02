package org.apache.commons.jxpath.ri.model.beans;

import org.apache.commons.jxpath.ri.QName;
import org.apache.commons.jxpath.ri.model.NodePointer;
import org.apache.commons.jxpath.util.ValueUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.apache.commons.jxpath.ri.model.NodePointerFactory;

public class CollectionPointerFactory_createNodePointer_1_0_Test {

    private final CollectionPointerFactory factory = new CollectionPointerFactory();

    @Test
    public void testCreateNodePointerWithList() {
        QName name = new QName("testList");
        ArrayList<String> list = new ArrayList<>();
        list.add("item1");
        list.add("item2");
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, list, locale);
        assertNotNull(pointer, "NodePointer should not be null for a List.");
    }

    @Test
    public void testCreateNodePointerWithSet() {
        QName name = new QName("testSet");
        HashSet<String> set = new HashSet<>();
        set.add("item1");
        set.add("item2");
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, set, locale);
        assertNotNull(pointer, "NodePointer should not be null for a Set.");
    }

    @Test
    public void testCreateNodePointerWithArray() {
        QName name = new QName("testArray");
        String[] array = new String[] { "item1", "item2" };
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, array, locale);
        assertNotNull(pointer, "NodePointer should not be null for an Array.");
    }

    @Test
    public void testCreateNodePointerWithNull() {
        QName name = new QName("testNull");
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, null, locale);
        assertNull(pointer, "NodePointer should be null for a null bean.");
    }

    @Test
    public void testCreateNodePointerWithNonCollection() {
        QName name = new QName("testNonCollection");
        String nonCollection = "not a collection";
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, nonCollection, locale);
        assertNull(pointer, "NodePointer should be null for a non-collection object.");
    }

    @Test
    public void testCreateNodePointerWithEmptyList() {
        QName name = new QName("testEmptyList");
        ArrayList<String> emptyList = new ArrayList<>();
        Locale locale = Locale.getDefault();
        NodePointer pointer = factory.createNodePointer(name, emptyList, locale);
        assertNotNull(pointer, "NodePointer should not be null for an empty List.");
    }
}
