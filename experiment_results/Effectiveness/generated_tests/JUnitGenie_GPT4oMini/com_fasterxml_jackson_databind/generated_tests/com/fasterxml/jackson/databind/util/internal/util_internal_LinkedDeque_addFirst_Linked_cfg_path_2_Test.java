package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_addFirst_Linked_cfg_path_2_Test {

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
    public void testAddFirst_Success() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl linked = new LinkedImpl();
        linked.setPrevious(new LinkedImpl()); // Ensure getPrevious() returns a non-null Linked object

        try {
            deque.addFirst(linked);
        } catch (IllegalArgumentException e) {
            fail("Expected addFirst to succeed, but it threw an IllegalArgumentException");
        }
    }

    @Test(timeout = 4000)
    public void testAddFirst_Failure() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl linked = new LinkedImpl();
        // Assuming the deque is in a state that will cause offerFirst to return false
        // This can be set up by manipulating the internal state of deque if necessary

        try {
            deque.addFirst(linked);
            fail("Expected addFirst to throw IllegalArgumentException, but it did not.");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}