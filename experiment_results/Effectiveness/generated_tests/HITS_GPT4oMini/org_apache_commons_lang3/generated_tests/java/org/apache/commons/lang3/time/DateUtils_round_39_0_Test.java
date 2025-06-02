package org.apache.commons.lang3.time;

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

    @Test
    public void testRoundToSecond() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 34, 56);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.SECOND);
        calendar.set(2023, Calendar.JANUARY, 1, 12, 34, 57);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testRoundToMinute() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 34, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.MINUTE);
        calendar.set(2023, Calendar.JANUARY, 1, 12, 35, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testRoundToHour() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 30, 30);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.HOUR_OF_DAY);
        calendar.set(2023, Calendar.JANUARY, 1, 13, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testRoundToDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.DATE);
        calendar.set(2023, Calendar.JANUARY, 2, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testRoundToMonth() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 15, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.MONTH);
        calendar.set(2023, Calendar.FEBRUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testRoundToYear() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 0, 0);
        calendar.set(Calendar.MILLISECOND, 500);
        Date date = calendar.getTime();
        Date roundedDate = DateUtils.round(date, Calendar.YEAR);
        calendar.set(2024, Calendar.JANUARY, 1, 0, 0, 0);
        calendar.set(Calendar.MILLISECOND, 0);
        Date expectedDate = calendar.getTime();
        assertEquals(expectedDate, roundedDate);
    }

    @Test
    public void testInvalidField() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1, 12, 0, 0);
        Date date = calendar.getTime();
        assertThrows(IllegalArgumentException.class, () -> {
            // Invalid field
            DateUtils.round(date, 999);
        });
    }
}
