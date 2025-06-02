package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormat_equals_Object_cfg_path_21_Test {

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

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        CSVFormat format1 = CSVFormat.DEFAULT;
        CSVFormat format2 = CSVFormat.DEFAULT;
        assertTrue(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAutoFlush() {
        CSVFormat format1 = CSVFormat.newFormat(',').withAutoFlush(true);
        CSVFormat format2 = CSVFormat.newFormat(',').withAutoFlush(false);
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAllowMissingColumnNames() {
        CSVFormat format1 = CSVFormat.newFormat(',').withAllowMissingColumnNames(false);
        CSVFormat format2 = CSVFormat.newFormat(',').withAllowMissingColumnNames(true);
        assertFalse(format1.equals(format2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentCommentMarker() {
        CSVFormat format1 = CSVFormat.newFormat(',').withCommentMarker(null);
        CSVFormat format2 = CSVFormat.newFormat(',').withCommentMarker('#');
        assertFalse(format1.equals(format2));
    }


}