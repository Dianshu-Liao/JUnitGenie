package org.apache.commons.csv;
import org.apache.commons.csv.CSVFormat;
import org.junit.Test;
import static org.junit.Assert.*;

public class CSVFormat_equals_Object_cfg_path_20_Test {

    @Test(timeout = 4000)
    public void testEquals_SameObjectReference() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertTrue(csvFormat.equals(csvFormat));
    }

    @Test(timeout = 4000)
    public void testEquals_NullObject() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertFalse(csvFormat.equals(null));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentClass() {
        CSVFormat csvFormat = CSVFormat.DEFAULT;
        assertFalse(csvFormat.equals("Not a CSVFormat"));
    }

    @Test(timeout = 4000)
    public void testEquals_EqualObjects() {
        CSVFormat csvFormat1 = CSVFormat.DEFAULT.withDelimiter(',').withAllowMissingColumnNames(true);
        CSVFormat csvFormat2 = CSVFormat.DEFAULT.withDelimiter(',').withAllowMissingColumnNames(true);
        assertTrue(csvFormat1.equals(csvFormat2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentDelimiter() {
        CSVFormat csvFormat1 = CSVFormat.DEFAULT.withDelimiter(',');
        CSVFormat csvFormat2 = CSVFormat.DEFAULT.withDelimiter(';');
        assertFalse(csvFormat1.equals(csvFormat2));
    }

    @Test(timeout = 4000)
    public void testEquals_DifferentAllowMissingColumnNames() {
        CSVFormat csvFormat1 = CSVFormat.DEFAULT.withAllowMissingColumnNames(true);
        CSVFormat csvFormat2 = CSVFormat.DEFAULT.withAllowMissingColumnNames(false);
        assertFalse(csvFormat1.equals(csvFormat2));
    }

    @Test(timeout = 4000)
    public void testEquals_CompleteEquivalence() {
        CSVFormat csvFormat1 = CSVFormat.Builder.create(CSVFormat.DEFAULT).setDelimiter(',').setAllowMissingColumnNames(true).setCommentMarker('#').build();
        CSVFormat csvFormat2 = CSVFormat.Builder.create(CSVFormat.DEFAULT).setDelimiter(',').setAllowMissingColumnNames(true).setCommentMarker('#').build();
        assertTrue(csvFormat1.equals(csvFormat2));
    }

    @Test(timeout = 4000)
    public void testEquals_IgnoreTrailingData() {
        CSVFormat csvFormat1 = CSVFormat.Builder.create(CSVFormat.DEFAULT).setIgnoreSurroundingSpaces(true).build();
        CSVFormat csvFormat2 = CSVFormat.Builder.create(CSVFormat.DEFAULT).setIgnoreSurroundingSpaces(false).build();
        assertFalse(csvFormat1.equals(csvFormat2));
    }


}