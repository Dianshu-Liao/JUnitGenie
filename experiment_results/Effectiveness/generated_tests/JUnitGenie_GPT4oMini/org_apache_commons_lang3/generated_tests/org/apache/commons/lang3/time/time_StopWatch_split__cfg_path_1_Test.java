package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import static org.junit.Assert.*;

public class time_StopWatch_split__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testSplitWhenRunning() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(); // Set the running state to RUNNING

        // Call the split method
        try {
            stopWatch.split();
            // Verify that the split state is set correctly
            // Since SplitState is private, we cannot access it directly.
            // Instead, we can check if the split is active by using the getSplitTime() method.
            assertTrue(stopWatch.getSplitTime() > 0);
            // Verify that the stop time is updated
            assertTrue(stopWatch.getTime() > 0);
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSplitWhenNotRunning() {
        StopWatch stopWatch = new StopWatch();
        
        // Call the split method and expect an exception
        try {
            stopWatch.split();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stopwatch is not running.", e.getMessage());
        }
    }


}