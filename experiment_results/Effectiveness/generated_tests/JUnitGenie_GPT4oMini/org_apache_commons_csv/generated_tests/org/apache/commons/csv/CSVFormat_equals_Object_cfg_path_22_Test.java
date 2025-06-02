package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormat_equals_Object_cfg_path_22_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CSVFormat format = CSVFormat.DEFAULT; // Use a predefined format
        assertTrue(format.equals(format));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CSVFormat format = CSVFormat.DEFAULT; // Use a predefined format
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CSVFormat format = CSVFormat.DEFAULT; // Use a predefined format
        String differentClassObject = "Not a CSVFormat";
        assertFalse(format.equals(differentClassObject));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        CSVFormat format1 = CSVFormat.DEFAULT; // Use a predefined format
        CSVFormat format2 = CSVFormat.DEFAULT; // Use a predefined format
        assertTrue(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAutoFlush() {
        CSVFormat format1 = CSVFormat.DEFAULT.withAutoFlush(true); // Set autoFlush to true
        CSVFormat format2 = CSVFormat.DEFAULT.withAutoFlush(false); // Set autoFlush to false
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAllowMissingColumnNames() {
        CSVFormat format1 = CSVFormat.DEFAULT.withAllowMissingColumnNames(true); // Set allowMissingColumnNames to true
        CSVFormat format2 = CSVFormat.DEFAULT.withAllowMissingColumnNames(false); // Set allowMissingColumnNames to false
        assertFalse(format1.equals(format2));
    }


}