package org.joda.time.format;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.InternalParser;
import org.joda.time.format.InternalPrinter;
import org.junit.Test;
import static org.junit.Assert.assertFalse;

public class format_DateTimeFormatter_isParser__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testIsParserWhenIParserIsNull() {
        // Create an instance of DateTimeFormatter with a null InternalParser
        // Specify the InternalPrinter to avoid ambiguity
        InternalPrinter printer = null;
        InternalParser parser = null;
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