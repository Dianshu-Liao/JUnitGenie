package org.apache.commons.lang3.time;

import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;
import java.lang.reflect.Method;
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

class FastDatePrinter_applyRules_4_0_Test {

    private FastDatePrinter fastDatePrinter;

    @BeforeEach
    void setUp() {
        // Initialize FastDatePrinter with a sample pattern, timezone, and locale
        fastDatePrinter = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    void testApplyRules() throws Exception {
        // Prepare test data
        Calendar calendar = Calendar.getInstance();
        StringBuffer buf = new StringBuffer();
        // Invoke the private applyRules method using reflection
        Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, StringBuffer.class);
        method.setAccessible(true);
        StringBuffer result = (StringBuffer) method.invoke(fastDatePrinter, calendar, buf);
        // Validate the result
        assertEquals(buf.toString(), result.toString());
    }

    @Test
    void testApplyRulesWithDifferentCalendar() throws Exception {
        // Prepare different test data
        Calendar calendar = Calendar.getInstance();
        // Set a specific date
        calendar.set(2023, Calendar.OCTOBER, 1);
        StringBuffer buf = new StringBuffer();
        // Invoke the private applyRules method using reflection
        Method method = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, StringBuffer.class);
        method.setAccessible(true);
        StringBuffer result = (StringBuffer) method.invoke(fastDatePrinter, calendar, buf);
        // Validate the result
        assertEquals(buf.toString(), result.toString());
    }
}
