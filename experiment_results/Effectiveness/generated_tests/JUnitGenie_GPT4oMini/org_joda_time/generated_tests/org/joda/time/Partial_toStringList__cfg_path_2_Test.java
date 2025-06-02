package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Partial_toStringList__cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testToStringList() {
        // Setup: Create an instance of Partial with sample data
        DateTimeFieldType[] types = new DateTimeFieldType[] {
            DateTimeFieldType.year(),
            DateTimeFieldType.monthOfYear(),
            DateTimeFieldType.dayOfMonth()
        };
        int[] values = new int[] { 2023, 10, 5 };
        Partial partial = new Partial(types, values);

        // Execute: Call the toStringList method
        String result = partial.toStringList();

        // Verify: Check the expected output
        String expected = "[year=2023, monthOfYear=10, dayOfMonth=5]";
        assertEquals(expected, result);
    }

}