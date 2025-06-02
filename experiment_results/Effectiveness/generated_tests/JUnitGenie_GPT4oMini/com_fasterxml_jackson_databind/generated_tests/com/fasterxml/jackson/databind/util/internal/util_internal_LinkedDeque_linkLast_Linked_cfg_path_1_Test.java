package com.fasterxml.jackson.databind.util.internal;
import com.fasterxml.jackson.databind.util.internal.LinkedDeque;
import com.fasterxml.jackson.databind.util.internal.Linked;
import org.junit.Test;
import static org.junit.Assert.*;

public class util_internal_LinkedDeque_linkLast_Linked_cfg_path_1_Test {

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
    public void testLinkLast() {
        LinkedDeque deque = new LinkedDeque();
        LinkedImpl element = new LinkedImpl();

        try {
            deque.linkLast(element);
            assertEquals(element, deque.last); // Check if last is now the element
            assertEquals(element, deque.first); // Check if first is also the element since last was null

        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }

        LinkedImpl secondElement = new LinkedImpl();
        try {
            deque.linkLast(secondElement);
            assertEquals(secondElement, deque.last); // Check if last is now the second element
            assertEquals(element, secondElement.getPrevious()); // Check if the previous of secondElement is the first element
            assertEquals(secondElement, element.getNext()); // Check if the next of first element is the second element

        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}