package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.commons.lang3.time.FastDatePrinter;
import java.util.Locale;
import java.util.TimeZone;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

class FastDateFormat_equals_18_0_Test {

    @Test
    void testEquals_SameInstance() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertTrue(format.equals(format), "An instance should be equal to itself.");
    }

    @Test
    void testEquals_DifferentClass() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String notAFastDateFormat = "Not a FastDateFormat instance";
        assertFalse(format.equals(notAFastDateFormat), "Different class should not be equal.");
    }

    @Test
    void testEquals_Null() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertFalse(format.equals(null), "Null should not be equal.");
    }

    @Test
    void testEquals_DifferentPatterns() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("dd/MM/yyyy", TimeZone.getDefault(), Locale.getDefault());
        assertFalse(format1.equals(format2), "Different patterns should not be equal.");
    }

    @Test
    void testEquals_SamePatternsDifferentTimeZones() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("UTC"), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.getDefault());
        assertTrue(format1.equals(format2), "Same patterns with different time zones should be equal.");
    }

    @Test
    void testEquals_SamePatternsSameTimeZonesDifferentLocales() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.FRANCE);
        assertTrue(format1.equals(format2), "Same patterns with different locales should be equal.");
    }

    @Test
    void testEquals_SamePatternsSameTimeZonesSameLocale() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
        assertTrue(format1.equals(format2), "Same patterns, time zones, and locales should be equal.");
    }
}
