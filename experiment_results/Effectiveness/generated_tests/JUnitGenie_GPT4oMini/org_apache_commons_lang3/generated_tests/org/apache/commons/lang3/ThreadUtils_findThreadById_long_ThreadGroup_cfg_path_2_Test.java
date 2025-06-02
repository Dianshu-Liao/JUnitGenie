package org.apache.commons.lang3;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThreadUtils_findThreadById_long_ThreadGroup_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testFindThreadById_ValidThread() {
        // Create a ThreadGroup
        ThreadGroup threadGroup = new ThreadGroup("TestGroup");
        
        // Create a thread and start it
        Thread thread = new Thread(threadGroup, () -> {
            // Thread logic here
        }, "TestThread");
        thread.start();
        
        // Ensure the thread is alive before testing
        try {
            Thread.sleep(100); // Wait for the thread to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test the focal method
        Thread foundThread = ThreadUtils.findThreadById(thread.getId(), threadGroup);
        assertNotNull("Thread should be found", foundThread);
        assertEquals("Found thread should match the created thread", thread, foundThread);
    }

    @Test(timeout = 4000)
    public void testFindThreadById_ThreadNotInGroup() {
        // Create two ThreadGroups
        ThreadGroup threadGroup1 = new ThreadGroup("Group1");
        ThreadGroup threadGroup2 = new ThreadGroup("Group2");
        
        // Create a thread in the first group
        Thread thread = new Thread(threadGroup1, () -> {
            // Thread logic here
        }, "TestThread");
        thread.start();
        
        // Ensure the thread is alive before testing
        try {
            Thread.sleep(100); // Wait for the thread to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test the focal method with a different group
        Thread foundThread = ThreadUtils.findThreadById(thread.getId(), threadGroup2);
        assertNull("Thread should not be found in a different group", foundThread);
    }

    @Test(timeout = 4000)
    public void testFindThreadById_NullThreadGroup() {
        // Create a valid thread group
        ThreadGroup threadGroup = new ThreadGroup("TestGroup");
        
        // Create a thread and start it
        Thread thread = new Thread(threadGroup, () -> {
            // Thread logic here
        }, "TestThread");
        thread.start();
        
        // Ensure the thread is alive before testing
        try {
            Thread.sleep(100); // Wait for the thread to start
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Test the focal method with a null thread group
        try {
            ThreadUtils.findThreadById(thread.getId(), (ThreadGroup) null);
            fail("Expected NullPointerException for null thread group");
        } catch (NullPointerException e) {
            // Expected exception
        }
    }


}