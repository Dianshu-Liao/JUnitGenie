package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.QuoteMode;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CSVParser_isStrictQuoteMode__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsStrictQuoteModeWhenAllNonNull() {
        try {
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.ALL_NON_NULL);
            CSVParser parser = new CSVParser(new StringReader("foo,bar"), format);
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(parser);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsStrictQuoteModeWhenNonNumeric() {
        try {
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.NON_NUMERIC);
            CSVParser parser = new CSVParser(new StringReader("foo,bar"), format);
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(parser);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsStrictQuoteModeWhenOther() {
        try {
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);
            CSVParser parser = new CSVParser(new StringReader("foo,bar"), format);
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);
            boolean result = (Boolean) method.invoke(parser);
            assertFalse(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}