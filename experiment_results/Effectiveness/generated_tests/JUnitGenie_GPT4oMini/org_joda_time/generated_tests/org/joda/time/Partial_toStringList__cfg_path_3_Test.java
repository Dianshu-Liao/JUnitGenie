package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class Partial_toStringList__cfg_path_3_Test {

    @Test(timeout = 4000)
    public void testToStringList() {
        // Arrange
        DateTimeFieldType[] types = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
        int[] values = {2023, 10};
        Partial partial = new Partial(types, values);

        // Act
        String result = partial.toStringList();

        // Assert
        String expected = "[year=2023, monthOfYear=10]";
        assertEquals(expected, result);
    }

}