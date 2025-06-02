package org.apache.commons.lang3.time;

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

public class FastDateFormat_equals_18_0_Test {

    @Test
    public void testEquals_SameObject() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertTrue(format.equals(format), "An object should be equal to itself.");
    }

    @Test
    public void testEquals_SameValues() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertTrue(format1.equals(format2), "Two FastDateFormat objects with the same values should be equal.");
    }

    @Test
    public void testEquals_DifferentPattern() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("MM/dd/yyyy", TimeZone.getDefault(), Locale.getDefault());
        assertFalse(format1.equals(format2), "FastDateFormat objects with different patterns should not be equal.");
    }

    @Test
    public void testEquals_DifferentTimeZone() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("UTC"), Locale.getDefault());
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getTimeZone("GMT+1"), Locale.getDefault());
        assertFalse(format1.equals(format2), "FastDateFormat objects with different time zones should not be equal.");
    }

    @Test
    public void testEquals_DifferentLocale() {
        FastDateFormat format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.US);
        FastDateFormat format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.FRANCE);
        assertFalse(format1.equals(format2), "FastDateFormat objects with different locales should not be equal.");
    }

    @Test
    public void testEquals_NonFastDateFormatObject() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String nonFastDateFormatObject = "Not a FastDateFormat";
        assertFalse(format.equals(nonFastDateFormatObject), "A FastDateFormat should not be equal to an object of a different type.");
    }

    @Test
    public void testEquals_Null() {
        FastDateFormat format = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        assertFalse(format.equals(null), "A FastDateFormat should not be equal to null.");
    }
}
