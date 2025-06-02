package org.apache.commons.collections4.iterators;
import org.apache.commons.collections4.iterators.SingletonListIterator;
import org.junit.Test;
import static org.junit.Assert.fail;

public class iterators_SingletonListIterator_remove__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testRemove_ThrowsIllegalStateException_WhenNextNotCalledAndRemoved() {
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        
        // Simulate the state where nextCalled is false and removed is false
        // This is done by not calling next() before remove()
        
        try {
            iterator.remove(); // This should throw IllegalStateException
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Exception is expected, test passes
        }
    }

    @Test(timeout = 4000)
    public void testRemove_ThrowsIllegalStateException_WhenNextCalledAndAlreadyRemoved() {
        SingletonListIterator<Object> iterator = new SingletonListIterator<>(new Object());
        
        // Simulate the state where nextCalled is true and removed is true
        // This is done by calling next() and then remove()
        iterator.next(); // Simulate calling next
        iterator.remove(); // First remove call should succeed
        
        try {
            iterator.remove(); // This should throw IllegalStateException
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            // Exception is expected, test passes
        }
    }

}