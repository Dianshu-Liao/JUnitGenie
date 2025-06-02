package org.joda.time;
import org.joda.time.LocalDate;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDate_get_DateTimeFieldType_cfg_path_2_Test {

    private static class TestDateTimeFieldType extends DateTimeFieldType {
        protected TestDateTimeFieldType(String name) {
            super(name);
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
        LocalDate localDate = new LocalDate();
        try {
            localDate.get(null);
            fail("Expected IllegalArgumentException for null DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("The DateTimeFieldType must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testGetWithUnsupportedFieldType() {
        LocalDate localDate = new LocalDate();
        TestDateTimeFieldType unsupportedFieldType = new TestDateTimeFieldType("UnsupportedFieldType") {
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
        };

        try {
            localDate.get(unsupportedFieldType);
            fail("Expected IllegalArgumentException for unsupported DateTimeFieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("Field 'UnsupportedFieldType' is not supported", e.getMessage());
        } catch (NullPointerException e) {
            fail("Unexpected NullPointerException: " + e.getMessage());
        }
    }


}