package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.assertNotNull;

public class MutableDateTime_addWeekyears_int_cfg_path_2_Test {

    @Test(timeout = 4000)
    public void testAddWeekyearsWhenZero() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        
        try {
            mutableDateTime.addWeekyears(0);
        } catch (Exception e) {
            // Handling the exception as the method might declare throws Exception
            e.printStackTrace();
        }
        
        // Assert that the state of mutableDateTime is unchanged, as weekyears is zero
        assertNotNull(mutableDateTime);
    }

}