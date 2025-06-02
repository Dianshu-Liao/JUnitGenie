// Test method
package org.apache.commons.lang3.time;

import java.lang.reflect.Method;
import java.util.Locale;
import java.util.TimeZone;
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
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

public class FastDateParser_adjustYear_4_0_Test {

    private FastDateParser parser;

    @BeforeEach
    public void setUp() {
        // Assuming century is set to 2000 and startYear is set to 50
        parser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault()) {

            {
                // Using reflection to set private fields for testing
                try {
                    // Fixed the variable declaration
                    java.lang.reflect.Field centuryField = FastDateParser.class.getDeclaredField("century");
                    centuryField.setAccessible(true);
                    centuryField.setInt(this, 2000);
                    java.lang.reflect.Field startYearField = FastDateParser.class.getDeclaredField("startYear");
                    startYearField.setAccessible(true);
                    startYearField.setInt(this, 50);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    @Test
    public void testAdjustYear_WithValidTwoDigitYear() throws Exception {
        // Assuming century is set to 2000
        invokeAdjustYear(50, 2050);
    }

    @Test
    public void testAdjustYear_WithTwoDigitYearLessThanStartYear() throws Exception {
        // Assuming century is set to 2000
        invokeAdjustYear(30, 2030);
    }

    @Test
    public void testAdjustYear_WithTwoDigitYearEqualToStartYear() throws Exception {
        // Assuming century is set to 2000
        invokeAdjustYear(40, 2040);
    }

    @Test
    public void testAdjustYear_WithNegativeTwoDigitYear() throws Exception {
        // Assuming century is set to 2000
        invokeAdjustYear(-10, 1990);
    }

    private void invokeAdjustYear(int input, int expected) throws Exception {
        Method method = FastDateParser.class.getDeclaredMethod("adjustYear", int.class);
        method.setAccessible(true);
        int result = (int) method.invoke(parser, input);
        assertEquals(expected, result);
    }
}
