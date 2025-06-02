package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import java.io.StringWriter;
import java.lang.reflect.Method;
import static org.junit.Assert.assertEquals;

public class CSVFormat_print_Object_CharSequence_Appendable_boolean_cfg_path_8_Test {

    @Test(timeout = 4000)
    public void testPrintWithObjectNotNull() {
        try {
            // Arrange
            CSVFormat csvFormat = CSVFormat.DEFAULT; // Use the default CSVFormat
            StringWriter writer = new StringWriter();
            Object object = new Object(); // Example object
            CharSequence value = "Test Value";
            boolean newRecord = false;

            // Access the private method using reflection
            Method printMethod = CSVFormat.class.getDeclaredMethod("print", Object.class, CharSequence.class, Appendable.class, boolean.class);
            printMethod.setAccessible(true);

            // Act
            printMethod.invoke(csvFormat, object, value, writer, newRecord);

            // Assert
            assertEquals("Expected output after print method", "Test Value", writer.toString());
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

    @Test(timeout = 4000)
    public void testPrintWithObjectNull() {
        try {
            // Arrange
            CSVFormat csvFormat = CSVFormat.DEFAULT; // Use the default CSVFormat
            StringWriter writer = new StringWriter();
            Object object = null; // Null object
            CharSequence value = "Test Value";
            boolean newRecord = false;

            // Access the private method using reflection
            Method printMethod = CSVFormat.class.getDeclaredMethod("print", Object.class, CharSequence.class, Appendable.class, boolean.class);
            printMethod.setAccessible(true);

            // Act
            printMethod.invoke(csvFormat, object, value, writer, newRecord);

            // Assert
            assertEquals("Expected output after print method", "Test Value", writer.toString());
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
        }
    }

}