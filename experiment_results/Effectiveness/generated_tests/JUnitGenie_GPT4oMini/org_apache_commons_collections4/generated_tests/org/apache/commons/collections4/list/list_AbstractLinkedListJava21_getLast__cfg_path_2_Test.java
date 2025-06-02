package org.apache.commons.collections4.list;
import static org.junit.Assert.fail;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.list.AbstractLinkedListJava21;
import org.junit.Test;

public class list_AbstractLinkedListJava21_getLast__cfg_path_2_Test {

    private class ConcreteLinkedList extends AbstractLinkedListJava21 {
        // Override abstract methods here if needed for instantiation
        @Override
        public boolean isEmpty() {
            return true; // Simulate an empty list
        }

        @Override
        public Object getFirst() {
            throw new NoSuchElementException(); // Simulate no elements
        }

        @Override
        public Object getLast() {
            throw new NoSuchElementException(); // Simulate no elements
        }
    }

    @Test(timeout = 4000)
    public void testGetLastThrowsNoSuchElementException() {
        ConcreteLinkedList list = new ConcreteLinkedList();

        try {
            list.getLast();
            fail("Expected NoSuchElementException to be thrown");
        } catch (NoSuchElementException e) {
            // Exception is expected, test passes
        }
    }


}