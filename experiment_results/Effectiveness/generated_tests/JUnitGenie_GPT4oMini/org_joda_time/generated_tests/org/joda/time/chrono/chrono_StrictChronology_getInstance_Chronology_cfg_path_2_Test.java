package org.joda.time.chrono;
import org.joda.time.chrono.StrictChronology;
import org.joda.time.Chronology;
import org.junit.Test;

public class chrono_StrictChronology_getInstance_Chronology_cfg_path_2_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testGetInstanceWithNullChronology() {
        // Test case to cover the scenario where the base parameter is null
        StrictChronology.getInstance(null);
    }

}