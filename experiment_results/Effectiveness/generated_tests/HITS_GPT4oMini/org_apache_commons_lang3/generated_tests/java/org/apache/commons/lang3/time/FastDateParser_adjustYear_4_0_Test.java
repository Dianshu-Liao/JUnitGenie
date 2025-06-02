package org.apache.commons.lang3.time;

import java.lang.reflect.Method;
import java.util.TimeZone;
import java.util.Locale;
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
import java.util.Calendar;
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

public class FastDateParser_adjustYear_4_0_Test {

    private FastDateParser parser;

    @BeforeEach
    public void setUp() {
        parser = new FastDateParser("yyyy", TimeZone.getDefault(), Locale.getDefault(), new Date(0));
    }

    private int invokeAdjustYear(int year) throws Exception {
        Method method = FastDateParser.class.getDeclaredMethod("adjustYear", int.class);
        method.setAccessible(true);
        return (int) method.invoke(parser, year);
    }

    @Test
    public void testAdjustYear_TwoDigitYear_GreaterThanStartYear() throws Exception {
        int result = invokeAdjustYear(70);
        assertEquals(2070, result, "The adjusted year should be 2070 for a two-digit year of 70.");
    }

    @Test
    public void testAdjustYear_TwoDigitYear_LessThanStartYear() throws Exception {
        int result = invokeAdjustYear(30);
        assertEquals(2030, result, "The adjusted year should be 2030 for a two-digit year of 30.");
    }

    @Test
    public void testAdjustYear_TwoDigitYear_AtStartYear() throws Exception {
        int result = invokeAdjustYear(50);
        assertEquals(2050, result, "The adjusted year should be 2050 for a two-digit year of 50.");
    }

    @Test
    public void testAdjustYear_TwoDigitYear_NegativeValue() throws Exception {
        int result = invokeAdjustYear(-5);
        assertEquals(1995, result, "The adjusted year should be 1995 for a two-digit year of -5.");
    }
}
