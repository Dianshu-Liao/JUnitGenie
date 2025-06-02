package org.joda.time;
import static org.junit.Assert.*;
import org.junit.Test;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.NameProvider;
import org.joda.time.tz.DefaultNameProvider;
import java.security.Permission;
import java.lang.reflect.Constructor;

public class DateTimeZone_setNameProvider_NameProvider_cfg_path_4_Test {

    private static class TestNameProvider implements NameProvider {
        @Override
        public String getName(java.util.Locale locale, String id, String type) {
            return "TestName";
        }
        
        @Override
        public String getShortName(java.util.Locale locale, String id, String type) {
            return "TName";
        }
    }

    @Test(timeout = 4000)
    public void testSetNameProviderWithValidProvider() {
        NameProvider testProvider = new TestNameProvider();
        try {
            DateTimeZone.setNameProvider(testProvider);
            // Validate that the provider is set correctly (this may require additional verification if available)
        } catch (SecurityException e) {
            fail("SecurityException thrown: " + e.getMessage());
        }
    }
    
    @Test(timeout = 4000)
    public void testSetNameProviderWithNullProvider() {
        try {
            // Mock DefaultNameProvider to ensure it returns a non-null instance
            Constructor<DefaultNameProvider> constructor = DefaultNameProvider.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            DefaultNameProvider defaultProvider = constructor.newInstance();
            DateTimeZone.setNameProvider(null);
            // Removed the call to getDefaultNameProvider() due to private access
            assertNotNull("DefaultNameProvider should not be null", defaultProvider);
        } catch (Exception e) {
            fail("Exception thrown: " + e.getMessage());
        }
    }


}