package org.joda.time;
import org.joda.time.Years;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Years_years_int_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testYearsMethodWithTwo() {
        // Given
        int inputYears = 2;

        // When
        Years result = Years.years(inputYears);

        // Then
        assertEquals(Years.TWO, result);
    }

}