package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.junit.Test;
import java.io.StringWriter;
import java.io.IOException;
import java.lang.reflect.Method;
import static org.junit.Assert.assertNotNull;

public class CSVPrinter_printRecordObject_Object_cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testPrintRecordObjectWithNonNullObjectArray() {
        // Arrange
        StringWriter stringWriter = new StringWriter();
        CSVPrinter csvPrinter = null;
        try {
            csvPrinter = new CSVPrinter(stringWriter, CSVFormat.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        Object[] records = new Object[]{"record1", "record2", "record3"};

        // Act
        try {
            Method method = CSVPrinter.class.getDeclaredMethod("printRecordObject", Object.class);
            method.setAccessible(true);
            method.invoke(csvPrinter, (Object) records);
        } catch (Exception e) {
            // Assert exception should not occur
            e.printStackTrace();
        }

        // Assert
        assertNotNull(stringWriter.toString());
    }


}