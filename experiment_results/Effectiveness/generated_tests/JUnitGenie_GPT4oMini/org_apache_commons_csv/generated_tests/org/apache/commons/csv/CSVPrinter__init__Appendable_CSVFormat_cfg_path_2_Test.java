package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter__init__Appendable_CSVFormat_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testCSVPrinterInitialization() {
        StringWriter stringWriter = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT.withHeader("Header1", "Header2").withSkipHeaderRecord(true);
        
        try {
            CSVPrinter csvPrinter = new CSVPrinter(stringWriter, format);
            assertNotNull(csvPrinter);
        } catch (IOException e) {
            // Handle the exception as per rule 4
            e.printStackTrace();
        }
    }

}