package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDate_property_DateTimeFieldType_cfg_path_2_Test {

    private static class UnsupportedDateTimeFieldType extends DateTimeFieldType {
        private static final String NAME = "UnsupportedDateTimeFieldType";

        protected UnsupportedDateTimeFieldType() {
            super(NAME); // Call the constructor with a name
        }

        @Override
        public org.joda.time.DurationFieldType getDurationType() {
            return null; // Implement as needed
        }

        @Override
        public org.joda.time.DurationFieldType getRangeDurationType() {
            return null; // Implement as needed
        }

        @Override
        public org.joda.time.DateTimeField getField(org.joda.time.Chronology chronology) {
            return null; // Implement as needed
        }
    }

    @Test(timeout = 4000)
    public void testPropertyWithNullFieldType() {
        LocalDate localDate = new LocalDate();
        try {
            localDate.property(null);
            fail("Expected IllegalArgumentException for null DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("The DateTimeFieldType must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testPropertyWithUnsupportedFieldType() {
        LocalDate localDate = new LocalDate();
        UnsupportedDateTimeFieldType unsupportedFieldType = new UnsupportedDateTimeFieldType();
        try {
            localDate.property(unsupportedFieldType);
            fail("Expected IllegalArgumentException for unsupported DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("Field 'UnsupportedDateTimeFieldType' is not supported", e.getMessage());
        } catch (NullPointerException e) {
            fail("Unexpected NullPointerException: " + e.getMessage());
        }
    }

}