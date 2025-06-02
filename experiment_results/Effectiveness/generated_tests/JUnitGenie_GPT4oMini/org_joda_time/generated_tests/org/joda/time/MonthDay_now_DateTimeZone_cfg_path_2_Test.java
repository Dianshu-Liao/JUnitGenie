package org.joda.time;
import org.joda.time.MonthDay;
import org.joda.time.DateTimeZone;
import org.junit.Test;

public class MonthDay_now_DateTimeZone_cfg_path_2_Test {

    @Test(expected = NullPointerException.class)
    public void testNowWithNullZone() {
        try {
            MonthDay.now((DateTimeZone) null); // Specify the type explicitly to resolve ambiguity
        } catch (NullPointerException e) {
            // Exception is expected, test passes
            throw e; // rethrow to satisfy the expected exception
        }
    }


}