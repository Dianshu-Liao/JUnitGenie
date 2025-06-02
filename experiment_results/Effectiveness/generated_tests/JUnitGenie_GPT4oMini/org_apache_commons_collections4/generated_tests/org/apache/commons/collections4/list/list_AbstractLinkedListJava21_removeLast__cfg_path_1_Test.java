package org.apache.commons.collections4.list;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;
import static org.junit.Assert.fail;
import java.util.NoSuchElementException;
import java.lang.reflect.Constructor;

public class list_AbstractLinkedListJava21_removeLast__cfg_path_1_Test {

    private class ConcreteLinkedList<E> extends AbstractLinkedListJava21<E> {
        // Implementing the abstract methods as needed for testing
        @Override
        public E removeLast() {
            return super.removeLast();
        }
        
        // Other abstract methods would need to be implemented here
    }

    @Test(timeout = 4000)
    public void testRemoveLastThrowsNoSuchElementException() {
        try {
            // Create an instance of the concrete class using reflection
            Constructor<ConcreteLinkedList> constructor = ConcreteLinkedList.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            ConcreteLinkedList<Object> list = constructor.newInstance();

            // Attempt to remove the last element from an empty list
            list.removeLast();
        } catch (NoSuchElementException e) {
            // Expected exception
            return;
        } catch (Exception e) {
            // Handle any other exceptions that may occur
            e.printStackTrace();
        }
        // If we reach this point, the exception was not thrown as expected
        fail("Expected NoSuchElementException was not thrown.");
    }

}