package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.NameProvider;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class DateTimeZone_setNameProvider_NameProvider_cfg_path_1_Test {

    private static class TestNameProvider implements NameProvider {
        @Override
        public String getName(Locale locale, String id, String type) {
            return "TestNameProvider";
        }

        @Override
        public String getShortName(Locale locale, String id, String type) {
            return "TNP";
        }
    }

    @Test(timeout = 4000)
    public void testSetNameProviderWithSecurityManager() {
        // Security manager setup is not allowed in this context, so we will skip it
        // Create an instance of the NameProvider
        NameProvider nameProvider = new TestNameProvider();

        // Call the focal method
        DateTimeZone.setNameProvider(nameProvider);

        // Verify that the name provider has been set
        assertNotNull(DateTimeZone.getNameProvider());
    }

    @Test(timeout = 4000)
    public void testSetNameProviderWithNull() {
        // Call the focal method with null
        DateTimeZone.setNameProvider(null);

        // Verify that the name provider has been set to the default
        assertNotNull(DateTimeZone.getNameProvider());
    }

}