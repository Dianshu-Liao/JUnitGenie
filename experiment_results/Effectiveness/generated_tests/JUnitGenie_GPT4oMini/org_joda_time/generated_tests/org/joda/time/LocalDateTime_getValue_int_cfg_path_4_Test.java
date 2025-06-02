package org.joda.time;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class LocalDateTime_getValue_int_cfg_path_4_Test {

    @Test(timeout = 4000)
    public void testGetValueInvalidIndex() {
        LocalDateTime localDateTime = new LocalDateTime();
        try {
            localDateTime.getValue(-1); // Testing with an invalid index
            fail("Expected IndexOutOfBoundsException to be thrown");
        } catch (IndexOutOfBoundsException e) {
            assertEquals("Invalid index: -1", e.getMessage());
        }
    }

}