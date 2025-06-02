package org.apache.commons.lang3.time;

import java.util.Calendar;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
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

@ExtendWith(MockitoExtension.class)
public class DateUtils_round_38_0_Test {

    private Calendar calendar;

    @BeforeEach
    public void setUp() {
        calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 15, 10, 30, 45);
        calendar.set(Calendar.MILLISECOND, 500);
    }

    @Test
    public void testRoundToMinute() {
        Calendar rounded = DateUtils.round(calendar, Calendar.MINUTE);
        assertEquals(10, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(31, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToHour() {
        Calendar rounded = DateUtils.round(calendar, Calendar.HOUR_OF_DAY);
        assertEquals(11, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToDay() {
        Calendar rounded = DateUtils.round(calendar, Calendar.DATE);
        assertEquals(16, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToMonth() {
        Calendar rounded = DateUtils.round(calendar, Calendar.MONTH);
        // February (0-based)
        assertEquals(1, rounded.get(Calendar.MONTH));
        assertEquals(0, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundToYear() {
        Calendar rounded = DateUtils.round(calendar, Calendar.YEAR);
        assertEquals(2024, rounded.get(Calendar.YEAR));
        assertEquals(0, rounded.get(Calendar.MONTH));
        assertEquals(0, rounded.get(Calendar.DATE));
        assertEquals(0, rounded.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, rounded.get(Calendar.MINUTE));
        assertEquals(0, rounded.get(Calendar.SECOND));
        assertEquals(0, rounded.get(Calendar.MILLISECOND));
    }

    @Test
    public void testRoundWithNullCalendar() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.round((Calendar) null, Calendar.MINUTE);
        });
    }

    @Test
    public void testRoundWithInvalidField() {
        assertThrows(IllegalArgumentException.class, () -> {
            // Invalid field
            DateUtils.round(calendar, -1);
        });
    }
}
