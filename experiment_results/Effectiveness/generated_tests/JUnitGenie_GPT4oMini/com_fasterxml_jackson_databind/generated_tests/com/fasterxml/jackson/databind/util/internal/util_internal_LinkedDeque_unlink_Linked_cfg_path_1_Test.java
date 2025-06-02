package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_unlink_Linked_cfg_path_1_Test {

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
        LinkedImpl node1 = new LinkedImpl();
        LinkedImpl node2 = new LinkedImpl();
        LinkedImpl node3 = new LinkedImpl();

        // Set up the linked structure: node1 <-> node2 <-> node3
        node1.setNext(node2);
        node2.setPrevious(node1);
        node2.setNext(node3);
        node3.setPrevious(node2);

        // Unlink node2
        try {
            deque.unlink(node2);
        } catch (Exception e) {
            fail("unlink method threw an exception: " + e.getMessage());
        }

        // Verify the links are updated correctly
        assertNull(node2.getPrevious());
        assertNull(node2.getNext());
        assertEquals(node1, node3.getPrevious());
        assertEquals(node3, node1.getNext());
    }

}