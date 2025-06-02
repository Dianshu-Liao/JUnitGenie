package org.joda.time.tz;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.UTCProvider;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class tz_UTCProvider_getZone_String_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testGetZoneWithUTC() {
        UTCProvider provider = new UTCProvider();
        DateTimeZone result = provider.getZone("UTC");
        assertEquals(DateTimeZone.UTC, result);
    }

    @Test(timeout = 4000)
    public void testGetZoneWithDifferentId() {
        UTCProvider provider = new UTCProvider();
        DateTimeZone result = provider.getZone("GMT");
        assertEquals(null, result);
    }

}