package org.joda.time;
import org.joda.time.Partial;
import org.joda.time.DateTimeFieldType;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;

public class Partial_getFormatter__cfg_path_10_Test {

    @Test(timeout = 4000)
    public void testGetFormatter() {
        // Arrange
        DateTimeFieldType[] types = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear()};
        Partial partial = new Partial(types, new int[]{2023, 10});

        // Act
        DateTimeFormatter formatter = null;
        try {
            formatter = partial.getFormatter();
        } catch (Exception e) {
            // Handle exception if necessary
        }

        // Assert
        assertNotNull(formatter);
        assertEquals(formatter, ISODateTimeFormat.forFields(Arrays.asList(types), true, false));
    }

}