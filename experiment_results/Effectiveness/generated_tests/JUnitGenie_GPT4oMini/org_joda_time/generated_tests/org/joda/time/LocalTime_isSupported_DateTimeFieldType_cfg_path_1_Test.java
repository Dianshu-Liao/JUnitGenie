package org.joda.time;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LocalTime_isSupported_DateTimeFieldType_cfg_path_1_Test {

    private class TestDateTimeFieldType extends DateTimeFieldType {
        private final DurationFieldType durationType;
        private final DurationFieldType rangeDurationType;

        public TestDateTimeFieldType(DurationFieldType durationType, DurationFieldType rangeDurationType) {
            super("TestDateTimeFieldType");
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
        public DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Not needed for this test
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithValidDurationFieldType() {
        LocalTime localTime = new LocalTime();
        DurationFieldType validDurationType = DurationFieldType.minutes(); // Assuming this is a valid type
        DurationFieldType rangeDurationType = DurationFieldType.days(); // This should return true in the final check

        TestDateTimeFieldType testType = new TestDateTimeFieldType(validDurationType, rangeDurationType);
        
        try {
            assertTrue(localTime.isSupported(testType));
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithNullType() {
        LocalTime localTime = new LocalTime();
        
        try {
            assertFalse(localTime.isSupported((DateTimeFieldType) null)); // Cast to resolve ambiguity
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsSupportedWithUnsupportedDurationFieldType() {
        LocalTime localTime = new LocalTime();
        DurationFieldType unsupportedDurationType = DurationFieldType.years(); // Assuming this is not supported
        DurationFieldType rangeDurationType = DurationFieldType.days(); // This should return true in the final check

        TestDateTimeFieldType testType = new TestDateTimeFieldType(unsupportedDurationType, rangeDurationType);
        
        try {
            assertFalse(localTime.isSupported(testType));
        } catch (Exception e) {
            // Handle exception if thrown
            e.printStackTrace();
        }
    }


}