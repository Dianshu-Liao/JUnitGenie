package org.joda.time;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RegressionTest1 {

    public static boolean debug = false;

    @Test
    public void test501() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test501");
        DateTimeZone dateTimeZone1 = null;
        MutableDateTime mutableDateTime2 = new MutableDateTime((long) 10080, dateTimeZone1);
        DateMidnight dateMidnight4 = new DateMidnight(0L);
        DateMidnight dateMidnight6 = new DateMidnight(0L);
        boolean boolean7 = dateMidnight4.isEqual((ReadableInstant) dateMidnight6);
        int int8 = dateMidnight4.getSecondOfDay();
        DateMidnight dateMidnight10 = dateMidnight4.plus((long) 36000000);
        mutableDateTime2.setMillis((ReadableInstant) dateMidnight10);
        DateMidnight.Property property12 = dateMidnight10.weekyear();
        DateMidnight dateMidnight14 = property12.addWrapFieldToCopy(0);
        DateMidnight dateMidnight16 = property12.addWrapFieldToCopy(8);
        org.junit.Assert.assertTrue("'" + boolean7 + "' != '" + true + "'", boolean7 == true);
        org.junit.Assert.assertTrue("'" + int8 + "' != '" + 0 + "'", int8 == 0);
        org.junit.Assert.assertNotNull(dateMidnight10);
        org.junit.Assert.assertNotNull(property12);
        org.junit.Assert.assertNotNull(dateMidnight14);
        org.junit.Assert.assertNotNull(dateMidnight16);
    }

    @Test
    public void test502() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "RegressionTest1.test502");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology2 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone3 = ethiopicChronology2.getZone();
        Weeks weeks4 = Weeks.ONE;
        int[] intArray7 = ethiopicChronology2.get((ReadablePeriod) weeks4, (long) (short) 1, 100L);
        Period period8 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology2);
        DateTimeField dateTimeField9 = ethiopicChronology2.centuryOfEra();
        // The following exception was thrown during execution in test generation
        try {
            long long14 = ethiopicChronology2.getDateTimeMillis(1000, 12, (int) (short) 100, 86400000);
            org.junit.Assert.fail("Expected exception of type org.joda.time.IllegalFieldValueException; message: Value 86400000 for millisOfDay must be in the range [0,86399999]");
        } catch (IllegalFieldValueException e) {
            // Expected exception.
        }
        org.junit.Assert.assertNotNull(ethiopicChronology2);
        org.junit.Assert.assertNotNull(dateTimeZone3);
        org.junit.Assert.assertNotNull(weeks4);
        org.junit.Assert.assertNotNull(intArray7);
        org.junit.Assert.assertArrayEquals(intArray7, new int[] { 0 });
        org.junit.Assert.assertNotNull(dateTimeField9);
    }
}

