package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;
import static org.junit.Assert.*;

public class time_StopWatch_getSplitNanoTime__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetSplitNanoTimeThrowsExceptionWhenNotSplit() {
        StopWatch stopWatch = new StopWatch();
        // Ensure the stopwatch is not in SPLIT state
        try {
            stopWatch.getSplitNanoTime();
            fail("Expected IllegalStateException to be thrown");
        } catch (IllegalStateException e) {
            assertEquals("Stopwatch must be split to get the split time.", e.getMessage());
        }
    }

}