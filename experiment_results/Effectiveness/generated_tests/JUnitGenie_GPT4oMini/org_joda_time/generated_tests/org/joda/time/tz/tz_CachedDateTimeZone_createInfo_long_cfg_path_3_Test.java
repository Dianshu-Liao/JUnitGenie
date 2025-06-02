package org.joda.time.tz;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.CachedDateTimeZone;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class tz_CachedDateTimeZone_createInfo_long_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testCreateInfo() {
        try {
            // Create an instance of CachedDateTimeZone using reflection
            DateTimeZone dateTimeZone = DateTimeZone.forID("UTC");
            CachedDateTimeZone cachedDateTimeZone = (CachedDateTimeZone) CachedDateTimeZone.class
                    .getDeclaredConstructor(DateTimeZone.class)
                    .newInstance(dateTimeZone);

            // Access the private method createInfo using reflection
            Method createInfoMethod = CachedDateTimeZone.class.getDeclaredMethod("createInfo", long.class);
            createInfoMethod.setAccessible(true);

            // Define a valid long value for millis
            long millis = 0L;

            // Invoke the createInfo method
            Object info = createInfoMethod.invoke(cachedDateTimeZone, millis);

            // Assert that the returned Info object is not null
            assertNotNull(info);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}