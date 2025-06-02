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

public class FastDateParser_init_12_1_Test {

    private FastDateParser fastDateParser;

    private Calendar definingCalendar;

    @BeforeEach
    public void setUp() {
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getDefault();
        Locale locale = Locale.getDefault();
        fastDateParser = new FastDateParser(pattern, timeZone, locale);
        definingCalendar = Calendar.getInstance(timeZone, locale);
    }

    @Test
    public void testInitializationWithValidCalendar() {
        // Since we cannot access patterns directly, we will check if the FastDateParser initialized correctly
        assertNotNull(fastDateParser, "FastDateParser should be initialized.");
    }

    @Test
    public void testInitializationWithDifferentTimeZone() {
        TimeZone newTimeZone = TimeZone.getTimeZone("GMT");
        fastDateParser = new FastDateParser("yyyy-MM-dd", newTimeZone, Locale.getDefault());
        assertNotNull(fastDateParser, "FastDateParser should be initialized with a different timezone.");
    }

    @Test
    public void testInitializationWithJapaneseImperialLocale() {
        Locale japaneseLocale = new Locale("ja", "JP", "JP");
        fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), japaneseLocale);
        assertNotNull(fastDateParser, "FastDateParser should be initialized with Japanese Imperial Locale.");
    }

    @Test
    public void testInitializationWithDifferentPattern() {
        String newPattern = "dd/MM/yyyy";
        fastDateParser = new FastDateParser(newPattern, TimeZone.getDefault(), Locale.getDefault());
        assertNotNull(fastDateParser, "FastDateParser should be initialized with a different pattern.");
    }
}
