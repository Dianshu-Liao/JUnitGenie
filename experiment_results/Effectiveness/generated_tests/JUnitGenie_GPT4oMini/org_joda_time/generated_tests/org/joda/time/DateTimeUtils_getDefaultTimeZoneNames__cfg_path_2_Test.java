package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.concurrent.atomic.AtomicReference;

public class DateTimeUtils_getDefaultTimeZoneNames__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetDefaultTimeZoneNames() {
        // Prepare the expected result
        Map<String, DateTimeZone> expectedTimeZoneNames = new LinkedHashMap<>();
        expectedTimeZoneNames.put("GMT", DateTimeZone.forID("GMT"));
        expectedTimeZoneNames.put("UTC", DateTimeZone.forID("UTC"));
        expectedTimeZoneNames.put("CDT", DateTimeZone.forID("America/Chicago"));
        expectedTimeZoneNames.put("EDT", DateTimeZone.forID("America/New_York"));
        
        // Clear the AtomicReference to simulate the scenario where it is null
        try {
            // Use reflection to access the private static field cZoneNames
            java.lang.reflect.Field field = DateTimeUtils.class.getDeclaredField("cZoneNames");
            field.setAccessible(true);
            AtomicReference<Map<String, DateTimeZone>> cZoneNames = (AtomicReference<Map<String, DateTimeZone>>) field.get(null);
            cZoneNames.set(null); // Set to null to trigger the buildDefaultTimeZoneNames call

            // Call the method under test
            Map<String, DateTimeZone> actualTimeZoneNames = DateTimeUtils.getDefaultTimeZoneNames();

            // Validate the result
            assertNotNull("The returned map should not be null", actualTimeZoneNames);
            assertEquals("The returned map should contain the expected time zone names", expectedTimeZoneNames, actualTimeZoneNames);
        } catch (Exception e) {
            fail("An exception occurred: " + e.getMessage());
        }
    }

}