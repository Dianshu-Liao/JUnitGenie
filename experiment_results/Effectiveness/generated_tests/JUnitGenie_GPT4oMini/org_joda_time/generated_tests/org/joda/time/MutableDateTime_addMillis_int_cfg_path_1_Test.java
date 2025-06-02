package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_addMillis_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddMillis() {
        // Arrange
        MutableDateTime mutableDateTime = new MutableDateTime(2021, 1, 1, 0, 0, 0, 0);
        int millisToAdd = 1000; // Adding 1000 milliseconds (1 second)

        // Act
        try {
            mutableDateTime.addMillis(millisToAdd);
        } catch (Exception e) {
            fail("Exception thrown during addMillis: " + e.getMessage());
        }

        // Assert
        assertEquals("Expected millis to be increased by 1000", 
                     1000, mutableDateTime.getMillis() - new MutableDateTime(2021, 1, 1, 0, 0, 0, 0).getMillis());
    }

    @Test(timeout = 4000)
    public void testAddMillisWithZero() {
        // Arrange
        MutableDateTime mutableDateTime = new MutableDateTime(2021, 1, 1, 0, 0, 0, 0);
        int millisToAdd = 0; // Adding 0 milliseconds

        // Act
        try {
            mutableDateTime.addMillis(millisToAdd);
        } catch (Exception e) {
            fail("Exception thrown during addMillis: " + e.getMessage());
        }

        // Assert
        assertEquals("Expected millis to remain the same when adding 0", 
                     0, mutableDateTime.getMillis() - new MutableDateTime(2021, 1, 1, 0, 0, 0, 0).getMillis());
    }

}