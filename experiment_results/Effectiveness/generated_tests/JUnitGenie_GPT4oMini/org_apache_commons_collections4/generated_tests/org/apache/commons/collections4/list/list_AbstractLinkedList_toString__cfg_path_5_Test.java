package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;

public class list_AbstractLinkedList_toString__cfg_path_5_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedList<E> {
        public ConcreteLinkedList() {
            super();
        }

        @Override
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override
        public int size() {
            return super.size();
        }

        @Override
        public Iterator<E> iterator() {
            return super.iterator();
        }

    }

    // Assuming Node is a static inner class of AbstractLinkedList
    private static class Node<E> {
        E element;
        Node<E> next;

        Node(E element) {
            this.element = element;
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithElements() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("element1");
        list.add("element2");

        String expected = "[element1, element2]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToStringEmpty() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();

        String expected = "[]";
        String actual = list.toString();
        assertEquals(expected, actual);
    }

}
