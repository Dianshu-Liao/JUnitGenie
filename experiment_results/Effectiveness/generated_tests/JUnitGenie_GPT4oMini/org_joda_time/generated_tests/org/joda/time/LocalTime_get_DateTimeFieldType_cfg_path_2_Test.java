package org.joda.time;
import org.joda.time.LocalTime;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalTime_get_DateTimeFieldType_cfg_path_2_Test {

    private class UnsupportedDateTimeFieldType extends DateTimeFieldType {
        private static final String NAME = "Unsupported";

        protected UnsupportedDateTimeFieldType() {
            super(NAME); // Call the constructor with a name
        }

        @Override
        public org.joda.time.DurationFieldType getDurationType() {
            return null; // Implement as needed for your test
        }

        @Override
        public org.joda.time.DurationFieldType getRangeDurationType() {
            return null; // Implement as needed for your test
        }

        @Override
        public org.joda.time.DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Implement as needed for your test
        }
    }

    @Test(timeout = 4000)
    public void testGetWithNullFieldType() {
        LocalTime localTime = new LocalTime();
        try {
            localTime.get(null);
            fail("Expected IllegalArgumentException for null DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("The DateTimeFieldType must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetWithUnsupportedFieldType() {
        LocalTime localTime = new LocalTime();
        DateTimeFieldType unsupportedFieldType = new UnsupportedDateTimeFieldType();
        try {
            localTime.get(unsupportedFieldType);
            fail("Expected IllegalArgumentException for unsupported DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("Field '" + unsupportedFieldType + "' is not supported", e.getMessage());
        }
    }


}