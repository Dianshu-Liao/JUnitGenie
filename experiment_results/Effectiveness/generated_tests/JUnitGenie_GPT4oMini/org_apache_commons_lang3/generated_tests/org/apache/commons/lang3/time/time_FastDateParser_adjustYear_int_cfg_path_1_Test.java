package org.apache.commons.lang3.time;
import org.apache.commons.lang3.time.FastDateParser;
import java.lang.reflect.Method;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class time_FastDateParser_adjustYear_int_cfg_path_1_Test {

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

            // Test case where twoDigitYear is greater than or equal to startYear
            int twoDigitYear1 = startYear - century; // This should return century + twoDigitYear1
            int expected1 = century + twoDigitYear1;
            Method adjustYearMethod = FastDateParser.class.getDeclaredMethod("adjustYear", int.class);
            adjustYearMethod.setAccessible(true);
            int result1 = (int) adjustYearMethod.invoke(parser, twoDigitYear1);
            assertEquals(expected1, result1);

            // Test case where twoDigitYear is less than startYear
            int twoDigitYear2 = startYear - century - 1; // This should return century + twoDigitYear2 + 100
            int expected2 = century + twoDigitYear2 + 100;
            int result2 = (int) adjustYearMethod.invoke(parser, twoDigitYear2);
            assertEquals(expected2, result2);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}