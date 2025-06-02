package org.joda.time;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class DateTime_withZoneRetainFields_DateTimeZone_cfg_path_2_Test {

    private class TestDateTimeZone extends DateTimeZone {
        protected TestDateTimeZone(String id) {
            super(id);
        }

        @Override
        public boolean isFixed() {
            return false;
        }

        @Override
        public String getNameKey(long instant) {
            return "TestZone";
        }

        @Override
        public int getStandardOffset(long instant) {
            return 0;
        }

        @Override
        public long previousTransition(long instant) {
            return instant;
        }

        @Override
        public int getOffset(long instant) {
            return 0;
        }

        @Override
        public long nextTransition(long instant) {
            return instant;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof TestDateTimeZone)) return false;
            TestDateTimeZone other = (TestDateTimeZone) obj;
            return this.getID().equals(other.getID());
        }

        @Override
        public int hashCode() {
            return getID().hashCode();
        }
    }

    @Test(timeout = 4000)
    public void testWithZoneRetainFields() {
        DateTimeZone newZone = new TestDateTimeZone("TestZone");
        DateTime dateTime = new DateTime(2021, 1, 1, 0, 0, newZone);
        
        DateTime result = null;
        try {
            result = dateTime.withZoneRetainFields(newZone);
        } catch (Exception e) {
            // Handle exception if necessary
        }

        assertEquals(dateTime, result);
    }

}