package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.FastDateParser;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.ArraySorter;
import org.apache.commons.lang3.LocaleUtils;

class FastDateParser_init_12_1_Test {

    private FastDateParser fastDateParser;

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        fastDateParser = new FastDateParser(pattern, timeZone, locale);
        calendar = Calendar.getInstance(timeZone, locale);
    }

    @Test
    void testInit() throws Exception {
        // Use reflection to access the private init method
        java.lang.reflect.Method initMethod = FastDateParser.class.getDeclaredMethod("init", Calendar.class);
        initMethod.setAccessible(true);
        // Invoke the init method
        initMethod.invoke(fastDateParser, calendar);
        // Verify that patterns list is initialized and not null
        List<?> patterns = (List<?>) FastDateParser.class.getDeclaredField("patterns").get(fastDateParser);
        assertNotNull(patterns);
        assertTrue(patterns instanceof ArrayList);
    }

    @Test
    void testInitWithDifferentCalendar() throws Exception {
        // Use reflection to access the private init method
        java.lang.reflect.Method initMethod = FastDateParser.class.getDeclaredMethod("init", Calendar.class);
        initMethod.setAccessible(true);
        // Create a different Calendar instance
        Calendar differentCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"), Locale.US);
        // Invoke the init method
        initMethod.invoke(fastDateParser, differentCalendar);
        // Verify that patterns list is initialized and not null
        List<?> patterns = (List<?>) FastDateParser.class.getDeclaredField("patterns").get(fastDateParser);
        assertNotNull(patterns);
        assertTrue(patterns instanceof ArrayList);
    }
}
