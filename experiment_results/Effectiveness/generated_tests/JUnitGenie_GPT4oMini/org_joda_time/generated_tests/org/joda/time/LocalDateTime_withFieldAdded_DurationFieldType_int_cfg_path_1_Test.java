package org.joda.time;
import org.joda.time.LocalDateTime;
import org.joda.time.DurationFieldType;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDateTime_withFieldAdded_DurationFieldType_int_cfg_path_1_Test {

    private static class TestDurationFieldType extends DurationFieldType {
        protected TestDurationFieldType(String name) {
            super(name);
        }

        @Override
        public org.joda.time.DurationField getField(org.joda.time.Chronology chronology) {
            return null; // Implement as needed for your tests
        }
    }

    @Test(timeout = 4000)
    public void testWithFieldAdded_NullFieldType() {
        LocalDateTime localDateTime = new LocalDateTime();
        try {
            localDateTime.withFieldAdded(null, 5);
            fail("Expected IllegalArgumentException for null fieldType");
        } catch (IllegalArgumentException e) {
            assertEquals("Field must not be null", e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testWithFieldAdded_ZeroAmount() {
        LocalDateTime localDateTime = new LocalDateTime();
        LocalDateTime result = localDateTime.withFieldAdded(new TestDurationFieldType("test"), 0);
        assertEquals(localDateTime, result);
    }

}