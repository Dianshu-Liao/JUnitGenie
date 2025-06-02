package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.InternalParser;
import org.joda.time.format.InternalPrinter;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class format_DateTimeFormatter_isParser__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testIsParserWhenIParserIsNull() {
        // Create an instance of DateTimeFormatter with a null InternalParser
        // Specify the correct type for the first parameter to avoid ambiguity
        InternalPrinter printer = null; // Assuming we want to use InternalPrinter
        InternalParser parser = null; // The parser is null as per the test case
        DateTimeFormatter formatter = new DateTimeFormatter(printer, parser);
        
        // Call the isParser method and assert that it returns false
        try {
            boolean result = formatter.isParser();
            assertFalse(result);
        } catch (Exception e) {
            // Handle any unexpected exceptions
            e.printStackTrace();
        }
    }


}