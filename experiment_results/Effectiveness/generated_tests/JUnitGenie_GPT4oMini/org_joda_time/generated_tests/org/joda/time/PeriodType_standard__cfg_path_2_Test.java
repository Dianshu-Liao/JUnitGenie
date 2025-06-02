package org.joda.time;
import org.joda.time.PeriodType;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class PeriodType_standard__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testStandardMethodReturnsNonNull() {
        // Accessing the private static variable cStandard using reflection
        try {
            java.lang.reflect.Field field = PeriodType.class.getDeclaredField("cStandard");
            field.setAccessible(true);
            PeriodType cStandardValue = (PeriodType) field.get(null);

            // Call the standard method
            PeriodType result = PeriodType.standard();

            // Assert that the result is not null
            assertNotNull("The standard method should return a non-null PeriodType", result);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}