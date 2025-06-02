package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertNotNull;

public class concurrent_TimedSemaphore__init__ScheduledExecutorService_long_TimeUnit_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithCustomExecutor() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 1000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 5;

        TimedSemaphore semaphore = new TimedSemaphore(service, timePeriod, timeUnit, limit);
        assertNotNull(semaphore);
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithDefaultExecutor() {
        long timePeriod = 1000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 5;

        TimedSemaphore semaphore = new TimedSemaphore(null, timePeriod, timeUnit, limit);
        assertNotNull(semaphore);
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithInvalidTimePeriod() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 0L; // Invalid time period
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 5;

        try {
            new TimedSemaphore(service, timePeriod, timeUnit, limit);
        } catch (IllegalArgumentException e) {
            // Expected exception for invalid time period
        }
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithValidLimit() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 1000L;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        int limit = 5; // Valid limit

        TimedSemaphore semaphore = new TimedSemaphore(service, timePeriod, timeUnit, limit);
        assertNotNull(semaphore);
    }

}