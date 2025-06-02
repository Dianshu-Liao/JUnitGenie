package org.apache.commons.lang3;
import org.apache.commons.lang3.ThreadUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class ThreadUtils_findThreadById_long_ThreadGroup_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testFindThreadById_withNullThreadGroup() {
        try {
            ThreadUtils.findThreadById(0L, (ThreadGroup) null); // Cast to ThreadGroup to resolve ambiguity
            fail("Expected NullPointerException for null threadGroup");
        } catch (NullPointerException e) {
            assertEquals("threadGroup", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testFindThreadById_withValidThreadGroup() {
        ThreadGroup threadGroup = new ThreadGroup("TestGroup");
        Thread thread = new Thread(threadGroup, "TestThread");
        thread.start();

        // Wait for the thread to start
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        Thread foundThread = ThreadUtils.findThreadById(thread.getId(), threadGroup);
        assertNotNull("Thread should be found", foundThread);
        assertEquals("Thread should match the created thread", thread.getName(), foundThread.getName());

        // Clean up
        thread.interrupt();
    }

    @Test(timeout = 4000)
    public void testFindThreadById_withNonMatchingThreadGroup() {
        ThreadGroup threadGroup1 = new ThreadGroup("Group1");
        ThreadGroup threadGroup2 = new ThreadGroup("Group2");
        Thread thread = new Thread(threadGroup1, "TestThread");
        thread.start();

        // Wait for the thread to start
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            // Handle the exception
        }

        Thread foundThread = ThreadUtils.findThreadById(thread.getId(), threadGroup2);
        assertNull("Thread should not be found in a different thread group", foundThread);

        // Clean up
        thread.interrupt();
    }


}