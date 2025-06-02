package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormat_equals_Object_cfg_path_24_Test {

    @Test(timeout = 4000)
    public void testEqualsWithSameReference() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertTrue(format.equals(format));
    }

    @Test(timeout = 4000)
    public void testEqualsWithNull() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEqualsWithDifferentClass() {
        CSVFormat format = CSVFormat.DEFAULT;
        String differentClassObject = "Not a CSVFormat";
        assertFalse(format.equals(differentClassObject));
    }

}