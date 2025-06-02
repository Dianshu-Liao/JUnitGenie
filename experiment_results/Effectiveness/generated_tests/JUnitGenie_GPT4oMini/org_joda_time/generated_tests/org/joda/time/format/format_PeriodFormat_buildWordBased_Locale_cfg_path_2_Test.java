package org.joda.time.format;
import org.joda.time.format.PeriodFormat;
import org.joda.time.format.PeriodFormatter;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class format_PeriodFormat_buildWordBased_Locale_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testBuildWordBasedWithValidLocale() {
        // Prepare the locale for testing
        Locale locale = Locale.ENGLISH;

        // Directly call the public method instead of using reflection
        PeriodFormatter result = PeriodFormat.wordBased(locale);

        // Assert that the result is not null
        assertNotNull("Expected a non-null PeriodFormatter", result);
    }

}