package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class list_AbstractLinkedList_indexOf_Object_cfg_path_4_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedList<E> {
        private Node<E> head;
        private int size;

        private class Node<E> { // Changed from static to non-static
            E data;
            Node<E> next;

            Node(E data) {
                this.data = data;
            }
        }

        @Override
        public E get(int index) {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
            }
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean add(E value) { // Changed return type to boolean
            Node<E> newNode = new Node<>(value);
            if (head == null) {
                head = newNode;
            } else {
                Node<E> current = head;
                while (current.next != null) {
                    current = current.next;
                }
                current.next = newNode;
            }
            size++;
            return true; // Return true after adding the element
        }

        @Override
        public int indexOf(Object o) {
            Node<E> current = head;
            for (int i = 0; i < size; i++) {
                if (current.data.equals(o)) {
                    return i;
                }
                current = current.next;
            }
            return -1; // Return -1 if not found
        }
    }

    @Test(timeout = 4000)
    public void testIndexOfValueNotFound() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        // Assuming the list is empty, we expect INDEX_NOT_FOUND
        int result = list.indexOf("testValue");
        assertEquals(-1, result);
    }

    @Test(timeout = 4000)
    public void testIndexOfValueFound() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        // Add elements to the list
        list.add("testValue");
        list.add("anotherValue");
        
        // Assuming "testValue" is at index 0
        int result = list.indexOf("testValue");
        assertEquals(0, result);
    }

}