package org.apache.commons.collections4.list;
import static org.junit.Assert.assertEquals;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;

public class list_AbstractLinkedList_toString__cfg_path_6_Test {

    private static class ConcreteLinkedList<E> extends AbstractLinkedList<E> {
        public ConcreteLinkedList() {
            super(); // Call to protected constructor
        }

        // Implement the required abstract methods if there are any
        @Override
        public boolean isEmpty() {
            return super.isEmpty();
        }

        @Override
        public int size() {
            return super.size();
        }

        @Override
        public E get(int index) {
            return super.get(index);
        }
        
        @Override
        public boolean add(E element) {
            // Custom implementation for adding elements to the list for testing purposes
            if (element == null) {
                throw new NullPointerException("Element cannot be null");
            }
            return super.add(element);
        }
    }

    @Test(timeout = 4000)
    public void testToStringWhenNotEmpty() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("element1");
        list.add("element2");

        String expected = "[element1, element2]";
        String actual = list.toString();

        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToStringWhenEmpty() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();

        String actual = list.toString();
        String expected = "[]";
        assertEquals(expected, actual);
    }


}