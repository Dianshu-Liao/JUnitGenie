package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.FieldPosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.LocaleUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;

public class FastDatePrinter_applyRules_4_0_Test {

    private FastDatePrinter fastDatePrinter;

    @BeforeEach
    public void setUp() {
        // Set up a FastDatePrinter instance with a simple pattern
        fastDatePrinter = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testApplyRules_withValidCalendar() {
        Calendar calendar = Calendar.getInstance();
        // Setting a specific date
        calendar.set(2023, Calendar.OCTOBER, 1);
        StringBuffer buffer = new StringBuffer();
        fastDatePrinter.applyRules(calendar, buffer);
        // Assuming the applyRules method appends the formatted date to the buffer
        assertEquals("2023-10-01", buffer.toString());
    }

    @Test
    public void testApplyRules_withDifferentLocale() {
        FastDatePrinter datePrinterWithLocale = new FastDatePrinter("dd MMMM yyyy", TimeZone.getDefault(), Locale.FRANCE);
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 1);
        StringBuffer buffer = new StringBuffer();
        datePrinterWithLocale.applyRules(calendar, buffer);
        // Assuming the applyRules method appends the formatted date to the buffer
        assertEquals("01 octobre 2023", buffer.toString());
    }

    @Test
    public void testApplyRules_withDifferentTimeZone() {
        FastDatePrinter datePrinterWithTimeZone = new FastDatePrinter("yyyy-MM-dd HH:mm:ss", TimeZone.getTimeZone("GMT+2"), Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 1, 12, 0, 0);
        StringBuffer buffer = new StringBuffer();
        datePrinterWithTimeZone.applyRules(calendar, buffer);
        // Assuming the applyRules method appends the formatted date to the buffer
        assertEquals("2023-10-01 12:00:00", buffer.toString());
    }

    @Test
    public void testApplyRules_withEmptyBuffer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 1);
        StringBuffer buffer = new StringBuffer();
        fastDatePrinter.applyRules(calendar, buffer);
        // Assuming the applyRules method appends the formatted date to the buffer
        assertEquals("2023-10-01", buffer.toString());
    }

    @Test
    public void testApplyRules_withNullBuffer() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 1);
        // As applyRules does not handle null, we expect a NullPointerException
        try {
            fastDatePrinter.applyRules(calendar, null);
        } catch (NullPointerException e) {
            // Expected exception
        }
    }
}
