package org.apache.commons.collections4.list;

import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.AbstractList;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Deque;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.OrderedIterator;

public class TreeList_indexOf_6_0_Test {

    private TreeList<Object> treeList;

    @BeforeEach
    public void setUp() {
        treeList = new TreeList<>();
    }

    @Test
    public void testIndexOfWhenEmpty() {
        assertEquals(-1, treeList.indexOf("test"));
    }

    @Test
    public void testIndexOfWhenElementExists() {
        treeList.add("element1");
        treeList.add("element2");
        treeList.add("test");
        treeList.add("element3");
        assertEquals(2, treeList.indexOf("test"));
    }

    @Test
    public void testIndexOfWhenElementDoesNotExist() {
        treeList.add("element1");
        treeList.add("element2");
        assertEquals(-1, treeList.indexOf("test"));
    }

    @Test
    public void testIndexOfWithNullElement() {
        treeList.add("element1");
        treeList.add(null);
        treeList.add("element3");
        assertEquals(1, treeList.indexOf(null));
    }

    @Test
    public void testIndexOfWithMultipleOccurrences() {
        treeList.add("test");
        treeList.add("element");
        treeList.add("test");
        assertEquals(0, treeList.indexOf("test"));
    }

    @Test
    public void testIndexOfWhenListIsNull() {
        treeList = null;
        assertThrows(NullPointerException.class, () -> {
            treeList.indexOf("test");
        });
    }

    @Test
    public void testIndexOfWithComplexObjects() {
        class CustomObject {

            String name;

            CustomObject(String name) {
                this.name = name;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null || getClass() != obj.getClass())
                    return false;
                CustomObject that = (CustomObject) obj;
                return Objects.equals(name, that.name);
            }
        }
        TreeList<CustomObject> customObjectTreeList = new TreeList<>();
        CustomObject obj1 = new CustomObject("test");
        CustomObject obj2 = new CustomObject("notTest");
        customObjectTreeList.add(obj1);
        customObjectTreeList.add(obj2);
        assertEquals(0, customObjectTreeList.indexOf(new CustomObject("test")));
    }
}
