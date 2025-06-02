package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.QuoteMode;
import org.junit.Test;
import java.io.StringReader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertTrue;

public class CSVParser_isStrictQuoteMode__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testIsStrictQuoteMode() {
        try {
            // Create an instance of CSVFormat with the required quote mode
            CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.ALL_NON_NULL);
            // Create an instance of CSVParser
            CSVParser parser = new CSVParser(new StringReader(""), format);

            // Access the private method using reflection
            Method method = CSVParser.class.getDeclaredMethod("isStrictQuoteMode");
            method.setAccessible(true);

            // Invoke the method and assert the result
            boolean result = (boolean) method.invoke(parser);
            assertTrue(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}