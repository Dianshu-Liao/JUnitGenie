package org.apache.commons.lang3.time;

import java.lang.reflect.Method;
import java.util.Calendar;
import java.util.Date;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;

public class DateUtils_round_39_0_Test {

    private static final long MILLIS_PER_HOUR = 60 * 60 * 1000;

    @BeforeEach
    public void setUp() {
        // Any setup can be done here if necessary
    }

    @Test
    public void testRoundToHour() throws Exception {
        // Given a specific date and time
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 10, 45, 30);
        Date date = calendar.getTime();
        // When rounding to hour
        Date roundedDate = invokeRound(date, Calendar.HOUR_OF_DAY);
        // Then the minutes and seconds should be zeroed out
        calendar.setTime(roundedDate);
        Assertions.assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
        Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToMinute() throws Exception {
        // Given a specific date and time
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 10, 45, 30);
        Date date = calendar.getTime();
        // When rounding to minute
        Date roundedDate = invokeRound(date, Calendar.MINUTE);
        // Then the seconds should be zeroed out
        calendar.setTime(roundedDate);
        Assertions.assertEquals(10, calendar.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(45, calendar.get(Calendar.MINUTE));
        Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToDay() throws Exception {
        // Given a specific date and time
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 5, 10, 45, 30);
        Date date = calendar.getTime();
        // When rounding to day
        Date roundedDate = invokeRound(date, Calendar.DATE);
        // Then the time should be set to the start of the day
        calendar.setTime(roundedDate);
        Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
        Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToMonth() throws Exception {
        // Given a specific date and time
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 15, 10, 45, 30);
        Date date = calendar.getTime();
        // When rounding to month
        Date roundedDate = invokeRound(date, Calendar.MONTH);
        // Then the date should be set to the first day of the month, time zeroed out
        calendar.setTime(roundedDate);
        Assertions.assertEquals(2023, calendar.get(Calendar.YEAR));
        Assertions.assertEquals(Calendar.OCTOBER, calendar.get(Calendar.MONTH));
        Assertions.assertEquals(1, calendar.get(Calendar.DATE));
        Assertions.assertEquals(0, calendar.get(Calendar.HOUR_OF_DAY));
        Assertions.assertEquals(0, calendar.get(Calendar.MINUTE));
        Assertions.assertEquals(0, calendar.get(Calendar.SECOND));
    }

    private Date invokeRound(Date date, int field) throws Exception {
        Method method = DateUtils.class.getDeclaredMethod("round", Date.class, int.class);
        method.setAccessible(true);
        return (Date) method.invoke(null, date, field);
    }
}
