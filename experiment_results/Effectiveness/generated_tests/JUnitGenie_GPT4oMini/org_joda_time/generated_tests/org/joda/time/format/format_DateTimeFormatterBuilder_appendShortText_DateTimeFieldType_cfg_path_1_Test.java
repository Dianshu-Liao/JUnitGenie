package org.joda.time.format;
import org.joda.time.format.DateTimeFormatterBuilder;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.DateTimeField;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class format_DateTimeFormatterBuilder_appendShortText_DateTimeFieldType_cfg_path_1_Test {

    private static class TestDateTimeFieldType extends DateTimeFieldType {
        protected TestDateTimeFieldType(String name) {
            super(name);
        }

        @Override
        public DurationFieldType getDurationType() {
            return null; // Implement as needed for your test
        }

        @Override
        public DurationFieldType getRangeDurationType() {
            return null; // Implement as needed for your test
        }

        @Override
        public DateTimeField getField(Chronology chronology) {
            return null; // Implement as needed for your test
        }
    }

    @Test(timeout = 4000)
    public void testAppendShortText_ValidFieldType() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        TestDateTimeFieldType fieldType = new TestDateTimeFieldType("testField");

        DateTimeFormatterBuilder result = builder.appendShortText(fieldType);
        assertNotNull(result);
    }

    @Test(timeout = 4000)
    public void testAppendShortText_NullFieldType() {
        DateTimeFormatterBuilder builder = new DateTimeFormatterBuilder();
        try {
            builder.appendShortText(null);
            fail("Expected IllegalArgumentException for null field type");
        } catch (IllegalArgumentException e) {
            assertEquals("Field type must not be null", e.getMessage());
        }
    }

}