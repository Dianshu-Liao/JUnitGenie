package org.joda.time;
import org.joda.time.LocalTime;
import org.joda.time.ReadablePartial;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class LocalTime_compareTo_ReadablePartial_cfg_path_1_Test {

    private class TestReadablePartial implements ReadablePartial, Comparable<ReadablePartial> {
        private final LocalTime localTime;

        public TestReadablePartial(int hour, int minute) {
            this.localTime = new LocalTime(hour, minute);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof TestReadablePartial) {
                TestReadablePartial other = (TestReadablePartial) obj;
                return this.localTime.equals(other.localTime);
            }
            return false;
        }

        @Override
        public int size() {
            return 2; // hour and minute
        }

        @Override
        public org.joda.time.DateTimeField getField(int index) {
            return localTime.getField(index);
        }

        @Override
        public org.joda.time.DateTime toDateTime(org.joda.time.ReadableInstant instant) {
            return localTime.toDateTime(instant);
        }

        @Override
        public boolean isSupported(org.joda.time.DateTimeFieldType fieldType) {
            return localTime.isSupported(fieldType);
        }

        @Override
        public int get(org.joda.time.DateTimeFieldType fieldType) {
            return localTime.get(fieldType);
        }

        @Override
        public org.joda.time.Chronology getChronology() {
            return localTime.getChronology();
        }

        @Override
        public int getValue(int index) {
            return localTime.getValue(index);
        }

        @Override
        public String toString() {
            return localTime.toString();
        }

        @Override
        public org.joda.time.DateTimeFieldType getFieldType(int index) {
            return localTime.getFieldType(index);
        }

        @Override
        public int hashCode() {
            return localTime.hashCode();
        }

        @Override
        public int compareTo(ReadablePartial other) {
            if (other instanceof TestReadablePartial) {
                TestReadablePartial otherPartial = (TestReadablePartial) other;
                return this.localTime.compareTo(otherPartial.localTime);
            }
            return 1; // Consider non-TestReadablePartial as greater
        }
    }

    @Test(timeout = 4000)
    public void testCompareTo_SameInstance() {
        LocalTime time = new LocalTime(10, 30);
        assertEquals(0, time.compareTo(time));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentLocalTime() {
        LocalTime time1 = new LocalTime(10, 30);
        LocalTime time2 = new LocalTime(11, 30);
        assertEquals(-1, time1.compareTo(time2));
    }

    @Test(timeout = 4000)
    public void testCompareTo_ReadablePartial() {
        LocalTime time = new LocalTime(10, 30);
        TestReadablePartial partial = new TestReadablePartial(10, 30);
        assertEquals(0, time.compareTo(partial));
    }

    @Test(timeout = 4000)
    public void testCompareTo_NonLocalTime() {
        LocalTime time = new LocalTime(10, 30);
        TestReadablePartial partial = new TestReadablePartial(11, 30);
        assertEquals(-1, time.compareTo(partial));
    }

    @Test(timeout = 4000)
    public void testCompareTo_DifferentFieldTypes() {
        LocalTime time = new LocalTime(10, 30);
        TestReadablePartial partial = new TestReadablePartial(10, 30) {
            @Override
            public org.joda.time.DateTimeFieldType getFieldType(int index) {
                return org.joda.time.DateTimeFieldType.hourOfDay(); // Change field type to hourOfDay
            }
        };
        assertEquals(1, time.compareTo(partial)); // Should be greater since field types differ
    }


}