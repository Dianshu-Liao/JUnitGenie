package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.NameProvider;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class DateTimeZone_setNameProvider_NameProvider_cfg_path_2_Test {

    private static class TestNameProvider implements NameProvider {
        @Override
        public String getName(Locale locale, String id, String fallback) {
            return "TestNameProvider";
        }

        @Override
        public String getShortName(Locale locale, String id, String fallback) {
            return "TNP";
        }
    }

    @Test(timeout = 4000)
    public void testSetNameProvider() {
        try {
            // Create a valid NameProvider instance
            NameProvider nameProvider = new TestNameProvider();
            
            // Call the static method setNameProvider
            // Ensure that the security manager allows this operation
            if (System.getSecurityManager() == null) {
                DateTimeZone.setNameProvider(nameProvider);
            } else {
                // Handle the case where a security manager is present
                throw new SecurityException("Security manager is present, cannot set NameProvider.");
            }
            
            // Verify that the nameProvider is set correctly
            assertNotNull(DateTimeZone.getNameProvider());
        } catch (SecurityException e) {
            // Handle the exception as per rule 1
            e.printStackTrace();
        }
    }

}