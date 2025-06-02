package org.joda.time.chrono;
import org.joda.time.chrono.GJLocaleSymbols;
import org.joda.time.DateTimeUtils;
import org.junit.Test;
import java.util.Locale;
import static org.junit.Assert.assertNotNull;

public class chrono_GJLocaleSymbols__init__Locale_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGJLocaleSymbolsConstructor() {
        // Create a valid Locale instance
        Locale locale = Locale.US;

        // Use the public static method to get an instance of GJLocaleSymbols
        GJLocaleSymbols gjLocaleSymbols = GJLocaleSymbols.forLocale(locale);

        // Validate that the instance is created successfully
        assertNotNull(gjLocaleSymbols);
    }


}