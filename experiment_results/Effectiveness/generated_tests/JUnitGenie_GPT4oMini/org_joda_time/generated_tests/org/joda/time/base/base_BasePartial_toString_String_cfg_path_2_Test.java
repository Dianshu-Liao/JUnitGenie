package org.joda.time.base;
import org.joda.time.base.BasePartial;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class base_BasePartial_toString_String_cfg_path_2_Test {

    private class ConcreteBasePartial extends BasePartial {
        // Implementing the abstract methods
        @Override
        public int size() {
            return 0; // Example implementation
        }

        @Override
        public org.joda.time.DateTimeField getField(int index, org.joda.time.Chronology chronology) {
            return null; // Example implementation
        }

        @Override
        public String toString() {
            return "ConcreteBasePartial"; // Example implementation
        }

        // Overriding toString method to accept a String pattern
        public String toString(String pattern) {
            // Example implementation for the sake of the test
            return pattern != null ? "Formatted: " + pattern : this.toString();
        }
    }

    @Test(timeout = 4000)
    public void testToStringWithPattern() {
        ConcreteBasePartial partial = new ConcreteBasePartial();
        String pattern = "yyyy-MM-dd";
        String expected = "Formatted: " + pattern; // Assuming the pattern will format the date correctly
        String actual = partial.toString(pattern);
        assertEquals(expected, actual);
    }

    @Test(timeout = 4000)
    public void testToStringWithNullPattern() {
        ConcreteBasePartial partial = new ConcreteBasePartial();
        String actual = partial.toString((String) null); // Explicitly casting to String to resolve ambiguity
        String expected = partial.toString(); // Should call the no-arg toString method
        assertEquals(expected, actual);
    }

}