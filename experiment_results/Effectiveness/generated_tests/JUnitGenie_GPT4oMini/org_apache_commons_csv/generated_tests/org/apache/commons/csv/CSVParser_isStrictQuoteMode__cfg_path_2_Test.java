package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.QuoteMode;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class CSVParser_isStrictQuoteMode__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsStrictQuoteModeWithAllNonNull() {
        try {
            // Create a CSVFormat instance with ALL_NON_NULL quote mode
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.ALL_NON_NULL);
            // Create a CSVParser instance
            CSVParser parser = new CSVParser(new StringReader(""), format);
            
            // Access the private method isStrictQuoteMode using reflection
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);
            
            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(parser);
            assertTrue(result); // Expecting true since quote mode is ALL_NON_NULL
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testIsStrictQuoteModeWithNonNumeric() {
        try {
            // Create a CSVFormat instance with NON_NUMERIC quote mode
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.NON_NUMERIC);
            // Create a CSVParser instance
            CSVParser parser = new CSVParser(new StringReader(""), format);
            
            // Access the private method isStrictQuoteMode using reflection
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);
            
            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(parser);
            assertTrue(result); // Expecting true since quote mode is NON_NUMERIC
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}