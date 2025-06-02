package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class util_internal_LinkedDeque_linkLast_Linked_cfg_path_2_Test {

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
    public void testLinkLastWhenLastIsNull() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl element = new LinkedImpl();

        deque.linkLast(element);

        // Verify that both first and last point to the new element
        assertEquals(element, deque.first);
        assertEquals(element, deque.last);
    }

    @Test(timeout = 4000)
    public void testLinkLastWhenLastIsNotNull() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl firstElement = new LinkedImpl();
        LinkedImpl secondElement = new LinkedImpl();

        // Link the first element
        deque.linkLast(firstElement);
        // Link the second element
        deque.linkLast(secondElement);

        // Verify that the first element's next points to the second element
        assertEquals(secondElement, firstElement.getNext());
        // Verify that the second element's previous points to the first element
        assertEquals(firstElement, secondElement.getPrevious());
        // Verify that last points to the second element
        assertEquals(secondElement, deque.last);
    }

}