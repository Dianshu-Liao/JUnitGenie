package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.*;
import org.apache.commons.collections4.CollectionUtils;

public class list_AbstractLinkedListJava21_lastIndexOf_Object_cfg_path_2_Test {

    private class ConcreteLinkedList extends AbstractLinkedListJava21 {
        // Implementing the abstract methods required for instantiation
        protected ConcreteLinkedList() {
            super();
        }

        protected ConcreteLinkedList(java.util.Collection<?> collection) {
            super(collection);
        }

        // Implement other abstract methods if necessary
        @Override
        public void addNodeBefore(Node node, Object element) {
            // Ensure the node is not null before adding
            if (node == null) {
                throw new NullPointerException("insertBeforeNode");
            }
            super.addNodeBefore(node, element);
        }

        @Override
        public void addNodeAfter(Node node, Object element) {
            // Ensure the node is not null before adding
            if (node == null) {
                throw new NullPointerException("insertAfterNode");
            }
            super.addNodeAfter(node, element);
        }

        @Override
        public void addFirst(Object element) {
            // Ensure the element is not null before adding
            if (element == null) {
                throw new NullPointerException("insertFirstNode");
            }
            super.addFirst(element);
        }

        @Override
        public void addLast(Object element) {
            // Ensure the element is not null before adding
            if (element == null) {
                throw new NullPointerException("insertLastNode");
            }
            super.addLast(element);
        }
    }

    @Test(timeout = 4000)
    public void testLastIndexOf() {
        ConcreteLinkedList list = new ConcreteLinkedList();
        // Assuming we have a method to add elements to the list
        list.add("test");
        list.add("example");
        list.add("test");

        // Test case where the value exists in the list
        int index = list.lastIndexOf("test");
        assertEquals(2, index); // Assuming "test" is at index 2

        // Test case where the value does not exist in the list
        index = list.lastIndexOf("nonexistent");
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);

        // Test case with null value
        index = list.lastIndexOf(null);
        assertEquals(CollectionUtils.INDEX_NOT_FOUND, index);
    }


}