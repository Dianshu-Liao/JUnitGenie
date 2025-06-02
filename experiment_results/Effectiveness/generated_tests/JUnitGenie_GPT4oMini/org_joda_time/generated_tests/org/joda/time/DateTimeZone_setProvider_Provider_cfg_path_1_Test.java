package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.Provider;
import org.junit.Test;
import static org.junit.Assert.*;

public class DateTimeZone_setProvider_Provider_cfg_path_1_Test {

    // Concrete implementation of the Provider interface for testing
    static class TestProvider implements Provider {
        @Override
        public DateTimeZone getZone(String id) {
            return DateTimeZone.forID(id);
        }

        @Override
        public java.util.Set<String> getAvailableIDs() {
            return java.util.Collections.singleton("UTC");
        }
    }

    @Test(timeout = 4000)
    public void testSetProviderWithValidProvider() {
        try {
            Provider testProvider = new TestProvider();
            DateTimeZone.setProvider(testProvider);
            // Verify that the provider has been set correctly
            assertEquals(testProvider, DateTimeZone.getProvider());
        } catch (SecurityException e) {
            fail("SecurityException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testSetProviderWithNullProvider() {
        try {
            DateTimeZone.setProvider(null);
            // Verify that the default provider is set
            assertNotNull(DateTimeZone.getProvider());
        } catch (SecurityException e) {
            fail("SecurityException should not have been thrown");
        }
    }

    @Test(timeout = 4000)
    public void testSetProviderWithSecurityException() {
        try {
            // Attempt to set a provider without a security manager
            System.setSecurityManager(null);
            DateTimeZone.setProvider(new TestProvider());
            fail("Expected SecurityException was not thrown");
        } catch (SecurityException e) {
            // Expected exception
        } finally {
            // Restore the security manager if needed
            // Check if a security manager is already set before restoring
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }
        }
    }

}