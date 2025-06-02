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

public class FastDateParser_init_12_0_Test {

    private FastDateParser fastDateParser;

    @BeforeEach
    public void setUp() {
        // Initialize a FastDateParser instance with a sample pattern, timezone and locale
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        fastDateParser = new FastDateParser(pattern, timeZone, locale);
    }

    @Test
    public void testConstructorShouldInitializePatterns() {
        // Since the init method is called in the constructor, we can check if fastDateParser is initialized
        assertNotNull(fastDateParser, "FastDateParser instance should be initialized.");
    }

    @Test
    public void testConstructorShouldBeAbleToParseDate() {
        // Test if the FastDateParser can parse a date with the given pattern
        String dateString = "2023-10-01";
        Calendar calendar = Calendar.getInstance();
        calendar.set(2023, Calendar.OCTOBER, 1);
        assertDoesNotThrow(() -> {
            fastDateParser.parse(dateString, new ParsePosition(0));
        }, "Parsing the date string should not throw an exception.");
    }
}
