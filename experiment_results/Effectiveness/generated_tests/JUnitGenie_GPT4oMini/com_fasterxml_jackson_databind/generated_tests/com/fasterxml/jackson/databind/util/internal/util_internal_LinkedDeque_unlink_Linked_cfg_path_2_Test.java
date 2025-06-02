package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_unlink_Linked_cfg_path_2_Test {

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
    public void testUnlink() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl element = new LinkedImpl();
        LinkedImpl prevElement = new LinkedImpl();
        LinkedImpl nextElement = new LinkedImpl();

        // Set up the linked structure
        element.setPrevious(prevElement);
        element.setNext(nextElement);
        prevElement.setNext(element);
        nextElement.setPrevious(element);

        // Call the unlink method
        try {
            deque.unlink(element);
        } catch (Exception e) {
            fail("unlink method threw an exception: " + e.getMessage());
        }

        // Verify the unlinking
        assertNull(element.getPrevious());
        assertNull(element.getNext());
        assertEquals(nextElement, prevElement.getNext());
        assertEquals(prevElement, nextElement.getPrevious());
        assertEquals(prevElement, deque.last);
    }

}