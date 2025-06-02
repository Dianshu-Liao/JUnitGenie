package org.apache.commons.lang3.time;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
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

public class FastDateParser_init_12_0_Test {

    private FastDateParser fastDateParser;

    @BeforeEach
    public void setUp() {
        fastDateParser = new FastDateParser("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testInit() throws Exception {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        // Act
        Method initMethod = FastDateParser.class.getDeclaredMethod("init", Calendar.class);
        initMethod.setAccessible(true);
        initMethod.invoke(fastDateParser, calendar);
        // Assert
        Field patternsField = FastDateParser.class.getDeclaredField("patterns");
        patternsField.setAccessible(true);
        List<?> patterns = (List<?>) patternsField.get(fastDateParser);
        assertNotNull(patterns);
        assertFalse(patterns.isEmpty(), "Patterns list should not be empty after init method is called.");
    }
}
