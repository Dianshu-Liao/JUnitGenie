package org.joda.time;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalTime_isSupported_DateTimeFieldType_cfg_path_2_Test {

    private class TestDateTimeFieldType extends DateTimeFieldType {
        protected TestDateTimeFieldType(String name) {
            super(name); // Call the constructor with a name
        }

        @Override
        public DurationFieldType getDurationType() {
            return DurationFieldType.minutes(); // Example duration type
        }

        @Override
        public DurationFieldType getRangeDurationType() {
            return DurationFieldType.days(); // Example range duration type
        }

        @Override
        public org.joda.time.DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testIsSupported() {
        LocalTime localTime = new LocalTime();
        TestDateTimeFieldType type = new TestDateTimeFieldType("TestType"); // Provide a name for the type

        try {
            boolean result = localTime.isSupported(type);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithNull() {
        LocalTime localTime = new LocalTime();

        try {
            boolean result = localTime.isSupported((DateTimeFieldType) null); // Cast to DateTimeFieldType
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }


}