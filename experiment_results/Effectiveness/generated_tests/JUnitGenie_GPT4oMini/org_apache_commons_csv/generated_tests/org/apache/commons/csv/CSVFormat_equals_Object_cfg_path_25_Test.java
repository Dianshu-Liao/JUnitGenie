package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class CSVFormat_equals_Object_cfg_path_25_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObject() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertTrue(format.equals(format));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CSVFormat format = CSVFormat.DEFAULT;
        assertFalse(format.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CSVFormat format = CSVFormat.DEFAULT;
        String differentClassObject = "Not a CSVFormat";
        assertFalse(format.equals(differentClassObject));
    }

}