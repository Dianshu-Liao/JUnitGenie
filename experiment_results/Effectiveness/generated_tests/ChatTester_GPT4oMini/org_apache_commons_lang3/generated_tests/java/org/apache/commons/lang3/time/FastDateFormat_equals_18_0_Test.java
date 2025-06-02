package org.apache.commons.lang3.time;

import java.util.Locale;
import java.util.TimeZone;
import org.mockito.*;
import org.junit.jupiter.api.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.Format;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class FastDateFormat_equals_18_0_Test {

    private FastDateFormat format1;

    private FastDateFormat format2;

    private FastDateFormat format3;

    @BeforeEach
    public void setUp() {
        // Assuming FastDatePrinter and FastDateParser are properly implemented
        format1 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        format2 = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        format3 = new FastDateFormat("MM/dd/yyyy", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testEquals_SameObject() {
        assertTrue(format1.equals(format1), "An object should be equal to itself");
    }

    @Test
    public void testEquals_SameValues() {
        assertTrue(format1.equals(format2), "Two FastDateFormat objects with the same printer should be equal");
    }

    @Test
    public void testEquals_DifferentValues() {
        assertFalse(format1.equals(format3), "Two FastDateFormat objects with different printers should not be equal");
    }

    @Test
    public void testEquals_Null() {
        assertFalse(format1.equals(null), "A FastDateFormat should not be equal to null");
    }

    @Test
    public void testEquals_DifferentType() {
        assertFalse(format1.equals("Some String"), "A FastDateFormat should not be equal to an object of a different type");
    }
}
