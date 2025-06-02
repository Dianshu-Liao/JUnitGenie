package org.joda.time.tz;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.UTCProvider;
import org.junit.Test;
import static org.junit.Assert.assertNull;

public class tz_UTCProvider_getZone_String_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testGetZoneReturnsNullForNonUTC() {
        UTCProvider utcProvider = new UTCProvider();
        String nonUTCId = "GMT";
        
        DateTimeZone result = utcProvider.getZone(nonUTCId);
        
        assertNull(result);
    }

}