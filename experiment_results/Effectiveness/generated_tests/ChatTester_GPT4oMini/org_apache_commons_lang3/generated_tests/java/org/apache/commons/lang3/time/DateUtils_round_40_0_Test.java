package org.apache.commons.lang3.time;

import org.junit.jupiter.api.function.Executable;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.extension.ExtendWith;
import java.text.ParseException;
import java.text.ParsePosition;
import java.util.Iterator;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.LocaleUtils;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.junit.jupiter.MockitoExtension;

class DateUtils_round_40_0_Test {

    @Test
    void testRoundWithDate() {
        // Given
        // June 1, 2021
        Date date = new Date(1622505600000L);
        int field = Calendar.MONTH;
        // When
        Date roundedDate = DateUtils.round(date, field);
        // Then
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(roundedDate);
        assertEquals(Calendar.JUNE, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testRoundWithCalendar() {
        // Given
        Calendar calendar = Calendar.getInstance();
        // June 15, 2021
        calendar.set(2021, Calendar.JUNE, 15);
        int field = Calendar.MONTH;
        // Fixed Buggy Line: Use calendar.getTime() to convert Calendar to Date
        Date roundedDate = DateUtils.round(calendar.getTime(), field);
        // Then
        Calendar resultCalendar = Calendar.getInstance();
        resultCalendar.setTime(roundedDate);
        assertEquals(Calendar.JUNE, resultCalendar.get(Calendar.MONTH));
        assertEquals(1, resultCalendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testRoundWithInvalidType() {
        // Given
        String invalidDate = "Not a Date or Calendar";
        int field = Calendar.MONTH;
        // When
        Executable executable = () -> DateUtils.round(invalidDate, field);
        // Then
        ClassCastException exception = assertThrows(ClassCastException.class, executable);
        assertEquals("Could not round " + invalidDate, exception.getMessage());
    }

    @Test
    void testRoundWithNullDate() {
        // Given
        Object nullDate = null;
        int field = Calendar.MONTH;
        // When
        Executable executable = () -> DateUtils.round(nullDate, field);
        // Then
        NullPointerException exception = assertThrows(NullPointerException.class, executable);
        assertEquals("date", exception.getMessage());
    }

    // Additional test method for rounding to different fields
    @Test
    void testRoundToYear() {
        // Given
        // June 1, 2021
        Date date = new Date(1622505600000L);
        int field = Calendar.YEAR;
        // When
        Date roundedDate = DateUtils.round(date, field);
        // Then
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(roundedDate);
        assertEquals(2021, calendar.get(Calendar.YEAR));
        assertEquals(1, calendar.get(Calendar.MONTH));
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
    }

    @Test
    void testRoundToDay() {
        // Given
        // June 1, 2021
        Date date = new Date(1622505600000L);
        int field = Calendar.DAY_OF_MONTH;
        // When
        Date roundedDate = DateUtils.round(date, field);
        // Then
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(roundedDate);
        assertEquals(1, calendar.get(Calendar.DAY_OF_MONTH));
        assertEquals(Calendar.JUNE, calendar.get(Calendar.MONTH));
    }
}
