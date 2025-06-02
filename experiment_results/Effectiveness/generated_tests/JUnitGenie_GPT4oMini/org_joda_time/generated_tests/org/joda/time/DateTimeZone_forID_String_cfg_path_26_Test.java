package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Set;
import java.util.HashSet;

public class DateTimeZone_forID_String_cfg_path_26_Test {

    @Test(timeout = 4000)
    public void testForID_UTC() {
        DateTimeZone zone = DateTimeZone.forID("UTC");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_UT() {
        DateTimeZone zone = DateTimeZone.forID("UT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_GMT() {
        DateTimeZone zone = DateTimeZone.forID("GMT");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_Z() {
        DateTimeZone zone = DateTimeZone.forID("Z");
        assertEquals(DateTimeZone.UTC, zone);
    }

    @Test(timeout = 4000)
    public void testForID_Null() {
        DateTimeZone zone = DateTimeZone.forID(null);
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForID_Recognized() {
        Provider provider = new CustomProvider(); // Use the CustomProvider class

        DateTimeZone zone = provider.getZone("CustomZone");
        assertNotNull(zone);
    }

    @Test(timeout = 4000)
    public void testForID_Invalid() {
        try {
            DateTimeZone.forID("InvalidZoneId");
            fail("Expected IllegalArgumentException not thrown.");
        } catch (IllegalArgumentException e) {
            assertEquals("The datetime zone id 'InvalidZoneId' is not recognised", e.getMessage());
        }
    }

    // Implementing the Provider interface correctly
    public static class CustomProvider implements Provider {
        @Override
        public DateTimeZone getZone(String id) {
            return id.equals("CustomZone") ? DateTimeZone.forID("UTC") : null; // Simulated behavior
        }


        @Override
        public Set<String> getAvailableIDs() {
            Set<String> availableIDs = new HashSet<>();
            availableIDs.add("CustomZone");
            availableIDs.add("UTC");
            availableIDs.add("UT");
            availableIDs.add("GMT");
            availableIDs.add("Z");
            return availableIDs;
        }
    }

}
