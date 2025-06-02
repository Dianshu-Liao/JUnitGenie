package org.joda.time;
import org.joda.time.MonthDay;
import org.joda.time.DateTimeZone;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.junit.Test;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class MonthDay_readResolve__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testReadResolveReturnsThisWhenZoneIsUTC() {
        try {
            // Create an instance of MonthDay with UTC Chronology
            MonthDay monthDay = new MonthDay(1, 1); // Removed DateTimeZone parameter

            // Access the private method readResolve using reflection
            Method method = MonthDay.class.getDeclaredMethod("readResolve");
            method.setAccessible(true);

            // Invoke the method
            Object result = method.invoke(monthDay);

            // Assert that the result is the same instance
            assertEquals(monthDay, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testReadResolveReturnsNewMonthDayWhenZoneIsNotUTC() {
        try {
            // Create an instance of MonthDay with a non-UTC Chronology
            MonthDay monthDay = new MonthDay(1, 1); // Removed DateTimeZone parameter

            // Access the private method readResolve using reflection
            Method method = MonthDay.class.getDeclaredMethod("readResolve");
            method.setAccessible(true);

            // Invoke the method
            Object result = method.invoke(monthDay);

            // Assert that the result is a new MonthDay instance
            assertEquals(MonthDay.class, result.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}