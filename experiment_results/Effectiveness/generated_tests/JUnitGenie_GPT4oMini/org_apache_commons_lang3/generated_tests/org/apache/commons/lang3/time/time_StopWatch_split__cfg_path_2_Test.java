package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.StopWatch;
import org.junit.Test;

public class time_StopWatch_split__cfg_path_2_Test {

    @Test(expected = IllegalStateException.class)
    public void testSplitWhenNotRunning() {
        StopWatch stopWatch = new StopWatch();
        // Ensure the stopwatch is not running
        stopWatch.split(); // This should throw IllegalStateException
    }

}