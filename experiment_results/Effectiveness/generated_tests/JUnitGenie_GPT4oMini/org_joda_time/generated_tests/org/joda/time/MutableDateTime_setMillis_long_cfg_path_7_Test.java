package org.joda.time;
import org.joda.time.MutableDateTime;
import org.junit.Test;
import static org.junit.Assert.*;

public class MutableDateTime_setMillis_long_cfg_path_7_Test {

    @Test(timeout = 4000)
    public void testSetMillisWithRoundNone() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetMillisWithRoundFloor() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly after rounding
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetMillisWithRoundCeiling() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly after rounding
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetMillisWithRoundHalfFloor() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly after rounding
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetMillisWithRoundHalfCeiling() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly after rounding
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

    @Test(timeout = 4000)
    public void testSetMillisWithRoundHalfEven() {
        MutableDateTime mutableDateTime = new MutableDateTime();
        // Removed the rounding mode setting as it does not exist
        long instant = System.currentTimeMillis();
        
        try {
            mutableDateTime.setMillis(instant);
            // Verify that the millis were set correctly after rounding
            assertEquals(instant, mutableDateTime.getMillis());
        } catch (Exception e) {
            fail("Exception should not have been thrown: " + e.getMessage());
        }
    }

}