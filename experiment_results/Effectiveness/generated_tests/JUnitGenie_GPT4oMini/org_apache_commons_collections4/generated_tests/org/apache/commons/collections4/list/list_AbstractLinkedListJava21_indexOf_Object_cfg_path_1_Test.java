package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.collections4.CollectionUtils;

public class list_AbstractLinkedListJava21_indexOf_Object_cfg_path_1_Test {

    private class ConcreteLinkedList extends AbstractLinkedListJava21 {
        private Node head;
        private Node tail;
        private int size;

        private class Node {
            Object element;
            Node next;
            Node prev;

            Node(Object element) {
                this.element = element;
            }
        }

        @Override
        public void add(int index, Object element) {
            if (element == null) {
                throw new NullPointerException("Element cannot be null");
            }
            Node newNode = new Node(element);
            if (index == size) {
                addLast(newNode);
            } else {
                Node current = getNode(index);
                if (current != null) {
                    newNode.next = current;
                    newNode.prev = current.prev;
                    if (current.prev != null) {
                        current.prev.next = newNode;
                    }
                    current.prev = newNode;
                    if (index == 0) {
                        head = newNode;
                    }
                }
            }
            size++;
        }

        private void addLast(Node newNode) {
            if (tail == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
        }

        @Override
        public Object get(int index) {
            Node node = getNode(index);
            return (node != null) ? node.element : null;
        }

        private Node getNode(int index) {
            if (index < 0 || index >= size) {
                return null;
            }
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current;
        }

        @Override
        public int size() {
            return size;
        }
    }

    @Test(timeout = 4000)
    public void testIndexOf() {
        ConcreteLinkedList list = new ConcreteLinkedList();
        list.add(0, "test1");
        list.add(1, "test2");
        list.add(2, "test3");

        // Test for an existing value
        int index = list.indexOf("test2");
        assertEquals(1, index);

        // Test for a non-existing value
        index = list.indexOf("test4");
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }

    @Test(timeout = 4000)
    public void testIndexOfWithNullValue() {
        ConcreteLinkedList list = new ConcreteLinkedList();
        list.add(0, "test1");
        list.add(1, "test2");

        // Test for null value
        int index = list.indexOf(null);
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }

    @Test(timeout = 4000)
    public void testIndexOfEmptyList() {
        ConcreteLinkedList list = new ConcreteLinkedList();

        // Test indexOf on an empty list
        int index = list.indexOf("test");
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }

}