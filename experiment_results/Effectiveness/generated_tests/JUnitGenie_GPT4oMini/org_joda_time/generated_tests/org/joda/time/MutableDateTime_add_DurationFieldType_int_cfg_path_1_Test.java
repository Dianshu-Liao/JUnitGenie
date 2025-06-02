package org.joda.time;
import org.joda.time.MutableDateTime;
import org.joda.time.DurationFieldType;
import org.junit.Test;

public class MutableDateTime_add_DurationFieldType_int_cfg_path_1_Test {

    @Test(expected = IllegalArgumentException.class)
    public void testAddWithNullDurationFieldType() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        DurationFieldType type = null; // simulate null input
        int amount = 1; // arbitrary amount
        
        try {
            mutableDateTime.add(type, amount);
        } catch (IllegalArgumentException e) {
            // Do nothing, expected exception
        }
    }

}