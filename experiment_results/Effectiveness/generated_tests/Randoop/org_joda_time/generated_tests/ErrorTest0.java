package org.joda.time;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ErrorTest0 {

    public static boolean debug = false;

    @Test
    public void test1() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test1");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        DateMidnight dateMidnight17 = dateMidnight1.minus((long) 10080);
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on dateMidnight1 and dateMidnight15", (dateMidnight1.compareTo(dateMidnight15) == 0) == dateMidnight1.equals(dateMidnight15));
    }

    @Test
    public void test2() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test2");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        DateTimeField dateTimeField16 = ethiopicChronology8.clockhourOfHalfday();
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on dateMidnight1 and dateMidnight15", (dateMidnight1.compareTo(dateMidnight15) == 0) == dateMidnight1.equals(dateMidnight15));
    }

    @Test
    public void test3() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test3");
        org.joda.time.chrono.EthiopicChronology ethiopicChronology0 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone1 = ethiopicChronology0.getZone();
        Weeks weeks2 = Weeks.ONE;
        int[] intArray5 = ethiopicChronology0.get((ReadablePeriod) weeks2, (long) (short) 1, 100L);
        DurationField durationField6 = ethiopicChronology0.eras();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Object obj10 = null;
        Chronology chronology11 = null;
        Interval interval12 = new Interval(obj10, chronology11);
        Weeks weeks13 = Weeks.ONE;
        Interval interval14 = interval12.withPeriodAfterStart((ReadablePeriod) weeks13);
        int[] intArray17 = ethiopicChronology8.get((ReadablePeriod) weeks13, (long) (short) -1, (long) (short) -1);
        DurationField durationField18 = ethiopicChronology8.minutes();
        YearMonthDay yearMonthDay19 = new YearMonthDay(100L, (Chronology) ethiopicChronology8);
        DateTime dateTime20 = yearMonthDay19.toDateTimeAtMidnight();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology21 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone22 = ethiopicChronology21.getZone();
        long long26 = dateTimeZone22.convertLocalToUTC((long) 6, false, 0L);
        LocalDate localDate27 = new LocalDate(dateTimeZone22);
        int int29 = dateTimeZone22.getOffset((long) '#');
        DateTime dateTime30 = yearMonthDay19.toDateTimeAtCurrentTime(dateTimeZone22);
        Chronology chronology31 = ethiopicChronology0.withZone(dateTimeZone22);
        org.junit.Assert.assertTrue("Contract failed: compareTo-anti-symmetric on durationField6 and durationField18", Math.signum(durationField6.compareTo(durationField18)) == -Math.signum(durationField18.compareTo(durationField6)));
    }

    @Test
    public void test4() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test4");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        DateTimeField dateTimeField16 = ethiopicChronology8.clockhourOfDay();
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on dateMidnight1 and dateMidnight15", (dateMidnight1.compareTo(dateMidnight15) == 0) == dateMidnight1.equals(dateMidnight15));
    }

    @Test
    public void test5() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test5");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        org.joda.time.chrono.StrictChronology strictChronology16 = org.joda.time.chrono.StrictChronology.getInstance((Chronology) ethiopicChronology8);
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on dateMidnight1 and dateMidnight15", (dateMidnight1.compareTo(dateMidnight15) == 0) == dateMidnight1.equals(dateMidnight15));
    }

    @Test
    public void test6() throws Throwable {
        if (debug)
            System.out.format("%n%s%n", "ErrorTest0.test6");
        DateMidnight dateMidnight1 = new DateMidnight(0L);
        DateMidnight dateMidnight3 = new DateMidnight(0L);
        boolean boolean4 = dateMidnight1.isEqual((ReadableInstant) dateMidnight3);
        int int5 = dateMidnight1.getSecondOfDay();
        org.joda.time.chrono.EthiopicChronology ethiopicChronology8 = org.joda.time.chrono.EthiopicChronology.getInstance();
        DateTimeZone dateTimeZone9 = ethiopicChronology8.getZone();
        Weeks weeks10 = Weeks.ONE;
        int[] intArray13 = ethiopicChronology8.get((ReadablePeriod) weeks10, (long) (short) 1, 100L);
        Period period14 = new Period((long) (short) 0, (long) 'a', (Chronology) ethiopicChronology8);
        DateMidnight dateMidnight15 = dateMidnight1.withChronology((Chronology) ethiopicChronology8);
        String str16 = ethiopicChronology8.toString();
        org.junit.Assert.assertTrue("Contract failed: compareTo-equals on dateMidnight1 and dateMidnight15", (dateMidnight1.compareTo(dateMidnight15) == 0) == dateMidnight1.equals(dateMidnight15));
    }
}

