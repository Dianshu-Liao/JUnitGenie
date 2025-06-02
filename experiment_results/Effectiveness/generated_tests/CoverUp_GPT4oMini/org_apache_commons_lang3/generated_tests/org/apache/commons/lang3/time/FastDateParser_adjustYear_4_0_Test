package org.apache.commons.lang3.time;

import org.apache.commons.lang3.time.FastDateParser;
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
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

class FastDateParser_adjustYear_4_0_Test {

    private FastDateParser fastDateParser;

    @BeforeEach
    void setUp() {
        fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    void testAdjustYear_WithTwoDigitYearGreaterThanStartYear() throws Exception {
        // Assuming startYear is 20, so 2025 should be returned
        int twoDigitYear = 25;
        int expectedYear = 2025;
        int actualYear = invokeAdjustYear(twoDigitYear);
        assertEquals(expectedYear, actualYear);
    }

    @Test
    void testAdjustYear_WithTwoDigitYearLessThanStartYear() throws Exception {
        // Assuming startYear is 20, so 2115 should be returned
        int twoDigitYear = 15;
        int expectedYear = 2115;
        int actualYear = invokeAdjustYear(twoDigitYear);
        assertEquals(expectedYear, actualYear);
    }

    private int invokeAdjustYear(int twoDigitYear) throws Exception {
        Method method = FastDateParser.class.getDeclaredMethod("adjustYear", int.class);
        method.setAccessible(true);
        return (int) method.invoke(fastDateParser, twoDigitYear);
    }
}
