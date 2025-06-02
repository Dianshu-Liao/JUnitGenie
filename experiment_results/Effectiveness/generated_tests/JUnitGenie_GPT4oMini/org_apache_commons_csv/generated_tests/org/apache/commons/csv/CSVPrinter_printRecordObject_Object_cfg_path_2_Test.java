package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printRecordObject_Object_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testPrintRecordObjectWithIterable() {
        // Arrange
        StringWriter writer = new StringWriter();
        CSVPrinter csvPrinter = null;
        try {
            csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
            List<String> iterableValue = new ArrayList<>();
            iterableValue.add("value1");
            iterableValue.add("value2");

            // Act
            Method method = CSVPrinter.class.getDeclaredMethod("printRecordObject", Object.class);
            method.setAccessible(true);
            method.invoke(csvPrinter, iterableValue);
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            // Close the CSVPrinter if it was created
            if (csvPrinter != null) {
                try {
                    csvPrinter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // Assert
        String expectedOutput = "value1,value2\n"; // Adjust based on actual CSV format
        assertEquals(expectedOutput, writer.toString());
    }


}