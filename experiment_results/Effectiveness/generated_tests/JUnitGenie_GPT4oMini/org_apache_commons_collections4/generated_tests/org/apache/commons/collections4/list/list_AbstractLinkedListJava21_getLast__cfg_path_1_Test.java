package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.NoSuchElementException;

public class list_AbstractLinkedListJava21_getLast__cfg_path_1_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedListJava21 {
        // Implement abstract methods if necessary
    }

    @Test(timeout = 4000)
    public void testGetLast() {
        try {
            // Use reflection to access the protected constructor
            Constructor<AbstractLinkedListJava21> constructor = AbstractLinkedListJava21.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            AbstractLinkedListJava21 list = constructor.newInstance();

            // Add a node to the list to ensure the header is not the only node
            // Assuming there is a method to add elements, which is not shown in the focal method
            // list.add("First Element"); // Uncomment and implement if necessary

            // Now we can call getLast() and expect it to return the last element
            Object lastElement = list.getLast();
            // Add assertions based on expected behavior
            // assertEquals("First Element", lastElement); // Uncomment and implement if necessary

        } catch (NoSuchElementException e) {
            // This exception is expected if the list is empty
            fail("Expected to get last element, but got NoSuchElementException: " + e.getMessage());
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            fail("Exception occurred while creating instance: " + e.getMessage());
        }
    }

}