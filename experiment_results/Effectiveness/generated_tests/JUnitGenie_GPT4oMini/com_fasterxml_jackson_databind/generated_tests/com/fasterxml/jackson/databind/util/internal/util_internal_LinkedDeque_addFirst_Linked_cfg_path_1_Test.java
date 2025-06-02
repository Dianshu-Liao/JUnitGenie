package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.fail;

public class util_internal_LinkedDeque_addFirst_Linked_cfg_path_1_Test {

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
    public void testAddFirstThrowsIllegalArgumentException() {
        LinkedDeque deque = new LinkedDeque();
        Linked e = new LinkedImpl(); // Create an instance of Linked

        try {
            deque.addFirst(e); // This should throw IllegalArgumentException
            fail("Expected IllegalArgumentException to be thrown");
        } catch (IllegalArgumentException ex) {
            // Exception is expected, test passes
        }
    }

}