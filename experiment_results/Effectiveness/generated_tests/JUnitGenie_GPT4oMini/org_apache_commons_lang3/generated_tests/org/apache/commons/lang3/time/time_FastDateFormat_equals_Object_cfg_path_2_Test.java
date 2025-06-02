package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDateFormat;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class time_FastDateFormat_equals_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testEqualsWithNonFastDateFormatObject() {
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", null, null);
        Object nonFastDateFormatObject = new Object(); // Non-FastDateFormat object

        // Testing the equals method with a non-FastDateFormat object
        try {
            assertFalse(fastDateFormat.equals(nonFastDateFormatObject));
        } catch (Exception e) {
            // Handle the exception if necessary
            e.printStackTrace();
        }
    }

}