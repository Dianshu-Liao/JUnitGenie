package org.joda.time;
import org.joda.time.Seconds;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Seconds_seconds_int_cfg_path_5_Test {

    @Test(timeout = 4000)
    public void testSecondsZero() {
        Seconds result = Seconds.seconds(0);
        assertEquals(Seconds.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testSecondsOne() {
        Seconds result = Seconds.seconds(1);
        assertEquals(Seconds.ONE, result);
    }

    @Test(timeout = 4000)
    public void testSecondsTwo() {
        Seconds result = Seconds.seconds(2);
        assertEquals(Seconds.TWO, result);
    }

    @Test(timeout = 4000)
    public void testSecondsThree() {
        Seconds result = Seconds.seconds(3);
        assertEquals(Seconds.THREE, result);
    }

    @Test(timeout = 4000)
    public void testSecondsMaxValue() {
        Seconds result = Seconds.seconds(Integer.MAX_VALUE);
        assertEquals(Seconds.seconds(Integer.MAX_VALUE), result);
    }

    @Test(timeout = 4000)
    public void testSecondsMinValue() {
        Seconds result = Seconds.seconds(Integer.MIN_VALUE);
        assertEquals(Seconds.seconds(Integer.MIN_VALUE), result);
    }

    @Test(timeout = 4000)
    public void testSecondsDefault() {
        int testValue = 5; // A value that does not match any case
        Seconds result = Seconds.seconds(testValue);
        assertEquals(Seconds.seconds(testValue), result);
    }


}