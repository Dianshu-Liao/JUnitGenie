package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.DuplicateHeaderMode;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormat_equals_Object_cfg_path_18_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CSVFormat format = CSVFormat.DEFAULT; // Use the default instance
        assertTrue(format.equals(format));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CSVFormat format = CSVFormat.DEFAULT; // Use the default instance
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CSVFormat format = CSVFormat.DEFAULT; // Use the default instance
        String differentClassObject = "Not a CSVFormat";
        assertFalse(format.equals(differentClassObject));
    }




}
