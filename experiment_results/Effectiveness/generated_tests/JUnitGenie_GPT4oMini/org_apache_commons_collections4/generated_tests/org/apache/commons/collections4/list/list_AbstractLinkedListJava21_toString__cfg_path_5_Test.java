package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;

public class list_AbstractLinkedListJava21_toString__cfg_path_5_Test {

    private class ConcreteLinkedList extends AbstractLinkedListJava21 {
        private final ArrayList<Object> elements = new ArrayList<>();

        @Override
        public int size() {
            return elements.size();
        }

        @Override
        public Iterator<Object> iterator() {
            return elements.iterator();
        }

        @Override
        public boolean add(Object element) {
            return elements.add(element); // Change return type to boolean
        }

        public void clear() {
            elements.clear();
        }

        public boolean isEmpty() {
            return elements.isEmpty();
        }
    }

    @Test(timeout = 4000)
    public void testToString_notEmpty() {
        try {
            // Create an instance of the concrete linked list
            ConcreteLinkedList list = new ConcreteLinkedList();
            list.add("Element 1");
            list.add("Element 2");

            // Verify toString output
            String expected = "[Element 1, Element 2]";
            String actual = list.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            // Handle any exceptions that may arise
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testToString_empty() {
        try {
            // Create an instance of the concrete linked list
            ConcreteLinkedList list = new ConcreteLinkedList();

            // Verify toString output
            String expected = "[]";
            String actual = list.toString();
            assertEquals(expected, actual);
        } catch (Exception e) {
            // Handle any exceptions that may arise
            e.printStackTrace();
            fail("Exception thrown: " + e.getMessage());
        }
    }


}