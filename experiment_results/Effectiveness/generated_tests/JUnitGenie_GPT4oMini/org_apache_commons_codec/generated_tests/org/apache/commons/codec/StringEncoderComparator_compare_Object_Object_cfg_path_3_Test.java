package org.apache.commons.codec;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.StringEncoder;
import org.apache.commons.codec.StringEncoderComparator;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StringEncoderComparator_compare_Object_Object_cfg_path_3_Test {

    private final StringEncoder stringEncoder = new StringEncoder() {
        @Override
        public String encode(String source) throws EncoderException {
            // Mock implementation for testing
            if (source != null) {
                return source; // Return the string itself for comparison
            }
            throw new EncoderException("Invalid input");
        }

        @Override
        public String encode(Object source) throws EncoderException {
            // Implementing the required method for the interface
            if (source instanceof String) {
                return encode((String) source);
            }
            throw new EncoderException("Invalid input type");
        }
    };

    private final StringEncoderComparator comparator = new StringEncoderComparator(stringEncoder);

    @Test(timeout = 4000)
    public void testCompareValidInputs() {
        Object o1 = "test";
        Object o2 = "test";
        int result = comparator.compare(o1, o2);
        assertEquals(0, result); // Expecting 0 for equal strings
    }

    @Test(timeout = 4000)
    public void testCompareDifferentInputs() {
        Object o1 = "apple";
        Object o2 = "banana";
        int result = comparator.compare(o1, o2);
        assertEquals(-1, result); // Expecting -1 for "apple" < "banana"
    }

    @Test(timeout = 4000)
    public void testCompareWithInvalidInput() {
        Object o1 = new Object(); // Invalid input to trigger EncoderException
        Object o2 = "test";
        int result = 0;
        try {
            result = comparator.compare(o1, o2);
        } catch (ClassCastException e) {
            result = -1; // Set result to -1 to indicate an error occurred
        }
        assertEquals(-1, result); // Expecting -1 due to invalid input
    }

}