package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedList;
import org.junit.Test;
import static org.junit.Assert.*;

public class list_AbstractLinkedList_remove_Object_cfg_path_1_Test {

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
            if (size == 0) {
                head = tail = newNode;
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
            return false; // Not found
        }
    }

    @Test(timeout = 4000)
    public void testRemoveNodeExists() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("test");
        list.add("value");
        
        boolean result = false;
        try {
            result = list.remove("value");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        
        assertTrue("The value should be removed successfully", result);
    }

    @Test(timeout = 4000)
    public void testRemoveNodeDoesNotExist() {
        ConcreteLinkedList<String> list = new ConcreteLinkedList<>();
        list.add("test");
        
        boolean result = false;
        try {
            result = list.remove("nonexistent");
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
        
        assertFalse("The value should not be found and removed", result);
    }

}