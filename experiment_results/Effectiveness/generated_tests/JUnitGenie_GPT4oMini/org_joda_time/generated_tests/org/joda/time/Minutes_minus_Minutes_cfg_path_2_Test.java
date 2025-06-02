package org.joda.time;
import org.joda.time.Minutes;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Minutes_minus_Minutes_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testMinusWithNull() {
        Minutes minutes = Minutes.minutes(5); // Use the static factory method instead of the constructor
        Minutes result = minutes.minus(null);
        assertEquals(minutes, result);
    }


}