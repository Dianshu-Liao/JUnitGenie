package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDateParser;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class time_FastDateParser_adjustYear_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAdjustYear() {
        try {
            // Create an instance of FastDateParser using reflection
            FastDateParser parser = (FastDateParser) FastDateParser.class.getDeclaredConstructor(String.class, java.util.TimeZone.class, java.util.Locale.class)
                    .newInstance("yyyy-MM-dd", java.util.TimeZone.getDefault(), java.util.Locale.getDefault());

            // Access the private fields 'century' and 'startYear' using reflection
            java.lang.reflect.Field centuryField = FastDateParser.class.getDeclaredField("century");
            centuryField.setAccessible(true);
            int century = (int) centuryField.get(parser);

            java.lang.reflect.Field startYearField = FastDateParser.class.getDeclaredField("startYear");
            startYearField.setAccessible(true);
            int startYear = (int) startYearField.get(parser);

            // Test case where twoDigitYear is less than startYear
            int twoDigitYear = startYear - 1; // This should trigger the trial + 100 path
            Method adjustYearMethod = FastDateParser.class.getDeclaredMethod("adjustYear", int.class);
            adjustYearMethod.setAccessible(true);
            int result = (int) adjustYearMethod.invoke(parser, twoDigitYear);
            assertEquals(century + twoDigitYear + 100, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}