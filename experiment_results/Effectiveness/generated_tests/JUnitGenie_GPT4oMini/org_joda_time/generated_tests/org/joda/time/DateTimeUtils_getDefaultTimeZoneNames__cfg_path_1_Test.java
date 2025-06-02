package org.joda.time;
import org.joda.time.DateTimeUtils;
import org.joda.time.DateTimeZone;
import org.junit.Test;
import java.util.Map;
import java.util.LinkedHashMap;
import static org.junit.Assert.assertNotNull;

public class DateTimeUtils_getDefaultTimeZoneNames__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetDefaultTimeZoneNames() {
        // Prepare the expected map with valid timezone identifiers
        Map<String, DateTimeZone> expectedTimeZoneNames = new LinkedHashMap<>();
        expectedTimeZoneNames.put("UTC", DateTimeZone.forID("UTC"));
        expectedTimeZoneNames.put("EST", DateTimeZone.forID("America/New_York"));
        expectedTimeZoneNames.put("CST", DateTimeZone.forID("America/Chicago"));
        expectedTimeZoneNames.put("MST", DateTimeZone.forID("America/Denver"));
        expectedTimeZoneNames.put("PST", DateTimeZone.forID("America/Los_Angeles"));

        // Call the method under test
        Map<String, DateTimeZone> actualTimeZoneNames = DateTimeUtils.getDefaultTimeZoneNames();

        // Validate the result
        assertNotNull(actualTimeZoneNames);
        // Additional assertions can be added here to check the contents of actualTimeZoneNames
    }

}