package org.joda.time;
import org.joda.time.LocalTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalTime_isSupported_DateTimeFieldType_cfg_path_4_Test {

    private static class TestDateTimeFieldType extends DateTimeFieldType {
        private final DurationFieldType durationType;
        private final DurationFieldType rangeDurationType;

        TestDateTimeFieldType(DurationFieldType durationType, DurationFieldType rangeDurationType) {
            super("TestDateTimeFieldType"); // using reflection a protected constructor
            this.durationType = durationType;
            this.rangeDurationType = rangeDurationType;
        }

        @Override
        public DurationFieldType getDurationType() {
            return durationType;
        }

        @Override
        public DurationFieldType getRangeDurationType() {
            return rangeDurationType;
        }

        @Override
        public org.joda.time.DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedValidType() {
        LocalTime localTime = new LocalTime();
        DurationFieldType durationType = DurationFieldType.minutes(); // Valid DurationFieldType
        DurationFieldType rangeDurationType = DurationFieldType.days(); // Valid range type
        TestDateTimeFieldType type = new TestDateTimeFieldType(durationType, rangeDurationType);
        
        boolean result = localTime.isSupported(type);
        assertTrue(result);
    }

    @Test(timeout = 4000)
    public void testIsSupportedNullType() {
        LocalTime localTime = new LocalTime();
        
        try {
            // Explicitly cast to DateTimeFieldType to resolve ambiguity
            boolean result = localTime.isSupported((DateTimeFieldType) null);
            assertFalse(result);
        } catch (Exception e) {
            // Handle possible exceptions here
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedUnsupportedDurationType() {
        LocalTime localTime = new LocalTime();
        DurationFieldType durationType = DurationFieldType.weeks(); // Invalid DurationFieldType
        DurationFieldType rangeDurationType = DurationFieldType.days(); // Valid range type
        TestDateTimeFieldType type = new TestDateTimeFieldType(durationType, rangeDurationType);
        
        boolean result = localTime.isSupported(type);
        assertFalse(result);
    }


}