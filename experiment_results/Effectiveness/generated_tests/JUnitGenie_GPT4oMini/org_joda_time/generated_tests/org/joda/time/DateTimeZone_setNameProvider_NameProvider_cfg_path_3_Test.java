package org.joda.time;
import org.joda.time.DateTimeZone;
import org.joda.time.tz.NameProvider;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.concurrent.atomic.AtomicReference;

public class DateTimeZone_setNameProvider_NameProvider_cfg_path_3_Test {

    // Concrete implementation of the NameProvider interface for testing
    static class TestNameProvider implements NameProvider {
        @Override
        public String getName(java.util.Locale locale, String id, String type) {
            return "Test Name";
        }

        @Override
        public String getShortName(java.util.Locale locale, String id, String type) {
            return "Test Short Name";
        }
    }

    @Test(timeout = 4000)
    public void testSetNameProvider() {
        // Arrange
        TestNameProvider testProvider = new TestNameProvider();
        
        // Act
        try {
            DateTimeZone.setNameProvider(testProvider);
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown in this test case.");
        }

        // Ensure that the NameProvider has been set
        // As cNameProvider is private, we'd use reflection to access it. 
        try {
            java.lang.reflect.Field field = DateTimeZone.class.getDeclaredField("cNameProvider");
            field.setAccessible(true);
            AtomicReference<NameProvider> providerReference = (AtomicReference<NameProvider>) field.get(null);
            assertEquals(testProvider, providerReference.get());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed to access cNameProvider: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetDefaultProviderWhenNull() {
        // Act
        try {
            DateTimeZone.setNameProvider(null);
        } catch (SecurityException e) {
            fail("SecurityException should not be thrown in this test case.");
        }

        // As cNameProvider is private, we'd use reflection to check the value
        try {
            java.lang.reflect.Field field = DateTimeZone.class.getDeclaredField("cNameProvider");
            field.setAccessible(true);
            AtomicReference<NameProvider> providerReference = (AtomicReference<NameProvider>) field.get(null);
            assertNotNull("Default provider should not be null", providerReference.get());
        } catch (NoSuchFieldException | IllegalAccessException e) {
            fail("Reflection failed to access cNameProvider: " + e.getMessage());
        }
    }


}