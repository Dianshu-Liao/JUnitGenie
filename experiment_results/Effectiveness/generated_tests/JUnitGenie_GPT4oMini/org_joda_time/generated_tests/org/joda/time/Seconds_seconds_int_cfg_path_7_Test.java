package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class Seconds_seconds_int_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSecondsWithValidInteger() {
        try {
            // Test with a valid integer value
            Seconds result = Seconds.seconds(5);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithZero() {
        try {
            // Test with zero
            Seconds result = Seconds.seconds(0);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithOne() {
        try {
            // Test with one
            Seconds result = Seconds.seconds(1);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithTwo() {
        try {
            // Test with two
            Seconds result = Seconds.seconds(2);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithThree() {
        try {
            // Test with three
            Seconds result = Seconds.seconds(3);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithMaxValue() {
        try {
            // Test with Integer.MAX_VALUE
            Seconds result = Seconds.seconds(Integer.MAX_VALUE);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithMinValue() {
        try {
            // Test with Integer.MIN_VALUE
            Seconds result = Seconds.seconds(Integer.MIN_VALUE);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testSecondsWithNegativeValue() {
        try {
            // Test with a negative integer value
            Seconds result = Seconds.seconds(-5);
            assertNotNull(result);
        } catch (Exception e) {
            // Handle the exception if it occurs
            e.printStackTrace();
        }
    }

}