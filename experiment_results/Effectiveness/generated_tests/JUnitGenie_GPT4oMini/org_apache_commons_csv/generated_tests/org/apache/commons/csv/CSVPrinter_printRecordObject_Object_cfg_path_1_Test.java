package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class CSVPrinter_printRecordObject_Object_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testPrintRecordObjectWithSingleElementArray() {
        // Arrange
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        CSVPrinter csvPrinter = null;
        try {
            csvPrinter = new CSVPrinter(writer, format);
            Object[] input = new Object[]{"Test"};

            // Act
            Method method = CSVPrinter.class.getDeclaredMethod("printRecordObject", Object.class);
            method.setAccessible(true);
            method.invoke(csvPrinter, input);

            // Assert
            String expectedOutput = "Test\n"; // Assuming the printRecord method appends a newline
            assertEquals(expectedOutput, writer.toString());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (csvPrinter != null) {
                try {
                    csvPrinter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Test(timeout = 4000)
    public void testPrintRecordObjectWithNullArray() {
        // Arrange
        StringWriter writer = new StringWriter();
        CSVFormat format = CSVFormat.DEFAULT;
        CSVPrinter csvPrinter = null;
        try {
            csvPrinter = new CSVPrinter(writer, format);
            Object[] input = new Object[]{null};

            // Act
            Method method = CSVPrinter.class.getDeclaredMethod("printRecordObject", Object.class);
            method.setAccessible(true);
            method.invoke(csvPrinter, input);

            // Assert
            String expectedOutput = "null\n"; // Assuming the printRecord method handles null
            assertEquals(expectedOutput, writer.toString());
        } catch (IOException e) {
            // Handle the exception
            e.printStackTrace();
        } catch (Exception e) {
            // Handle the exception
            e.printStackTrace();
        } finally {
            if (csvPrinter != null) {
                try {
                    csvPrinter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}