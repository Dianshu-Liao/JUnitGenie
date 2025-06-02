package org.joda.time;
import org.joda.time.Years;
import org.joda.time.ReadablePartial;
import org.joda.time.base.BaseSingleFieldPeriod;
import org.joda.time.LocalDate;
import org.joda.time.Chronology;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.*;

public class Years_yearsBetween_ReadablePartial_ReadablePartial_cfg_path_1_Test {

    private static class TestReadablePartial implements ReadablePartial, Comparable<ReadablePartial> {
        private final LocalDate date;

        public TestReadablePartial(LocalDate date) {
            this.date = date;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof TestReadablePartial)) return false;
            TestReadablePartial other = (TestReadablePartial) obj;
            return date.equals(other.date);
        }

        @Override
        public int size() {
            return 1; // Simplified for this test
        }

        @Override
        public org.joda.time.DateTimeField getField(int index) {
            return date.getField(index);
        }

        @Override
        public org.joda.time.DateTime toDateTime(org.joda.time.ReadableInstant instant) {
            return date.toDateTime(instant);
        }

        @Override
        public boolean isSupported(org.joda.time.DateTimeFieldType fieldType) {
            return date.isSupported(fieldType);
        }

        @Override
        public int get(org.joda.time.DateTimeFieldType fieldType) {
            return date.get(fieldType);
        }

        @Override
        public org.joda.time.Chronology getChronology() {
            return date.getChronology();
        }

        @Override
        public int getValue(int index) {
            return date.getValue(index);
        }

        @Override
        public String toString() {
            return date.toString();
        }

        @Override
        public org.joda.time.DateTimeFieldType getFieldType(int index) {
            return date.getFieldType(index);
        }

        @Override
        public int hashCode() {
            return date.hashCode();
        }

        @Override
        public int compareTo(ReadablePartial other) {
            if (other instanceof TestReadablePartial) {
                return date.compareTo(((TestReadablePartial) other).date);
            }
            return 0; // or throw an exception if you want to enforce type safety
        }
    }

    @Test(timeout = 4000)
    public void testYearsBetweenWithLocalDate() {
        LocalDate start = new LocalDate(2020, 1, 1);
        LocalDate end = new LocalDate(2021, 1, 1);
        Years result = Years.yearsBetween(start, end);
        assertEquals(Years.years(1), result);
    }

    @Test(timeout = 4000)
    public void testYearsBetweenWithReadablePartial() {
        TestReadablePartial start = new TestReadablePartial(new LocalDate(2019, 1, 1));
        TestReadablePartial end = new TestReadablePartial(new LocalDate(2020, 1, 1));
        Years result = Years.yearsBetween(start, end);
        assertEquals(Years.years(1), result);
    }

    @Test(timeout = 4000)
    public void testYearsBetweenWithZero() {
        TestReadablePartial start = new TestReadablePartial(new LocalDate(2020, 1, 1));
        TestReadablePartial end = new TestReadablePartial(new LocalDate(2020, 1, 1));
        Years result = Years.yearsBetween(start, end);
        assertEquals(Years.ZERO, result);
    }

    @Test(timeout = 4000)
    public void testYearsBetweenWithNegativeYears() {
        TestReadablePartial start = new TestReadablePartial(new LocalDate(2021, 1, 1));
        TestReadablePartial end = new TestReadablePartial(new LocalDate(2020, 1, 1));
        Years result = Years.yearsBetween(start, end);
        assertEquals(Years.years(-1), result);
    }


}