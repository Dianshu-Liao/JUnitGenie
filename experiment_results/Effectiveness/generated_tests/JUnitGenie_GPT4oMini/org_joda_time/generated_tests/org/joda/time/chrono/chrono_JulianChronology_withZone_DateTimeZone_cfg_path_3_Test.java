package org.joda.time.chrono;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.JulianChronology;
import org.joda.time.Chronology;
import org.junit.Test;
import static org.junit.Assert.*;

public class chrono_JulianChronology_withZone_DateTimeZone_cfg_path_3_Test {

    private static class TestDateTimeZone extends DateTimeZone {
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
            return getID().equals(((TestDateTimeZone) obj).getID());
        }

        @Override
        public int hashCode() {
            return getID().hashCode();
        }
    }

    @Test(timeout = 4000)
    public void testWithZone_ValidZone() {
        JulianChronology chronology = JulianChronology.getInstance(); // Changed to get an instance
        DateTimeZone testZone = new TestDateTimeZone("TestZone");
        
        // Ensure the zone is different from the current zone
        assertNotEquals(testZone, chronology.getZone());
        
        // Call the method under test
        Chronology result = chronology.withZone(testZone);
        
        // Verify the result is not null and is an instance of Chronology
        assertNotNull(result);
        assertTrue(result instanceof Chronology);
    }

    @Test(timeout = 4000)
    public void testWithZone_NullZone() {
        JulianChronology chronology = JulianChronology.getInstance(); // Changed to get an instance
        
        // Call the method under test with null
        Chronology result = chronology.withZone(null);
        
        // Verify the result is not null and is the same instance
        assertNotNull(result);
        assertSame(result, chronology);
    }


}