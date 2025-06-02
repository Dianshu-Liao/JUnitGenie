package org.joda.time;
import org.joda.time.LocalTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalTime_isSupported_DateTimeFieldType_cfg_path_3_Test {

    private static class TestDateTimeFieldType extends DateTimeFieldType {
        protected TestDateTimeFieldType(String name) {
            super(name);
        }

        @Override
        public DurationFieldType getDurationType() {
            return DurationFieldType.minutes(); // Return a valid DurationFieldType
        }

        @Override
        public DurationFieldType getRangeDurationType() {
            return DurationFieldType.hours(); // Return a valid DurationFieldType
        }

        @Override
        public DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithValidType() {
        LocalTime localTime = new LocalTime();
        TestDateTimeFieldType validType = new TestDateTimeFieldType("TestType");

        try {
            boolean result = localTime.isSupported(validType);
            assertTrue(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for valid DateTimeFieldType");
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithNullType() {
        LocalTime localTime = new LocalTime();

        try {
            // Explicitly cast null to DateTimeFieldType to resolve ambiguity
            boolean result = localTime.isSupported((DateTimeFieldType) null);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for null DateTimeFieldType");
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithUnsupportedDurationType() {
        LocalTime localTime = new LocalTime();
        TestDateTimeFieldType unsupportedType = new TestDateTimeFieldType("UnsupportedType") {
            @Override
            public DurationFieldType getDurationType() {
                return DurationFieldType.seconds(); // Return a DurationFieldType that is not supported
            }
        };

        try {
            boolean result = localTime.isSupported(unsupportedType);
            assertFalse(result);
        } catch (Exception e) {
            fail("Exception should not be thrown for unsupported DurationFieldType");
        }
    }


}