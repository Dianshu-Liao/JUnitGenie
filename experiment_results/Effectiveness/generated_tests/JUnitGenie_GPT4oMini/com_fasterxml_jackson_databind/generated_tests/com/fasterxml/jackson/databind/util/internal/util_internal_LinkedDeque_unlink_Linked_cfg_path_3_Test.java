package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_unlink_Linked_cfg_path_3_Test {

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
        deque.first = firstElement; // Directly accessing for test setup
        deque.last = secondElement;

        // Call the method under test
        try {
            deque.unlink(firstElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the first element is unlinked
        assertEquals(secondElement, deque.first);
        assertNull(firstElement.getNext());
        assertNull(firstElement.getPrevious());
    }

    @Test(timeout = 4000)
    public void testUnlinkMiddleElement() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl secondElement = new LinkedImpl();
        LinkedImpl thirdElement = new LinkedImpl();

        // Set up the linked structure
        firstElement.setNext(secondElement);
        secondElement.setPrevious(firstElement);
        secondElement.setNext(thirdElement);
        thirdElement.setPrevious(secondElement);
        deque.first = firstElement;
        deque.last = thirdElement;

        // Call the method under test
        try {
            deque.unlink(secondElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the middle element is unlinked
        assertEquals(firstElement, deque.first);
        assertEquals(thirdElement, firstElement.getNext());
        assertNull(secondElement.getNext());
        assertNull(secondElement.getPrevious());
    }

    @Test(timeout = 4000)
    public void testUnlinkLastElement() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl secondElement = new LinkedImpl();

        // Set up the linked structure
        firstElement.setNext(secondElement);
        secondElement.setPrevious(firstElement);
        deque.first = firstElement;
        deque.last = secondElement;

        // Call the method under test
        try {
            deque.unlink(secondElement);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }

        // Verify the last element is unlinked
        assertEquals(firstElement, deque.first);
        assertNull(firstElement.getNext());
        assertNull(secondElement.getPrevious());
        assertNull(deque.last);
    }

}