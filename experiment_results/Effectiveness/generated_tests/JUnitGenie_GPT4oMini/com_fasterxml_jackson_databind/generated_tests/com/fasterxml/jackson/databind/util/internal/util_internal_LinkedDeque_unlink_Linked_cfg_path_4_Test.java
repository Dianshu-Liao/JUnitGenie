package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_unlink_Linked_cfg_path_4_Test {

    private class LinkedImpl implements Linked {
        private Linked next;
        private Linked previous;

        @Override
        public Linked getNext() {
            return next;
        }

        @Override
        public Linked getPrevious() {
            return previous;
        }

        @Override
        public void setNext(Linked next) {
            this.next = next;
        }

        @Override
        public void setPrevious(Linked previous) {
            this.previous = previous;
        }
    }

    @Test(timeout = 4000)
    public void testUnlinkFirstElement() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl secondElement = new LinkedImpl();
        
        // Set up the linked structure
        firstElement.setNext(secondElement);
        secondElement.setPrevious(firstElement);
        
        // Assign first and last
        deque.first = firstElement;
        deque.last = secondElement;

        // Call the method under test
        try {
            deque.unlink(firstElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the first element is unlinked
        assertEquals(deque.first, secondElement);
        assertNull(firstElement.getPrevious());
        assertNull(firstElement.getNext());
    }

    @Test(timeout = 4000)
    public void testUnlinkLastElement() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl secondElement = new LinkedImpl();
        
        // Set up the linked structure
        firstElement.setNext(secondElement);
        secondElement.setPrevious(firstElement);
        
        // Assign first and last
        deque.first = firstElement;
        deque.last = secondElement;

        // Call the method under test
        try {
            deque.unlink(secondElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the last element is unlinked
        assertEquals(deque.last, firstElement);
        assertNull(secondElement.getPrevious());
        assertNull(secondElement.getNext());
    }

    @Test(timeout = 4000)
    public void testUnlinkMiddleElement() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl middleElement = new LinkedImpl();
        LinkedImpl lastElement = new LinkedImpl();
        
        // Set up the linked structure
        firstElement.setNext(middleElement);
        middleElement.setPrevious(firstElement);
        middleElement.setNext(lastElement);
        lastElement.setPrevious(middleElement);
        
        // Assign first and last
        deque.first = firstElement;
        deque.last = lastElement;

        // Call the method under test
        try {
            deque.unlink(middleElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the middle element is unlinked
        assertEquals(deque.first.getNext(), lastElement);
        assertEquals(deque.last.getPrevious(), firstElement);
        assertNull(middleElement.getPrevious());
        assertNull(middleElement.getNext());
    }

}