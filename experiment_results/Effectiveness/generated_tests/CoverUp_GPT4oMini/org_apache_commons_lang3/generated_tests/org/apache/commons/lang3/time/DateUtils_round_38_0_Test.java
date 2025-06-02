package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.DateUtils;
import java.util.Calendar;
import java.lang.reflect.Method;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;

class DateUtils_round_38_0_Test {

    @Test
    void testRoundCalendarToSecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10, 10, 10, 10);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.SECOND);
        assertEquals(10, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundCalendarToMinute() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10, 10, 10, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.MINUTE);
        assertEquals(10, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundCalendarToHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10, 10, 30, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.HOUR_OF_DAY);
        assertEquals(11, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundCalendarToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10, 23, 30, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.DATE);
        assertEquals(11, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundCalendarToMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 15, 23, 30, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.MONTH);
        assertEquals(Calendar.NOVEMBER, rounded.get(Calendar.MONTH));
        assertEquals(1, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundCalendarToYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.DECEMBER, 31, 23, 30, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = invokeRoundMethod(calendar, Calendar.YEAR);
        assertEquals(2024, rounded.get(Calendar.YEAR));
        assertEquals(0, rounded.get(Calendar.MONTH));
        assertEquals(1, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    void testRoundWithNullCalendar() {
        assertThrows(NullPointerException.class, () -> {
            invokeRoundMethod(null, Calendar.SECOND);
        });
    }

    @Test
    void testRoundWithInvalidField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10);
        assertThrows(IllegalArgumentException.class, () -> {
            invokeRoundMethod(calendar, -1);
        });
    }

    private Calendar invokeRoundMethod(Calendar calendar, int field) {
        try {
            Method method = DateUtils.class.getDeclaredMethod("round", Calendar.class, int.class);
            method.setAccessible(true);
            return (Calendar) method.invoke(null, calendar, field);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
