package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.apache.commons.collections4.list.AbstractLinkedListJava21.Node;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.NoSuchElementException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class list_AbstractLinkedListJava21_removeLast__cfg_path_2_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedListJava21<E> {
        // Implementing the abstract methods as needed for testing
        @Override
        public void add(int index, E element) {
            // Implementation for testing purposes
        }

        @Override
        public E get(int index) {
            // Implementation for testing purposes
            return null;
        }

        @Override
        public E remove(int index) {
            // Implementation for testing purposes
            return null;
        }

        @Override
        public int size() {
            // Implementation for testing purposes
            return 1; // Return 1 to ensure the list is not empty
        }
    }

    @Test(timeout = 4000)
    public void testRemoveLast() {
        try {
            // Use reflection to access the protected constructor
            Constructor<ConcreteLinkedList> constructor = ConcreteLinkedList.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            ConcreteLinkedList<Object> list = constructor.newInstance();

            // Create a node and set it as the last node in the list
            Node<Object> node = new Node<>();
            node.value = new Object(); // Ensure the value is non-null
            list.header.previous = node; // Set the previous node to our test node
            list.header = node; // Set header to point to our test node

            // Now we can call removeLast and expect it to return the value
            Object result = list.removeLast();
            assertNotNull(result); // Ensure the result is not null
            assertEquals(node.value, result); // Ensure the returned value is correct

        } catch (NoSuchElementException e) {
            fail("Expected to remove a node, but NoSuchElementException was thrown.");
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Failed to create an instance of ConcreteLinkedList: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testRemoveLastThrowsNoSuchElementException() {
        try {
            // Use reflection to access the protected constructor
            Constructor<ConcreteLinkedList> constructor = ConcreteLinkedList.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            ConcreteLinkedList<Object> list = constructor.newInstance();

            // Set the header to point to itself, simulating an empty list
            list.header = list.header; // This simulates an empty list

            // This should throw NoSuchElementException
            list.removeLast();
            fail("Expected NoSuchElementException to be thrown.");
        } catch (NoSuchElementException e) {
            // Expected exception
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Failed to create an instance of ConcreteLinkedList: " + e.getMessage());
        }
    }


}