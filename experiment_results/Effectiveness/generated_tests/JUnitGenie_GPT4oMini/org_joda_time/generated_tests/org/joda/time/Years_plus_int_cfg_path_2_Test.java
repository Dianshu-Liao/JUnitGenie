package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertSame;

public class Years_plus_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPlusWithZeroYears() {
        Years years = Years.years(5); // Create an instance of Years
        Years result = years.plus(0); // Call the focal method with 0 years
        assertSame(years, result); // Assert that the result is the same instance
    }

}