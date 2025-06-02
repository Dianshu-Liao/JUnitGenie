package org.apache.commons.lang3.time;

import java.lang.reflect.Method;
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
        fastDatePrinter = new FastDatePrinter("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testApplyRules() throws Exception {
        // Prepare test data
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 10);
        StringBuffer buf = new StringBuffer();
        // Invoke the protected method using reflection
        Method applyRulesMethod = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, StringBuffer.class);
        applyRulesMethod.setAccessible(true);
        // Call the method
        StringBuffer result = (StringBuffer) applyRulesMethod.invoke(fastDatePrinter, calendar, buf);
        // Assert the expected output
        assertEquals("2023-10-10", result.toString());
    }

    @Test
    public void testApplyRulesWithDifferentDate() throws Exception {
        // Prepare test data
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.JANUARY, 1);
        StringBuffer buf = new StringBuffer();
        // Invoke the protected method using reflection
        Method applyRulesMethod = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, StringBuffer.class);
        applyRulesMethod.setAccessible(true);
        // Call the method
        StringBuffer result = (StringBuffer) applyRulesMethod.invoke(fastDatePrinter, calendar, buf);
        // Assert the expected output
        assertEquals("2023-01-01", result.toString());
    }

    @Test
    public void testApplyRulesWithEmptyBuffer() throws Exception {
        // Prepare test data
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.DECEMBER, 25);
        StringBuffer buf = new StringBuffer();
        // Invoke the protected method using reflection
        Method applyRulesMethod = FastDatePrinter.class.getDeclaredMethod("applyRules", Calendar.class, StringBuffer.class);
        applyRulesMethod.setAccessible(true);
        // Call the method
        StringBuffer result = (StringBuffer) applyRulesMethod.invoke(fastDatePrinter, calendar, buf);
        // Assert the expected output
        assertEquals("2023-12-25", result.toString());
    }
}
