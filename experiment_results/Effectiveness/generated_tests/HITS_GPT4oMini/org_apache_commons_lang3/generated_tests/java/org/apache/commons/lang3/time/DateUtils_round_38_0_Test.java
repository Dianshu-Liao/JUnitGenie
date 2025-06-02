package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.GregorianCalendar;
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

public class DateUtils_round_38_0_Test {

    @Test
    public void testRoundToSecond() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 29);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.SECOND);
        assertEquals(30, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToMinute() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 29);
        calendar.set(Calendar.SECOND, 29);
        calendar.set(Calendar.MILLISECOND, 500);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.MINUTE);
        assertEquals(30, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToHour() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 30);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 30);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.HOUR_OF_DAY);
        assertEquals(11, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToDay() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 30);
        calendar.set(Calendar.HOUR_OF_DAY, 10);
        calendar.set(Calendar.MINUTE, 30);
        calendar.set(Calendar.SECOND, 30);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.DATE);
        assertEquals(15, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToMonth() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 30);
        calendar.set(Calendar.DATE, 15);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.MONTH);
        assertEquals(Calendar.APRIL, rounded.get(Calendar.MONTH));
        assertEquals(1, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
    }

    @Test
    public void testRoundToYear() {
        Calendar calendar = new GregorianCalendar(2023, Calendar.MARCH, 15, 10, 30, 30);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        Calendar rounded = DateUtils.round((Calendar) calendar.clone(), Calendar.YEAR);
        assertEquals(2024, rounded.get(Calendar.YEAR));
        assertEquals(Calendar.JANUARY, rounded.get(Calendar.MONTH));
        assertEquals(1, rounded.get(Calendar.DATE));
    }
}
