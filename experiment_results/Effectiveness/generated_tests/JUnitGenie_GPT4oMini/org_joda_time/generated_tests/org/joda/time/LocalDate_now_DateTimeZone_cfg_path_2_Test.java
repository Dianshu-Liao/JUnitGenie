package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.junit.Test;

public class LocalDate_now_DateTimeZone_cfg_path_2_Test {

    @Test(expected = NullPointerException.class)
    public void testNowWithNullZone() {
        try {
            LocalDate.now((DateTimeZone) null); // Explicitly cast to DateTimeZone to eliminate ambiguity
        } catch (NullPointerException e) {
            // Exception is expected, test passes
            throw e; // rethrow to satisfy the expected exception
        }
    }


}