package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.DateUtils;
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

class DateUtils_round_39_0_Test {

    @Test
    void testRoundToSecond() throws Exception {
        // July 1, 2021 12:00:00
        Date date = new Date(1625072400000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.SECOND);
        assertEquals(1625072400000L, roundedDate.getTime());
    }

    @Test
    void testRoundToMinute() throws Exception {
        // July 1, 2021 12:00:05
        Date date = new Date(1625072405000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.MINUTE);
        // Should round to 12:01:00
        assertEquals(1625072460000L, roundedDate.getTime());
    }

    @Test
    void testRoundToHour() throws Exception {
        // July 1, 2021 12:00:05
        Date date = new Date(1625072405000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.HOUR_OF_DAY);
        // Should round to 13:00:00
        assertEquals(1625076000000L, roundedDate.getTime());
    }

    @Test
    void testRoundToDay() throws Exception {
        // July 1, 2021 12:00:05
        Date date = new Date(1625072405000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.DATE);
        // Should round to July 2, 2021 00:00:00
        assertEquals(1625078400000L, roundedDate.getTime());
    }

    @Test
    void testRoundToMonth() throws Exception {
        // July 1, 2021 12:00:05
        Date date = new Date(1625072405000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.MONTH);
        // Should round to August 1, 2021 00:00:00
        assertEquals(1625097600000L, roundedDate.getTime());
    }

    @Test
    void testRoundToYear() throws Exception {
        // July 1, 2021 12:00:05
        Date date = new Date(1625072405000L);
        Date roundedDate = invokeRoundMethod(date, Calendar.YEAR);
        // Should round to January 1, 2022 00:00:00
        assertEquals(1672444800000L, roundedDate.getTime());
    }

    @Test
    void testRoundWithNullDate() {
        assertThrows(NullPointerException.class, () -> {
            invokeRoundMethod(null, Calendar.SECOND);
        });
    }

    @Test
    void testRoundWithInvalidField() {
        assertThrows(IllegalArgumentException.class, () -> {
            Date date = new Date();
            // Invalid field
            invokeRoundMethod(date, -1);
        });
    }

    private Date invokeRoundMethod(Date date, int field) throws Exception {
        Method method = DateUtils.class.getDeclaredMethod("round", Date.class, int.class);
        method.setAccessible(true);
        return (Date) method.invoke(null, date, field);
    }
}
