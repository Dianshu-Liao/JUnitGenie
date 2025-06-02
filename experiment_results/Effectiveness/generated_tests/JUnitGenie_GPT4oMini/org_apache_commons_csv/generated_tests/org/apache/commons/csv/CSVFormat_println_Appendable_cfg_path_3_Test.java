package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.IOException;
import java.io.StringWriter;
import static org.junit.Assert.assertEquals;

public class CSVFormat_println_Appendable_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPrintlnWithTrailingDelimiterFalse() {
        // Arrange
        CSVFormat csvFormat = CSVFormat.DEFAULT.withRecordSeparator("\n").withTrailingDelimiter(false).withDelimiter(',');

        StringWriter writer = new StringWriter();

        // Act
        try {
            csvFormat.print(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Assert
        assertEquals("\n", writer.toString()); // Check if the output is as expected
    }


}