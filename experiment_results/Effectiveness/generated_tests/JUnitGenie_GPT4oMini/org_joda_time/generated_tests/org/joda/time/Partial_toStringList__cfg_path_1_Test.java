package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class Partial_toStringList__cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testToStringList() {
        DateTimeFieldType[] types = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
        int[] values = {2021, 12};

        Partial partial = new Partial(types, values);

        String expected = "[year=2021, monthOfYear=12]";
        String actual = partial.toStringList();

        assertEquals(expected, actual);
    }

}