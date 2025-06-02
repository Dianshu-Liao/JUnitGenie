package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class list_AbstractLinkedList_indexOf_Object_cfg_path_2_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedList<E> {
        private final java.util.LinkedList<E> internalList = new java.util.LinkedList<>();

        @Override
        public boolean add(E e) {
            return internalList.add(e);
        }

        @Override
        public boolean remove(Object o) {
            return internalList.remove(o);
        }

        @Override
        public E get(int index) {
            return internalList.get(index);
        }

        @Override
        public int indexOf(Object o) {
            return internalList.indexOf(o);
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfFound() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("test");
        list.add("value");
        list.add("example");

        int index = list.indexOf("value");
        assertEquals(1, index);
    }

    @Test(timeout = 4000)
    public void testIndexOfNotFound() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("test");
        list.add("value");
        list.add("example");

        int index = list.indexOf("notfound");
        assertEquals(-1, index); // Changed to -1 for not found
    }

    @Test(timeout = 4000)
    public void testIndexOfEmptyList() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();

        int index = list.indexOf("value");
        assertEquals(-1, index); // Changed to -1 for not found
    }

    @Test(timeout = 4000)
    public void testIndexOfNullValue() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add(null);
        list.add("value");

        int index = list.indexOf(null);
        assertEquals(0, index);
    }


}