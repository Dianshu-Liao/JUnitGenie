package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class list_AbstractLinkedList_remove_Object_cfg_path_4_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedList<E> {
        private Node<E> head;
        private Node<E> tail;
        private int size;

        private class Node<E> { // Changed from static to non-static
            E value;
            Node<E> next;
            Node<E> prev;

            Node(E value) {
                this.value = value;
            }
        }

        public ConcreteLinkedList() {
            head = null;
            tail = null;
            size = 0;
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
            return current.value;
        }

        @Override
        public int size() {
            return size;
        }

        @Override
        public boolean add(E e) {
            Node<E> newNode = new Node<>(e);
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
            return true;
        }

        @Override
        public boolean remove(Object o) {
            Node<E> current = head;
            while (current != null) {
                if (current.value.equals(o)) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next; // Removing head
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev; // Removing tail
                    }
                    size--;
                    return true;
                }
                current = current.next;
            }
            return false;
        }
    }

    @Test(timeout = 4000)
    public void testRemove() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        // Add elements to the list to set up the test
        list.add("test");
        list.add("value");
        
        // Test removing an existing value
        boolean result = false;
        try {
            result = list.remove("value");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertTrue(result);
        
        // Test removing a non-existing value
        try {
            result = list.remove("nonexistent");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        assertFalse(result);
    }


}