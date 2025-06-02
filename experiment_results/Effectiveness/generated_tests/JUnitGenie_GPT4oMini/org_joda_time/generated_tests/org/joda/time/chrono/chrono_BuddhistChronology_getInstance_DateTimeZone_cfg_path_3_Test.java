package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.BuddhistChronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_BuddhistChronology_getInstance_DateTimeZone_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testGetInstanceWithNonNullZone() {
        // Create a concrete implementation of DateTimeZone
        DateTimeZone zone = new DateTimeZone("UTC") {
            @Override
            public boolean isFixed() {
                return true;
            }

            @Override
            public boolean equals(Object obj) {
                return obj instanceof DateTimeZone && ((DateTimeZone) obj).getID().equals(this.getID());
            }

            @Override
            public String getNameKey(long instant) {
                return "UTC";
            }

            @Override
            public int getStandardOffset(long instant) {
                return 0;
            }

            @Override
            public long previousTransition(long instant) {
                return instant;
            }

            @Override
            public int getOffset(long instant) {
                return 0;
            }

            @Override
            public long nextTransition(long instant) {
                return instant;
            }
        };

        // Call the focal method
        BuddhistChronology chrono = BuddhistChronology.getInstance(zone);
        
        // Verify the result is not null
        assertNotNull(chrono);
    }

}