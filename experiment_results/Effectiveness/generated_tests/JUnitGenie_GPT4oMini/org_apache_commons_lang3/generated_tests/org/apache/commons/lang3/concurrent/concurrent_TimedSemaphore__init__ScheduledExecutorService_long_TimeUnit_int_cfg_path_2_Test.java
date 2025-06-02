package org.apache.commons.lang3.concurrent;
import org.apache.commons.lang3.concurrent.TimedSemaphore;
import org.junit.Test;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.*;

public class concurrent_TimedSemaphore__init__ScheduledExecutorService_long_TimeUnit_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithValidParameters() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 1000L; // valid time period
        TimeUnit timeUnit = TimeUnit.MILLISECONDS; // valid time unit
        int limit = 5; // valid limit

        try {
            TimedSemaphore semaphore = new TimedSemaphore(service, timePeriod, timeUnit, limit);
            assertNotNull(semaphore);
        } catch (Exception e) {
            fail("Exception should not have been thrown for valid parameters: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithNullService() {
        ScheduledExecutorService service = null;
        long timePeriod = 1000L; // valid time period
        TimeUnit timeUnit = TimeUnit.MILLISECONDS; // valid time unit
        int limit = 5; // valid limit

        try {
            TimedSemaphore semaphore = new TimedSemaphore(service, timePeriod, timeUnit, limit);
            assertNotNull(semaphore);
        } catch (Exception e) {
            fail("Exception should not have been thrown for null service: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithInvalidTimePeriod() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 0L; // invalid time period
        TimeUnit timeUnit = TimeUnit.MILLISECONDS; // valid time unit
        int limit = 5; // valid limit

        try {
            new TimedSemaphore(service, timePeriod, timeUnit, limit);
            fail("Exception should have been thrown for invalid time period");
        } catch (IllegalArgumentException e) {
            assertEquals("Time period must be greater than 0!", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testTimedSemaphoreWithNegativeLimit() {
        ScheduledExecutorService service = new ScheduledThreadPoolExecutor(1);
        long timePeriod = 1000L; // valid time period
        TimeUnit timeUnit = TimeUnit.MILLISECONDS; // valid time unit
        int limit = -1; // invalid limit

        try {
            new TimedSemaphore(service, timePeriod, timeUnit, limit);
            fail("Exception should have been thrown for negative limit");
        } catch (IllegalArgumentException e) {
            // Expected exception
        }
    }

}