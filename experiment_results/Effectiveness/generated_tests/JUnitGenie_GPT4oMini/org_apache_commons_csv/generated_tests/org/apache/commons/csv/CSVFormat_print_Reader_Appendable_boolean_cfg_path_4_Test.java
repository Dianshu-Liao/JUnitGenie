package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class CSVFormat_print_Reader_Appendable_boolean_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testPrintWithQuotes() {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT.withQuote('"'); // Ensure quoteCharacter is set
        StringWriter writer = new StringWriter();
        StringReader reader = new StringReader("value1,value2");

        // Access the private method using reflection
        try {
            Method printMethod = CSVFormat.class.getDeclaredMethod("print", Reader.class, Appendable.class, boolean.class);
            printMethod.setAccessible(true);

            // Act
            printMethod.invoke(csvFormat, reader, writer, false);

            // Assert
            String expectedOutput = "value1,value2"; // Adjust based on actual expected output with quotes
            assertEquals(expectedOutput, writer.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}