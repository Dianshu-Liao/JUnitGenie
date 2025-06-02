package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class MutableDateTime_addMonths_int_cfg_path_1_Test {

    @Test(timeout = 4000)
    public void testAddMonths_Positive() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with a specific timestamp
        dateTime.addMonths(1); // Adding 1 month
        
        // Expected outcome calculation
        // Use the correct method to add months
        MutableDateTime expectedDateTime = new MutableDateTime(0);
        expectedDateTime.addMonths(1); // Correctly add 1 month
        
        long expectedMillis = expectedDateTime.getMillis(); // Compute the expected millis after adding 1 month
        
        assertEquals(expectedMillis, dateTime.getMillis());
    }

    @Test(timeout = 4000)
    public void testAddMonths_Negative() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with a specific timestamp
        dateTime.addMonths(-1); // Subtracting 1 month
        
        // Expected outcome calculation
        MutableDateTime expectedDateTime = new MutableDateTime(0);
        expectedDateTime.addMonths(-1); // Correctly subtract 1 month
        
        long expectedMillis = expectedDateTime.getMillis(); // Compute the expected millis after subtracting 1 month
        
        assertEquals(expectedMillis, dateTime.getMillis());
    }

    @Test(timeout = 4000)
    public void testAddMonths_Zero() {
        MutableDateTime dateTime = new MutableDateTime(0); // Initialize with a specific timestamp
        long initialMillis = dateTime.getMillis();
        dateTime.addMonths(0); // Adding zero months
        
        // After adding zero months, the millis should remain the same
        assertEquals(initialMillis, dateTime.getMillis());
    }
    
    @Test(timeout = 4000)
    public void testAddMonths_ThrowException() {
        try {
            MutableDateTime dateTime = new MutableDateTime(0);
            dateTime.addMonths(Integer.MAX_VALUE); // Test boundary condition
            // Include additional assertions or checks here if applicable
        } catch (Exception e) {
            // Handle the exception as necessary, perhaps log or assert message
            // For example, you could assert that the exception is of a specific type
            // assertTrue(e instanceof SomeExpectedException);
        }
    }

}